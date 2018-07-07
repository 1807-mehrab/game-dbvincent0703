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
public class BananaSplit extends IceCreamSundae{
    
    private String ban_syrup2;
    private String ban_syrup3;
    
    String[] b_syrup = {"strawberry", "chocolate syrup", "marshmallow cream", "pineapple", "ketchup", "mustard", "pickle relish"};
    
    public BananaSplit(ArrayList<IceCream> ice_cream, double ice_price, int scoops, int syrup1 ,boolean nuts,int syrup2,int syrup3) //constructor
    {
       super(ice_cream,ice_price,scoops,syrup1,nuts);      
        ban_syrup2 = b_syrup[syrup2];
        ban_syrup3 = b_syrup[syrup3];
    }

    public String getBan_syrup2() {
        return ban_syrup2;
    }

    public void setBan_syrup2(String ban_syrup2) {
        this.ban_syrup2 = ban_syrup2;
    }

    public String getBan_syrup3() {
        return ban_syrup3;
    }

    public void setBan_syrup3(String ban_syrup3) {
        this.ban_syrup3 = ban_syrup3;
    }

}
