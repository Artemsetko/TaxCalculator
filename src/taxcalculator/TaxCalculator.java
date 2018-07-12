/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalculator;

import gui.MainFrame;
import iface.Factory;
import iface.FactoryCreator;
import iface.FileRW;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class TaxCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaxBean tax = new TaxBean();
        FileRW frw = null;

        try {
            Factory fact = FactoryCreator.getInstance();
            frw = fact.getFileRW();
            frw.readConfig(tax);
        } catch (Throwable ex) {
            Logger.getLogger(TaxCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainFrame frame = new MainFrame("Расчет коммунальных платежей", tax, frw);
    }

}
