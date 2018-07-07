/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamgame;

public class IceCream {
    private long idNumber;
    private double price;
    private String flavor;
    private String description;
    private int scoops; 
    private String name;
  
    public IceCream(long idNumber,String flavor, double price, String name,String description,int scoops)
    {
        this.idNumber = idNumber;
        this.price = price;
        this.flavor = flavor;
        this.name = name;
        this.description = description;
      
        this.scoops = scoops;
    }
    public IceCream getOneIceCream() //clone the ice cream
    {
        IceCream one = new IceCream(this.idNumber,this.flavor,this.price,this.name,this.description,1);
        return one;
    }
    //The bellow are getters and setters for the attributes
    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScoops() {
        return scoops;
    }

    public void setScoops(int scoops) {
        this.scoops += scoops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

