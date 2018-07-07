/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamgame;

public class CashRegister {
    private double credit;
    private double cash;
    private double total_money;
    
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    private int one_dollar;
    private int five_dollar;
    private int ten_dollar;
    private int twenty_dollar;
    
    public CashRegister()
    {
        credit = 50;
        
        pennies = 10;
        nickels = 10;
        dimes = 10;
        quarters = 10;
        one_dollar= 10;
        five_dollar= 1;
        ten_dollar  = 1;
        twenty_dollar = 1;
    }
    public void showCashInRegister()
    {
        System.out.printf("Pennies %d\n", this.pennies);
        System.out.printf("Nickels %d\n", this.nickels);
        System.out.printf("Dimes %d\n", this.dimes);
        System.out.printf("Quarters %d\n", this.quarters);
        System.out.printf("One %d\n", this.one_dollar);
        System.out.printf("Five %d\n", this.five_dollar);
        System.out.printf("Ten %d\n", this.ten_dollar);
        System.out.printf("Twenty %d\n", this.twenty_dollar);
    }
    public double getTotal_money()//return total amount in register
    {
        return getCredit()+getCash();
    }
    public double getCash()// return total cash
    {
        cash = .01*pennies+.05*nickels+.10*dimes+.25*quarters+1.0*one_dollar+5.0*five_dollar+10.0*ten_dollar+20.0*twenty_dollar;
        return cash;
    }
    
    public void setCash(long idNumber, String name, double credit,int pennies, 
            int nickels, int dimes, int quarters, int one_dollar, int five_dollar, int ten_dollar, int twenty_dollar)//set up the cash
    {
        this.credit = credit;
        this.pennies = pennies;
        this.nickels = nickels;
        this.dimes = dimes;
        this.quarters = quarters;
        this.one_dollar = one_dollar;
        this.five_dollar = five_dollar;
        this.ten_dollar = ten_dollar;
        this.twenty_dollar = twenty_dollar;
    }
    
    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit += credit;
         System.out.println("new cash register credit is "+ this.credit);
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
    
    
    
}
