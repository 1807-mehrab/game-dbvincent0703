/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamgame;

public class Worker {
    private long idNumber;
    private String name;
    private long customers_served;
    private long scoops_served;
    private double d$takenin;
    private String type;

    
    public Worker(String type,long idNumber, String name, long customers_served, long scoops_served, double d$takenin)
    {
        this.type = type;
        this.idNumber = idNumber;
        this.name = name;
        this.customers_served = customers_served;
        this.scoops_served = scoops_served;
        this.d$takenin = d$takenin;
      
    }
    //the below are the getters and setters for the attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }
    public long getCustomers_served() {
        return customers_served;
    }

    public void setCustomers_served(long customers_served) {
        this.customers_served += customers_served;
    }

    public long getScoops_served() {
        return scoops_served;
    }

    public void setScoops_served(long scoops_served) {
        this.scoops_served += scoops_served;
    }

    public double get$takenin() {
        return d$takenin;
    }

    public void set$takenin(double d$takenin) {
        this.d$takenin += d$takenin;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

