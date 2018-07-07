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
public class IceCreamCone extends Serving{
    int scoops;
    
    String[] cone_type = {"cake cone","sugar cone","waffle cone"};
    String cone_select;
    
    public IceCreamCone(ArrayList<IceCream> ice_cream, double ice_price, int scoops, int type) 
    {
        super(ice_cream, ice_price);
        this.scoops = scoops;
        cone_select = cone_type[type];      
    }
    //below are getters and setters
    public int getScoops() {
        return scoops;
    }    
    public void setScoops(int scoops) {
        this.scoops = scoops;
    }
    public void setCone_select(int n) {
        cone_select = cone_type[n];
    }
    public String getCone_select() {
        return cone_select;
    }
    
    
}

