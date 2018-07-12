/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works;

import iface.Executor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import taxcalculator.TaxBean;

/**
 *
 * 
 */
public class Calculator implements Executor {

    @Override
    public Map doCalc(Map rec, TaxBean tax) throws NumberFormatException, ArithmeticException {
        Set eset = rec.entrySet();
        for (Iterator it = eset.iterator(); it.hasNext();) {
            Entry entr = (Entry) it.next();
            if (entr.getValue().toString().isEmpty()) {
                entr.setValue("0");
            }
        }
        double elq = Double.valueOf(rec.get("elcur") + "") - Double.valueOf(rec.get("elpre") + "");
        double wq = Double.valueOf(rec.get("wcur") + "") - Double.valueOf(rec.get("wpre") + "");
        if (elq < 0.0 | wq < 0.0) {
            throw new ArithmeticException("Неверно внесены показания \r\n(предыдущие > текущих)");
        }
        double elSum;
        if (Double.valueOf(rec.get("elSum") + "") == 0.0) {
            if (elq < 150.0) {
                elSum = elq * tax.getElectricity()[0];
            } else {
                elSum = 150 * tax.getElectricity()[0] + (elq - 150) * tax.getElectricity()[1];
            }
        } else {
            elSum = Double.valueOf(rec.get("elSum") + "");
        }
        double wSum;
        if (Double.valueOf(rec.get("wSum") + "") == 0.0) {
            wSum = wq * tax.getWater();
        } else {
            wSum = Double.valueOf(rec.get("wSum") + "");
        }
        double total = elSum
                + wSum
                + Double.valueOf(rec.get("flat") + "")
                + Double.valueOf(rec.get("gas") + "")
                + Double.valueOf(rec.get("lift") + "")
                + Double.valueOf(rec.get("litter") + "")
                + Double.valueOf(rec.get("icom") + "")
                + Double.valueOf(rec.get("heat") + "")
                + Double.valueOf(rec.get("inet") + "")
                + Double.valueOf(rec.get("tel") + "");

        rec.put("elq", new BigDecimal(elq).setScale(3, RoundingMode.UP).toPlainString());
        rec.put("wq", new BigDecimal(wq).setScale(3, RoundingMode.UP).toPlainString());
        rec.put("elSum", new BigDecimal(elSum).setScale(3, RoundingMode.UP).toPlainString());
        rec.put("wSum", new BigDecimal(wSum).setScale(3, RoundingMode.UP).toPlainString());
        rec.put("total", new BigDecimal(total).setScale(2, RoundingMode.UP).toPlainString());

        return rec;
    }

}
