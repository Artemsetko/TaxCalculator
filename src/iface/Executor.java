/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iface;

import java.util.Map;
import taxcalculator.TaxBean;

/**
 *
 *
 */
public interface Executor {
    public Map doCalc(Map rec, TaxBean tax);
    
}
