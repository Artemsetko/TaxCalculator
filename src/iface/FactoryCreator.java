/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iface;
import java.lang.reflect.Method;
/**
 *
 *
 */
public class FactoryCreator {
    private static Factory instance = null;
    private static Throwable ex = null;

    static {
        try {
            Class cl = Class.forName("taxcalculator.FactoryImpl");            
            Method method = cl.getMethod("createInstance", new Class[0]);            
            Object obj = method.invoke(cl, new Object[0]);            
            if(obj instanceof Factory) {
                instance = (Factory) obj;
            }
            ex = new Exception("Cannot init Factory instance.");
        } catch (Throwable throwable) {
            ex = throwable;
        }
    }

    public static Factory getInstance() throws Throwable {
        if(instance != null) {
            return instance;
        }
        
        throw ex;
    }
}
