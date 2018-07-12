/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works;

import gui.PaymentPanel;
import iface.FileRW;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import taxcalculator.TaxBean;

/**
 *
 * import taxcalculator.TaxBean;
 *
 * 
 */
public class FileWorker implements FileRW {

    private FileDialog fd;

    @Override
    public void readConfig(TaxBean taxes) {

        Properties props = new Properties();
        try {
            Path path = Paths.get(new File("config.ini").getAbsolutePath());
            props.load(new FileInputStream(new File(path.toString())));

            taxes.setRent(Double.valueOf(props.getProperty("RENT")));
            taxes.setWater(Double.valueOf(props.getProperty("WATER")));
            taxes.setGas(Double.valueOf(props.getProperty("GAS")));
            taxes.setLift(Double.valueOf(props.getProperty("LIFT")));
            taxes.setGarbage(Double.valueOf(props.getProperty("GARBAGE")));
            taxes.setHeating(Double.valueOf(props.getProperty("HEATING")));
            taxes.setPhone(Double.valueOf(props.getProperty("PHONE")));
            taxes.setInternet(Double.valueOf(props.getProperty("INTERNET")));
            taxes.setIntercom(Double.valueOf(props.getProperty("INTERCOM")));
            String[] str = props.getProperty("ELECTRICITY").split(";");
            double[] electro = new double[str.length];
            for (int i = 0; i < str.length; i++) {
                electro[i] = Double.valueOf(str[i]);
            }
            taxes.setElectricity(electro);
        } catch (IOException ex) {
            Logger.getLogger(FileWorker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int doSave(PaymentPanel paypan, JFrame jfr) {
        Map results = paypan.getResults();
        int res = 0;
        fd = new FileDialog(jfr, "Сохранить расчет как...", FileDialog.SAVE);
        fd.show();
        FileWriter fw;
        try {
            fw = new FileWriter(
                    fd.getDirectory()
                    + fd.getFile());
            fw.write("---------------------------------------------------------------------------------------------------\r\n");
            fw.write("\t\t\t\tПериод оплаты: " + results.get("month") + " " + results.get("year") + " год.\r\n");
            fw.write("---------------------------------------------------------------------------------------------------\r\n");
            fw.write("1. Электроэнергия. \tтекущие показания: \tпредыдущие показания: \tРасход, кВт*ч \tСумма, грн\r\n");
            fw.write("\r\n\t\t\t\t" + results.get("elcur") + "\t\t\t" + results.get("elpre") + "\t\t" + results.get("elq") + "\t\t" + results.get("elSum") + "\r\n");
            fw.write("___________________________________________________________________________________________________\r\n");
            fw.write("2. Вода холодная.  \tтекущие показания: \tпредыдущие показания: \tРасход, м.куб \tСумма, грн\r\n");
            fw.write("\r\n\t\t\t\t" + results.get("wcur") + "\t\t\t" + results.get("wpre") + "\t\t" + results.get("wq") + "\t\t" + results.get("wSum") + "\r\n");
            fw.write("___________________________________________________________________________________________________\r\n");
            fw.write("\r\n3.  Квартплата.\t\t\t\t\t\t\t\t\t\t" + results.get("flat") + " грн.\r\n");
            fw.write("___________________________________________________________________________________________________\r\n");
            fw.write("\r\n4.  Газ. \t\t\t\t\t\t\t\t\t\t" + results.get("gas") + " грн.\r\n");
            fw.write("___________________________________________________________________________________________________\r\n");
            fw.write("\r\n5.  Лифт.\t\t\t\t\t\t\t\t\t\t" + results.get("lift") + " грн.\r\n");
            fw.write("___________________________________________________________________________________________________\r\n");
            fw.write("\r\n6.  Вывоз мусора.\t\t\t\t\t\t\t\t\t" + results.get("litter") + " грн.\r\n");
            fw.write("___________________________________________________________________________________________________\r\n");
            fw.write("\r\n7.  Домофон.\t\t\t\t\t\t\t\t\t\t" + results.get("icom") + " грн.\r\n");
            fw.write("___________________________________________________________________________________________________\r\n");
            fw.write("\r\n8.  Отопление.\t\t\t\t\t\t\t\t\t\t" + results.get("heat") + " грн.\r\n");
            fw.write("___________________________________________________________________________________________________\r\n");
            fw.write("\r\n9.  Интернет.\t\t\t\t\t\t\t\t\t\t" + results.get("inet") + " грн.\r\n");
            fw.write("___________________________________________________________________________________________________\r\n");
            fw.write("\r\n10. Домашний телефон.\t\t\t\t\t\t\t\t\t" + results.get("tel") + " грн.\r\n");
            fw.write("___________________________________________________________________________________________________\r\n");
            fw.write("\r\n    ИТОГО к оплате:\t\t\t\t\t\t\t\t\t" + results.get("total") + " грн.\r\n");
            fw.write("___________________________________________________________________________________________________\r\n");

            fw.flush();
            fw.close();
            res = 1;
        } catch (IOException ex) {
            Logger.getLogger(FileWorker.class.getName()).log(Level.SEVERE, null, ex);
            res = 0;
        } finally {
            return res;
        }
    }

}
