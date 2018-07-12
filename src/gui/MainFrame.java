/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import iface.FileRW;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import taxcalculator.TaxBean;

/**
 *
 * 
 */
public class MainFrame extends JFrame {

    private JFrame jfr;
    private TaxBean tax;
    private FileDialog fd;
    private PaymentPanel paypan;
    private static boolean saved;

    public static void doSave() {
        saved = true;
    }

    public static void notSave() {
        saved = false;
    }

    public MainFrame(String title, final TaxBean tax, final FileRW fw) {
        super(title);
        jfr = new JFrame(title);
        setSize(680, 680);
        setLocation(300, 10);
        setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        saved = false;
// Создание меню
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
// Создание пунктов меню   
        JMenu file = new JMenu("Файл");
        JMenu about = new JMenu("О программе");
// Добавление пунктов меню 
        jmb.add(file);
        jmb.add(about);
// Создание подпунктов меню Файл
        JMenuItem file_save = new JMenuItem("Сохранить");
// Задание подпунктам меню гарячих клавиш     
        file_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        file.add(file_save);
        file.addSeparator();
// Создание подпунктов меню Выход
        JMenuItem connect_exit = new JMenuItem("Выход");
// Задание подпунктам меню гарячих клавиш     
        connect_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        file.add(connect_exit);
// Создание подпунктов меню Справка
        JMenuItem help_about = new JMenuItem("О программе");
// Добавление подпунктов в меню Справка        
        about.add(help_about);

        paypan = new PaymentPanel(tax);
        add(paypan);

//Обработчики событий        
        connect_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        help_about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "<Html><h2>Домашний проект 'Расчет коммунальных платежей'</h2><br>"
                        + "<ul><u>Выполнил:</u>"
                        + "<li>Сетко Артём</li>"
                        + "</ul>"
                        + "Посвящается начинающим программистам</html>",
                        "О проекте",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        file_save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread() {
                    @Override
                    public void run() {
                        int res = fw.doSave(paypan, jfr);
                        if (res == 1) {
                            doSave();
                        } else {
                            notSave();
                        }
                    }
                }.start();
            }
        });

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (!saved) {
                    Object[] options = {"Да", "Нет", "Отмена"};
                    int res = JOptionPane.showOptionDialog(e.getWindow(),
                            "Сохранить результаты перед выходом?", "Внимание, результаты не сохранены!",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (res == JOptionPane.YES_OPTION) {
                        new Thread() {
                            @Override
                            public void run() {
                                fw.doSave(paypan, jfr);
                                System.exit(0);
                            }
                        }.start();
                    }
                    if (res == JOptionPane.NO_OPTION) {
                        e.getWindow().setVisible(false);
                        System.exit(0);
                    } else {
                        return;
                    }
                } else {
                    e.getWindow().setVisible(false);
                    System.exit(0);
                }
            }
        });
        setVisible(true);
    }
}
