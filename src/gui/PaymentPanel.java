/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import iface.Executor;
import iface.Factory;
import iface.FactoryCreator;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Label.CENTER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import taxcalculator.TaxBean;

/**
 *
 * 
 */
public class PaymentPanel extends JPanel {

    JComboBox month;
    JSpinner year;
    JTextField total;
    JTextField elcur;
    JTextField elpre;
    JTextField elq;
    JTextField elSum;
    JTextField wcur;
    JTextField wpre;
    JTextField wq;
    JTextField waterSum;
    JTextField flatSum;
    JTextField gasSum;
    JTextField liftSum;
    JTextField litterSum;
    JTextField icomSum;
    JTextField heatSum;
    JTextField inetSum;
    JTextField telSum;

    Map records = new HashMap<String, String>();
    Map results = new HashMap<String, String>();
    Executor calcul;

    public PaymentPanel(final TaxBean tax) {
        super();
//        setSize(new Dimension(700,680));        
        setLayout(new MigLayout());
        Font fnt = new Font("Serif", Font.PLAIN, 18);
        Font fntb = new Font("Serif", Font.BOLD, 20);
        Font fnti = new Font("Serif", Font.ITALIC, 15);
        JLabel per = new JLabel("Период оплаты: ");
        JLabel y = new JLabel(" год.");
        JLabel el = new JLabel("1. Электроэнергия, 1 кВт*ч = " + tax.getElectricity()[0]
                + "грн - <150 кВт*ч; " + tax.getElectricity()[1]
                + "грн - >150 кВт*ч.");
        el.setFont(fnt);
        per.setFont(fntb);
        y.setFont(fnt);
        String[] data = {"Январь", "Февраль", "Март", "Апрель", "Май",
            "Июнь", "Июль", "Август", "Сентябрь",
            "Октябрь", "Ноябрь", "Декабрь"};
        month = new JComboBox(data);
        month.setFont(fnt);
        year = new JSpinner(new SpinnerNumberModel(2014, 2000, 2100, 1));
        year.setFont(fnt);
        add(per);
        add(month, "gapleft 25");

        add(year, "align center");

        add(y, "align left,wrap 15");

        add(el, "span");
        JLabel cur = new JLabel("Текущие показ.");
        cur.setFont(fnti);
        add(cur);

        JLabel pre = new JLabel("Предыдущие показ.");
        pre.setFont(fnti);
        add(pre, "gapleft 20");

        JLabel q = new JLabel("Расход");
        q.setFont(fnti);
        add(q, "align center");

        JLabel s = new JLabel("Стоимость");
        s.setFont(fnti);
        add(s, "gapleft 30,wrap");
        elcur = new JTextField("0", CENTER);
        elcur.setFont(fnt);
        add(elcur, "width 100");
        elpre = new JTextField("0", CENTER);
        elpre.setFont(fnt);
        add(elpre, "gapleft 20,width 100");
        elq = new JTextField("0", CENTER);
        elq.setFont(fnt);
        elq.setEditable(false);
        add(elq, "gapleft 20, width 100");
        elSum = new JTextField("0", CENTER);
        elSum.setFont(fnt);
        add(elSum, "gapleft 30,width 100, wrap");

        JLabel wl = new JLabel("2. Вода, 1 куб = " + tax.getWater() + " грн.");
        wl.setFont(fnt);
        add(wl, "span, wrap");

        JLabel cur2 = new JLabel("Текущие показ.");
        cur2.setFont(fnti);
        add(cur2);

        JLabel pre2 = new JLabel("Предыдущие показ.");
        pre2.setFont(fnti);
        add(pre2, "gapleft 20");

        JLabel q2 = new JLabel("Расход");
        q2.setFont(fnti);
        add(q2, "align center");

        JLabel s2 = new JLabel("Стоимость");
        s2.setFont(fnti);
        add(s2, "gapleft 30,wrap");

        wcur = new JTextField("0", CENTER);
        wcur.setFont(fnt);
        add(wcur, "width 100");
        wpre = new JTextField("0", CENTER);
        wpre.setFont(fnt);
        add(wpre, "gapleft 20,width 100");
        wq = new JTextField("0", CENTER);
        wq.setFont(fnt);
        wq.setEditable(false);
        add(wq, "gapleft 20, width 100");
        waterSum = new JTextField("0", CENTER);
        waterSum.setFont(fnt);
        add(waterSum, "gapleft 30,width 100, wrap");

        JLabel fl = new JLabel("3. Квартплата");
        fl.setFont(fnt);
        add(fl);

        flatSum = new JTextField("" + tax.getRent(), CENTER);
        flatSum.setFont(fnt);
        add(flatSum, "cell 3 7,gapleft 30,width 100, wrap");

        JLabel gl = new JLabel("4. Газ");
        gl.setFont(fnt);
        add(gl);

        gasSum = new JTextField("" + tax.getGas(), CENTER);
        gasSum.setFont(fnt);
        add(gasSum, "cell 3 8,gapleft 30,width 100, wrap");

        JLabel ll = new JLabel("5. Лифт");
        ll.setFont(fnt);
        add(ll);

        liftSum = new JTextField("" + tax.getLift(), CENTER);
        liftSum.setFont(fnt);
        add(liftSum, "cell 3 9,gapleft 30,width 100, wrap");

        JLabel ml = new JLabel("6. Вывоз мусора");
        ml.setFont(fnt);
        add(ml);

        litterSum = new JTextField("" + tax.getGarbage(), CENTER);
        litterSum.setFont(fnt);
        add(litterSum, "cell 3 10,gapleft 30,width 100, wrap");

        JLabel icl = new JLabel("7. Домофон");
        icl.setFont(fnt);
        add(icl);

        icomSum = new JTextField("" + tax.getIntercom(), CENTER);
        icomSum.setFont(fnt);
        add(icomSum, "cell 3 11,gapleft 30,width 100, wrap");

        JLabel hl = new JLabel("8. Отопление");
        hl.setFont(fnt);
        add(hl);

        heatSum = new JTextField("" + tax.getHeating(), CENTER);
        heatSum.setFont(fnt);
        add(heatSum, "cell 3 12,gapleft 30,width 100, wrap");

        JLabel inetl = new JLabel("9. Интернет");
        inetl.setFont(fnt);
        add(inetl);

        inetSum = new JTextField("" + tax.getInternet(), CENTER);
        inetSum.setFont(fnt);
        add(inetSum, "cell 3 13,gapleft 30,width 100, wrap");

        JLabel tell = new JLabel("10. Домашний телефон");
        tell.setFont(fnt);
        add(tell);

        telSum = new JTextField("" + tax.getPhone(), CENTER);
        telSum.setFont(fnt);
        add(telSum, "cell 3 14,gapleft 30,width 100, wrap 20");

        final JButton calc = new JButton("Расчет");
        calc.setFont(fntb);
        calc.setPreferredSize(new Dimension(100, 50));
        add(calc, "cell 0 15, gapleft 50");

        JButton reset = new JButton("Сброс");
        reset.setFont(fntb);
        reset.setPreferredSize(new Dimension(100, 50));
        add(reset, "align left");

        JLabel tot = new JLabel("ИТОГО:");
        tot.setFont(fntb);
        add(tot, "align right");

        total = new JTextField();
        total.setFont(fntb);
        total.setEditable(false);
        total.setPreferredSize(new Dimension(120, 50));
        add(total, "span, gapleft 30");
        add(new JSeparator());

        calc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                records.put("month", month.getSelectedItem().toString());
                records.put("year", year.getValue().toString());
                records.put("elcur", elcur.getText());
                records.put("elpre", elpre.getText());
                records.put("wcur", wcur.getText());
                records.put("wpre", wpre.getText());
                records.put("flat", flatSum.getText());
                records.put("gas", gasSum.getText());
                records.put("lift", liftSum.getText());
                records.put("litter", litterSum.getText());
                records.put("icom", icomSum.getText());
                records.put("heat", heatSum.getText());
                records.put("inet", inetSum.getText());
                records.put("tel", telSum.getText());
                records.put("elSum", elSum.getText());
                records.put("wSum", waterSum.getText());

                new Thread() {
                    @Override
                    public void run() {

                        Factory fact = null;
                        try {
                            fact = FactoryCreator.getInstance();
                        } catch (Throwable ex) {
                            Logger.getLogger(PaymentPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        calcul = fact.getExecutor();
                        try {
                            results = calcul.doCalc(records, tax);
                            elq.setText(results.get("elq") + "");
                            wq.setText(results.get("wq") + "");
                            elSum.setText(results.get("elSum") + "");
                            waterSum.setText(results.get("wSum") + "");
                            total.setText(results.get("total") + " грн.");
                            MainFrame.notSave();
                        } catch (NumberFormatException | ArithmeticException ex) {
                            JOptionPane.showMessageDialog(PaymentPanel.this, ex.getMessage(), "Ошибка ввода данных", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }.start();
            }
        });
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                total.setText("");
                elcur.setText("0");
                elpre.setText("0");
                elq.setText("0");
                elSum.setText("0");
                wcur.setText("0");
                wpre.setText("0");
                wq.setText("0");
                waterSum.setText("0");
                flatSum.setText(tax.getRent() + "");
                gasSum.setText(tax.getGas() + "");
                liftSum.setText(tax.getLift() + "");
                litterSum.setText(tax.getGarbage() + "");
                icomSum.setText(tax.getIntercom() + "");
                heatSum.setText(tax.getHeating() + "");
                inetSum.setText(tax.getInternet() + "");
                telSum.setText(tax.getPhone() + "");
            }
        });
    }

    public Map getResults() {
        return results;
    }
}
