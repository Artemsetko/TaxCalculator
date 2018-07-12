/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalculator;

/**
 *
 * 
 */
public class TaxBean {

    private static double RENT;
    private static double WATER;
    private static double[] ELECTRICITY;
    private static double GAS;
    private static double LIFT;
    private static double GARBAGE;
    private static double HEATING;
    private static double PHONE;
    private static double INTERNET;
    private static double INTERCOM;

    public TaxBean(double rent, double water, double[] electricity, double gas,
            double lift, double garbage, double heating, double phone,
            double internet, double intercom) {
        this.RENT = rent;
        this.WATER = water;
        this.ELECTRICITY = electricity;
        this.GAS = gas;
        this.LIFT = lift;
        this.GARBAGE = garbage;
        this.HEATING = heating;
        this.PHONE = phone;
        this.INTERNET = internet;
        this.INTERCOM = intercom;
    }

    /**
     * @return the RENT
     */
    public double getRent() {
        return RENT;
    }

    /**
     * @param aRENT the RENT to set
     */
    public void setRent(double aRENT) {
        RENT = aRENT;
    }

    public TaxBean() {
    }

    /**
     * @return the water
     */
    public double getWater() {
        return WATER;
    }

    /**
     * @param water the water to set
     */
    public void setWater(double water) {
        this.WATER = water;
    }

    /**
     * @return the electricity
     */
    public double[] getElectricity() {
        return ELECTRICITY;
    }

    /**
     * @param electricity the electricity to set
     */
    public void setElectricity(double[] electricity) {
        this.ELECTRICITY = electricity;
    }

    /**
     * @return the gas
     */
    public double getGas() {
        return GAS;
    }

    /**
     * @param gas the gas to set
     */
    public void setGas(double gas) {
        this.GAS = gas;
    }

    /**
     * @return the lift
     */
    public double getLift() {
        return LIFT;
    }

    /**
     * @param lift the lift to set
     */
    public void setLift(double lift) {
        this.LIFT = lift;
    }

    /**
     * @return the garbage
     */
    public double getGarbage() {
        return GARBAGE;
    }

    /**
     * @param garbage the garbage to set
     */
    public void setGarbage(double garbage) {
        this.GARBAGE = garbage;
    }

    /**
     * @return the heating
     */
    public double getHeating() {
        return HEATING;
    }

    /**
     * @param heating the heating to set
     */
    public void setHeating(double heating) {
        this.HEATING = heating;
    }

    /**
     * @return the phone
     */
    public double getPhone() {
        return PHONE;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(double phone) {
        this.PHONE = phone;
    }

    /**
     * @return the internet
     */
    public double getInternet() {
        return INTERNET;
    }

    /**
     * @param internet the internet to set
     */
    public void setInternet(double internet) {
        this.INTERNET = internet;
    }

    /**
     * @return the intercom
     */
    public double getIntercom() {
        return INTERCOM;
    }

    /**
     * @param intercom the intercom to set
     */
    public void setIntercom(double intercom) {
        this.INTERCOM = intercom;
    }

    @Override
    public String toString() {
        return "TaxBean [rent=" + RENT+ ", water=" + WATER + ", electricity="
                + ELECTRICITY[0]+";"+ELECTRICITY[1]+", gas=" + GAS + ", lift=" 
                + LIFT + ", garbage=" + GARBAGE + ", heating="+ HEATING + 
                ", phone=" + PHONE + ", internet=" + INTERNET + ", intercom="
                + INTERCOM + "]";
    }
}
