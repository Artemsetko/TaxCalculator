/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iface;

import gui.PaymentPanel;
import javax.swing.JFrame;
import taxcalculator.TaxBean;

/**
 *
 *
 */
public interface FileRW {
  public void readConfig(TaxBean taxes);
  public int doSave(PaymentPanel paypan, JFrame jfr);
}
