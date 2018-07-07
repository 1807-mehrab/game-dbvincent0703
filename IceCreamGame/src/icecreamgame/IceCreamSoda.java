/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamgame;

import java.util.ArrayList;

/**
 *
 * @author vb
 */
public class IceCreamSoda extends Serving{
    int scoops =2;   
    public IceCreamSoda(ArrayList<IceCream> ice_cream, double ice_price){
        super(ice_cream, ice_price);
    } 
    //below are getters and setter
    public int getScoops() {
        return scoops;
    }
    public void setScoops(int scoops) {
        this.scoops = scoops;
    }

}
