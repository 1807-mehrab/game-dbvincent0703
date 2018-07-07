/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamgame;

import java.util.ArrayList;

public class Transaction {

    public boolean creditPayment(CashRegister cashregister, Order payOrder)//Take the credit payment from customer and add to cashier. 
    {
        double cost = getOrderTotal(payOrder);
        boolean paid = false;

        double enough_credit = payOrder.getCustomer().getCredit() - cost;
        int scoops_served = 0;
        for (Serving ser : payOrder.getServingList()) {
            scoops_served += ser.getIce_cream().size();
        }
        if (enough_credit > 0.0) {
            payOrder.getCustomer().setPaymentCredit(cost);
            payOrder.getCashier().set$takenin(cost);
            payOrder.getCashier().setCustomers_served(1);
            payOrder.getCashier().setPatience(-1);
            payOrder.getWorker().setCustomers_served(1);
            payOrder.getStocker().setScoops_served(scoops_served);
            payOrder.getStocker().setStamina(-1);
            cashregister.setCredit(cost);
            
            System.out.println(payOrder.getCustomer().getName() + ": Paid");
            payOrder.getCustomer().setHappylevel(scoops_served);
            System.out.println("Happy level increase by " + scoops_served);
            System.out.println("Customer Happy Level: " + payOrder.getCustomer().getHappylevel());
            System.out.printf("You have %.2f credit left", payOrder.getCustomer().getCredit());
            payOrder.setPaid(true);
            paid = true;
            
            for(Serving ser: payOrder.getServingList())
            {
                    for(IceCream ice: ser.getIce_cream())
                    {
                            ice.setScoops(-1);
                    }
            }
            
        } else {
            payOrder.getCustomer().setHappylevel(-1);
            payOrder.getCashier().setPatience(-2);
            paid = false;
        }
        return paid;
    }

    public boolean cashPayment(CashRegister cashregister, Order payOrder, int pennies, int nickels, int dimes, int quarters, int dollars, int five, int ten, int twenty) throws NotEnoughMoney//calculate changes
    {
        boolean paid = false;
         int scoops_served = 0;
        for (Serving ser : payOrder.getServingList()) {
            scoops_served += ser.getIce_cream().size();
        }
        double customer_payment = .01 * pennies + .05 * nickels + .10 * dimes + .25 * quarters + 1.0 * dollars + 5.0 * five + 10.0 * ten + 20.0 * twenty;
        double order_total = getOrderTotal(payOrder);
        double change = customer_payment - order_total;

        boolean enough_change = checkCashRegister(cashregister, change, pennies, nickels, dimes, quarters, dollars, five, ten, twenty);

        if (enough_change == true) {
            payOrder.getCustomer().setPennies(payOrder.getCustomer().getPennies() - pennies); //take customer money and recalculate cash
            payOrder.getCustomer().setNickels(payOrder.getCustomer().getNickels() - nickels);
            payOrder.getCustomer().setDimes(payOrder.getCustomer().getDimes() - dimes);
            payOrder.getCustomer().setQuarters(payOrder.getCustomer().getQuarters() - quarters);
            payOrder.getCustomer().setOne_dollar(payOrder.getCustomer().getOne_dollar() - dollars);
            payOrder.getCustomer().setFive_dollar(payOrder.getCustomer().getFive_dollar() - five);
            payOrder.getCustomer().setTen_dollar(payOrder.getCustomer().getTen_dollar() - ten);
            payOrder.getCustomer().setTwenty_dollar(payOrder.getCustomer().getTwenty_dollar() - twenty);
            
            Customer customer = payOrder.getCustomer();
            doTransaction(customer, cashregister, change, pennies, nickels, dimes, quarters, dollars, five, ten, twenty);
                  
            payOrder.getCashier().set$takenin(order_total);
            payOrder.getCashier().setCustomers_served(1);
            payOrder.getCashier().setPatience(-1);
            payOrder.getWorker().setCustomers_served(1);
            payOrder.getStocker().setScoops_served(scoops_served);
            payOrder.getStocker().setStamina(-1);
           
            System.out.println(payOrder.getCustomer().getName() + ": Paid");
            payOrder.getCustomer().setHappylevel(scoops_served);
            System.out.println("Happy level increase by " + scoops_served);
            System.out.println("Customer Happy Level: " + payOrder.getCustomer().getHappylevel());
            System.out.println("Amount left in your wallet:");
            
            System.out.printf("Pennies: %d\n",customer.getPennies());            
            System.out.printf("Nickles: %d\n",customer.getNickels());
            System.out.printf("Dimes: %d\n",customer.getDimes());         
            System.out.printf("Quarters: %d\n",customer.getQuarters());           
            System.out.printf("One dolar: %d\n",customer.getOne_dollar());  
            System.out.printf("Five dollar: %d\n",customer.getFive_dollar());          
            System.out.printf("Ten dollar: %d\n", customer.getTen_dollar());       
            System.out.printf("Twenty dollar: %d\n\n",customer.getTwenty_dollar());
      
            payOrder.setPaid(true);
            paid = true;
            
            for(Serving ser: payOrder.getServingList())
            {
                    for(IceCream ice: ser.getIce_cream())
                    {
                            ice.setScoops(-1);
                    }
            }
            
            
        } else {
            payOrder.getCustomer().setHappylevel(-1);
            payOrder.getCashier().setPatience(-2);
            throw new NotEnoughMoney();
        }
                   
       return paid;
        
    }

