/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamgame;
import java.util.ArrayList;

public class Serving {
    private ArrayList<IceCream> ice_cream=new ArrayList<>();
    private double current_price;
    
    public Serving(ArrayList<IceCream> ice, double current_price)
    {
        for(IceCream i: ice)
        {
            ice_cream.add(i);
        }
        this.current_price = current_price;
    }
    //the below are the getters and setters for the attributes
    public void setIce_cream(ArrayList<IceCream>ice_cream) {
        this.ice_cream = ice_cream;
    }
    public ArrayList<IceCream> getIce_cream() {
        return ice_cream;
    }
    public double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(double ice_price) {
        this.current_price = ice_price;
    }
}
