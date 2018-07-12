/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalculator;

import iface.Executor;
import iface.Factory;
import iface.FileRW;
import works.Calculator;
import works.FileWorker;


public class FactoryImpl implements Factory {
    static Factory fact = new FactoryImpl();
    @Override
    public Executor getExecutor() {
        Executor exec = new Calculator();
        return exec;
    }

    @Override
    public FileRW getFileRW() {
        FileRW frw = new FileWorker();
        return frw;
    }

    public static Factory createInstance() {        
        return fact;
    }

}