    public boolean checkCashRegister(CashRegister cashregister, double cha, int pen, int nic, int dim, int qua, int dol, int fiv, int te, int twe) {
     
        int change = (int) (cha * 100); //convert change to integer
        //combine customer cash payment with cash register
        int pennies = cashregister.getPennies() + pen;
        int nickels = cashregister.getNickels() + nic;
        int dimes = cashregister.getDimes() + dim;
        int quarters = cashregister.getQuarters() + qua;
        int one = cashregister.getOne_dollar() + dol;
        int five = cashregister.getFive_dollar() + fiv;
        int ten = cashregister.getTen_dollar() + te;
        int twenty = cashregister.getTwenty_dollar() + twe;

        while (twenty > 0 && change / 2000 > 0) {

            change = change - 2000;
            twenty--;
            //System.out.println("20");
            if (change == 0) {
                return true;
            }
        }

        while (ten > 0 && Math.floor(change / 1000) > 0) {
            change = change - 1000;
            ten--;
            // System.out.println("10");
            if (change == 0) {
                return true;
            }
        }
        while (five > 0 && Math.floor(change / 500) > 0) {
            change = change - 500;
            five--;
            //System.out.println("5");
            if (change == 0) {
                return true;
            }
        }
        while (one > 0 && Math.floor(change / 100) > 0) {
            change = change - 100;
            one--;
            // System.out.println("1");
            if (change == 0) {
                return true;
            }
        }
        while (quarters > 0 && Math.floor(change / 25) > 0) {
            change = change - 25;
            quarters--;
            //System.out.println("25");
            if (change == 0) {
                return true;
            }
        }

        while (dimes > 0 && Math.floor(change / 10) > 0) {
            change = change - 10;
            dimes--;
            // System.out.println(".10");
            if (change == 0) {
                return true;
            }
        }

        while (nickels > 0 && Math.floor(change / 5) > 0) {
            change = change - 5;
            nickels--;
            //System.out.println(".05");
            if (change == 0) {
                return true;
            }
        }

        while (pennies > 0 && change / 1 > 0) {
            change = change - 1;
            pennies--;
            // System.out.println(".01");
            if (change == 0) {

                return true;
            }
        }
        System.out.println("FALSE");

        return false;
    }

