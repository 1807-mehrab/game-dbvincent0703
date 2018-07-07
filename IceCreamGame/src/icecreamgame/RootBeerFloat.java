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
public class RootBeerFloat extends Serving{
    public static double rootbearfloat = 1.25;
    private int scoops=1;

    public RootBeerFloat(ArrayList<IceCream> ice_cream, double price) {
        super(ice_cream, price);
     
    } 
    //below are getter and setter
    public int getScoops() {
        return scoops;
    }

    public void setScoops(int scoops) {
        this.scoops = scoops;
    }
}
