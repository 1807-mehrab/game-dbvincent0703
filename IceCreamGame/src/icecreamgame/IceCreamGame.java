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
public class IceCreamGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Shop shop = new Shop();
        Menu redo = new Menu(shop);
    }
    
}