    public void doTransaction(Customer customer, CashRegister cashregister, double cha, int pen, int nic, int dim, int qua, int dol, int fiv, int te, int twe) {
        int change = (int) (cha * 100);
        int pennies = cashregister.getPennies() + pen;
        int nickels = cashregister.getNickels() + nic;
        int dimes = cashregister.getDimes() + dim;
        int quarters = cashregister.getQuarters() + qua;
        int one = cashregister.getOne_dollar() + dol;
        int five = cashregister.getFive_dollar() + fiv;
        int ten = cashregister.getTen_dollar() + te;
        int twenty = cashregister.getTwenty_dollar() + twe;

        cashregister.setTwenty_dollar(twenty);
        cashregister.setTen_dollar(ten);
        cashregister.setFive_dollar(five);
        cashregister.setOne_dollar(one);
        cashregister.setQuarters(quarters);
        cashregister.setDimes(dimes);
        cashregister.setNickels(nickels);
        cashregister.setPennies(pennies);
        double ch = (double) change / 100.0;
        System.out.printf("Customer Changes $%.2f:\n", ch);
        while (twenty > 0 && change / 2000 > 0) {
            System.out.println("$20");
            change = change - 2000;
            twenty--;            
            cashregister.setTwenty_dollar(twenty); //taking money from register
            customer.setTwenty_dollar(customer.getTwenty_dollar()+1); //giving change to customer
            if (change == 0) {
                return;
            }
        }

        while (ten > 0 && change / 1000 > 0) {
            System.out.println("$10");
            change = change - 1000;
            ten--;
            cashregister.setTen_dollar(ten);
            customer.setTen_dollar(customer.getTen_dollar()+1);
            if (change == 0) {
                return;
            }
        }

        while (five > 0 && change
                / 500 > 0) {
            System.out.println("$5");
            change = change - 500;
            five--;
            cashregister.setFive_dollar(five);
            customer.setFive_dollar(customer.getFive_dollar()+1);
            if (change == 0) {
                return;
            }
        }

        while (one > 0 && change
                / 100 > 0) {
            System.out.println("$1");
            change = change - 100;
            one--;
            cashregister.setOne_dollar(one);
            customer.setOne_dollar(customer.getOne_dollar()+1);
            if (change == 0) {
                return;
            }
        }

        while (quarters > 0 && change
                / 25 > 0) {
            System.out.println("25 cent");
            change = change - 25;
            quarters--;
            cashregister.setQuarters(quarters);
            customer.setQuarters(customer.getQuarters()+1);
            if (change == 0) {
                return;
            }
        }

        while (dimes > 0 && change
                / 10 > 0) {
            System.out.println("10 cent");
            change = change - 10;
            dimes--;
            cashregister.setDimes(dimes);
            customer.setDimes(customer.getDimes()+1);
            if (change == 0) {
                return;
            }
        }

        while (nickels > 0 && change
                / 5 > 0) {
            System.out.println("5 cent");
            change = change - 5;
            nickels--;
            cashregister.setNickels(nickels);
            customer.setNickels(customer.getNickels()+1);
            if (change == 0) {
                return;
            }
        }

        while (pennies > 0 && change
                / 1 > 0) {
            System.out.println("1 cent");
            change = change - 1;
            pennies--;
            cashregister.setPennies(pennies);
            customer.setPennies(customer.getPennies()+1);
            if (change == 0) {
                return;
            }
        }

    }

    public double getOrderTotal(Order payOrder) {
        double cost = 0;
        System.out.println("**********Bill**********");

        int i = 1;

        for (Serving ser : payOrder.getServingList()) {
            for (IceCream s : ser.getIce_cream()) {
                System.out.println(i + "." + s.getName() + " :" + s.getPrice());
                i++;
            }
            cost += ser.getCurrent_price();
        }
        System.out.println("*************************");
        System.out.println("Total:" + cost);
        return cost;
    }

}
