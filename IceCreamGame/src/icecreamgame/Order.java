/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamgame;

import java.util.ArrayList;

public class Order {
    private int order_number;
    private boolean paid;
    private Customer customer;
    private Worker worker;  
    private Stocker stocker;
    private CashierWorker cashier;
    private ArrayList<Serving> ServingList= new ArrayList<>(); 

    public Order(int order_number,Customer customer, Worker worker, Stocker stocker, CashierWorker cashier, ArrayList<Serving> ServingList)
    {                
        this.order_number = order_number;
        this.customer = customer;
        this.worker = worker;
        this.stocker = stocker;
        this.cashier = cashier;
        for(Serving s:ServingList)
        {
            this.ServingList.add(s);
        }    
        System.out.println("New Order is instantiated");
    }
    // The below methods are getter and setter for all the attributes in order class
    public int getOrder_number() {
        return order_number;
    }
    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }
    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
      public ArrayList<Serving> getServingList() {
        return ServingList;
    }

    public void setServingList(ArrayList<Serving> ServingList) {
        this.ServingList = ServingList;
    }

    public Stocker getStocker() {
        return stocker;
    }

    public void setStocker(Stocker stocker) {
        this.stocker = stocker;
    }

    public CashierWorker getCashier() {
        return cashier;
    }

    public void setCashier(CashierWorker cashier) {
        this.cashier = cashier;
    }
}
