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
public class IceCreamSundae extends Serving
{
    String[] syrup = {"strawberry", "chocolate syrup", "marshmallow cream", "pineapple", "ketchup", "mustard", "pickle relish"};
    String sundae_flavor;
    boolean nuts;
    private int scoops;
    public IceCreamSundae(ArrayList<IceCream> ice_cream, double ice_price, int scoops, int type,boolean nuts) 
    {
        super(ice_cream, ice_price);
        this.scoops = scoops;
        sundae_flavor = syrup[type];
        this.nuts = nuts;       
    }
   
    public String getSundae_flavor() {
        return sundae_flavor;
    }

    public void setSundae_flavor(String sundae_flavor) {
        this.sundae_flavor = sundae_flavor;
    }

    public boolean isNuts() {
        return nuts;
    }

    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }

    public int getScoops() {
        return scoops;
    }

    public void setScoops(int scoops) {
        this.scoops = scoops;
    }
    
}
