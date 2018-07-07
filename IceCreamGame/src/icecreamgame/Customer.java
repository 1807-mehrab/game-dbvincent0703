/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamgame;

public class Customer {
    private long idNumber; 
    private String name;
    private double credit;
    private int happylevel;
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    private int one_dollar;
    private int five_dollar;
    private int ten_dollar;
    private int twenty_dollar;
    private double cash;
    private double cash_total;
    
    public Customer(long idNumber, String name, double cash_total, double credit,int pennies, 
            int nickels, int dimes, int quarters, int one_dollar, int five_dollar, int ten_dollar, int twenty_dollar)
    {
        this.idNumber = idNumber;
        this.name = name;
        this.cash_total = cash_total;
        this.credit = credit;
        this.pennies = pennies;
        this.nickels = nickels;
        this.dimes = dimes;
        this.quarters = quarters;
        this.one_dollar = one_dollar;
        this.five_dollar = five_dollar;
        this.ten_dollar = ten_dollar;
        this.twenty_dollar = twenty_dollar;
        happylevel = 0;
        
    }
    //the below are the getters and setters for the attributes
    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getCredit() {
        return credit;
    }
    public void setCredit(double credit){
        this.credit = credit;
    }
    public void setPaymentCredit(double credit) {
        this.credit -= credit;
    }
    
    public double getCash()// return total cash
    {
        cash = .01*pennies+.05*nickels+.10*dimes+.25*quarters+1.0*one_dollar+5.0*five_dollar+10.0*ten_dollar+20.0*twenty_dollar;
        return cash;
    }
    
    public void setCash(int pennies, int nickels, int dimes, int quarters, int one_dollar, int five_dollar, int ten_dollar, int twenty_dollar)//set up the cash
    {
        this.pennies = pennies;
        this.nickels = nickels;
        this.dimes = dimes;
        this.quarters = quarters;
        this.one_dollar = one_dollar;
        this.five_dollar = five_dollar;
        this.ten_dollar = ten_dollar;
        this.twenty_dollar = twenty_dollar;
    }
    public int getHappylevel() {
        return happylevel;
    }

    public void setHappylevel(int happylevel) {
        this.happylevel += happylevel;
    }
    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getOne_dollar() {
        return one_dollar;
    }

    public void setOne_dollar(int one_dollar) {
        this.one_dollar = one_dollar;
    }

    public int getFive_dollar() {
        return five_dollar;
    }

    public void setFive_dollar(int five_dollar) {
        this.five_dollar = five_dollar;
    }

    public int getTen_dollar() {
        return ten_dollar;
    }

    public void setTen_dollar(int ten_dollar) {
        this.ten_dollar = ten_dollar;
    }

    public int getTwenty_dollar() {
        return twenty_dollar;
    }

    public void setTwenty_dollar(int twenty_dollar) {
        this.twenty_dollar = twenty_dollar;
    }

    public double getCash_total() {
        return cash_total;
    }

    public void setCash_total(double cash_total) {
        this.cash_total = cash_total;
    }

  
}

