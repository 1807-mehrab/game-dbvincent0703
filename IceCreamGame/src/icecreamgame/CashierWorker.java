/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamgame;
/**
 *
 * @author vb
 */
public class CashierWorker extends Worker{

    int patience;
    boolean onBreak;
    public CashierWorker(String t,long id, String n, long served, long sc, double money,boolean onBreak) //constructor
    {
        super(t,id, n, served, sc, money);
        patience = 18;
        this.onBreak = onBreak;
    }
    //below are getters and setters
     public int getPatience() {
        return patience;
    }

    public void setPatience(int patience) {
        this.patience += patience;
    }

    public boolean isOnBreak() {
        return onBreak;
    }

    public void setOnBreak(boolean onBreak) {
        this.onBreak = onBreak;
    }
    
}
