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
public class NotEnoughIceCream extends Exception{
    public String toString()
    {
        return "Sorry we ran out of the flavor ice cream";
    }
}
