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
public class Stocker extends Worker{
    int stamina;

    boolean onBreak;
    public Stocker(String t,long id, String n, long served, long sc, double money, boolean onBreak) {
        super(t,id, n, served, sc, money);
        this.stamina = 18;
        this.onBreak = onBreak; 
    }
    //below are getters and setters
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public boolean isOnBreak() {
        return onBreak;
    }

    public void setOnBreak(boolean onBreak) {
        this.onBreak = onBreak;
    }
}
