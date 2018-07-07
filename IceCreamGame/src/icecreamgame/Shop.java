/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamgame;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author vb
 */
public class Shop {
    public static ArrayList<Customer> CustomerList = new ArrayList<>();
    public static ArrayList<Worker> WorkerList = new ArrayList<>();
    public static ArrayList<CashierWorker> CashierList = new ArrayList<>();
    public static ArrayList<Stocker> StockerList = new ArrayList<>();
    public static ArrayList<IceCream> IceList = new ArrayList<>();
    public static ArrayList<Order> OrderList = new ArrayList<>();
    public static ArrayList<Serving> ServingList = new ArrayList<>();
    public CashRegister cashregister = new CashRegister();
    //public static Stocker activeStocker;
    //public static CashierWorker activeCashierWorker;        
    public static boolean onBreakCashier;
    public static boolean onBreakStocker;   
    Scanner input = new Scanner(System.in);
    int count;
    public void showCustomer() // who customers
    {
        count = 0;
        System.out.println("Customers:");
        System.out.println("************************************");
        for(Customer cus: CustomerList)
        {
            System.out.printf("Number %d. %d,%s,%.2f,%.2f,%d,%d,%d,%d,%d,%d,%d,%d\n",count,cus.getIdNumber(),cus.getName(),cus.getCash(), cus.getCredit(),cus.getPennies(),cus.getNickels(),cus.getDimes(),cus.getQuarters(),cus.getOne_dollar(),cus.getFive_dollar(),cus.getTen_dollar(),cus.getTwenty_dollar());            
            count++;
        }
    }
    public Customer CreateCustomer(String customer) //create new customer and add to the customer list
    {
         String[] tokens=customer.split(",");
         long lID=Long.parseLong(tokens[0]);
         String sName=tokens[1];
         double dCash=Double.parseDouble(tokens[2]);
         double dCredit=Double.parseDouble(tokens[3]);
         int pennies = Integer.parseInt(tokens[4]);
         int nickels = Integer.parseInt(tokens[5]);
         int dimes = Integer.parseInt(tokens[6]);
         int quarters = Integer.parseInt(tokens[7]);
         int one = Integer.parseInt(tokens[8]);
         int five = Integer.parseInt(tokens[9]);
         int ten = Integer.parseInt(tokens[10]);
         int twenty = Integer.parseInt(tokens[11]);

         Customer cusTemp = new Customer(lID,sName,dCredit,dCash,pennies,nickels, dimes, quarters, one, five, ten, twenty);
         CustomerList.add(cusTemp); 
         return cusTemp;
    }
    public void showWorker() //show workers
    {
        count = 0;
        System.out.println("Workers:");
        System.out.println("************************************");
        for(Worker wor: WorkerList)
        {
            System.out.printf("Number %d. %s,%d,%s,%d,%d,%.2f\n",count,wor.getType(),wor.getIdNumber(),wor.getName(),wor.getCustomers_served(),wor.getScoops_served(),wor.get$takenin());
            count++;
        }
    }
    public Worker CreateWorker(String worker) //create new worker and add to the worker list
    {
         String[] tokens=worker.split(",");
         String type = tokens[0];
         long ID=Long.parseLong(tokens[1]);
         String sName=tokens[2];
         long cus_served =Long.parseLong(tokens[3]);
         long scoops =Long.parseLong(tokens[4]);
         double d$takenin=Double.parseDouble(tokens[5]);
         Worker worTemp;
      
         for(Worker w: WorkerList)
         {
             if(w.getIdNumber() == ID)
             {   
                 return w;
             }
         }
        worTemp = new Worker(type,ID,sName,cus_served,scoops,d$takenin);
        WorkerList.add(worTemp); 
        return worTemp;   
    } 
    public void showStocker() //show stockers
    {
        count = 0;
        System.out.println("Stockers:");
        System.out.println("************************************");
        for(Stocker wor: StockerList)
        {
            System.out.printf("Number %d. %s,%d,%s,%d,%d,%.2f\n",count, wor.getType(),wor.getIdNumber(),wor.getName(),wor.getCustomers_served(),wor.getScoops_served(),wor.get$takenin());           
            count++;
        }
    }
    public Stocker CreateStocker(String worker) //create new worker and add to the worker list
    {
         String[] tokens=worker.split(",");
         String type = tokens[0];
         long ID=Long.parseLong(tokens[1]);
         String sName=tokens[2];
         long cus_served =Long.parseLong(tokens[3]);
         long scoops =Long.parseLong(tokens[4]);
         double d$takenin=Double.parseDouble(tokens[5]);
         
         Stocker worTemp;
      
         for(Stocker s: StockerList)
         {
             if(s.getIdNumber() == ID && s.getStamina() > 0 && s.isOnBreak() == false)
             {   
                 return s;
             }
         }      

         worTemp = new Stocker(type,ID,sName,cus_served,scoops,d$takenin,false);
         StockerList.add(worTemp); 
         //activeStocker = worTemp;
         return worTemp;   
    }
    public void showCashier() //show cashiers
    {
        count=0;
        System.out.println("cashiers:");
        System.out.println("************************************");
        for(CashierWorker wor: CashierList)
        {
            System.out.printf("Number %d. %s,%d,%s,%d,%d,%.2f\n",count,wor.getType(),wor.getIdNumber(),wor.getName(),wor.getCustomers_served(),wor.getScoops_served(),wor.get$takenin());     
            count++;
        }
    }
    public CashierWorker CreateCashier(String worker) //create new worker and add to the worker list
    {
         String[] tokens=worker.split(",");
         String type = tokens[0];
         long ID=Long.parseLong(tokens[1]);
         String sName=tokens[2];
         long cus_served =Long.parseLong(tokens[3]);
         long scoops =Long.parseLong(tokens[4]);
         double d$takenin=Double.parseDouble(tokens[5]);
        
         CashierWorker worTemp;
         
         for(CashierWorker c: CashierList)
         {
             if(c.getIdNumber() == ID && c.getPatience() > 0 && c.isOnBreak() == false)
             {   
                 return c;
             }
         }      
         
         worTemp = new CashierWorker(type,ID,sName,cus_served,scoops,d$takenin,false);      
         //activeCashierWorker = worTemp;
         CashierList.add(worTemp); 
          
         return worTemp;   
    }
    public void showIceCream() //show ice cream
    {
        System.out.println("Ice cream:");
        System.out.println("************************************");

        for(IceCream ice: IceList)
        {
            System.out.printf("%d,%s,%.2f,%s,%s,%d\n",ice.getIdNumber(),ice.getFlavor(),ice.getPrice(),ice.getName(),ice.getDescription(),ice.getScoops());
          
        }
    }
    public IceCream CreateIce(String ice) //create new icecream and add to the ice cream list. 
    {
         String[] tokens=ice.split(","); 
         long lID=Long.parseLong(tokens[0]);
         String flavor = tokens[1];
         double dPrice=Double.parseDouble(tokens[2]);
         String sName=tokens[3];
         String sDescription = tokens[4];  
         int scoops = Integer.parseInt(tokens[5]);
         IceCream iceTemp = new IceCream(lID,flavor,dPrice,sName,sDescription,scoops);
         IceList.add(iceTemp); 
         return iceTemp;
       
    }
    
    public Serving CreateServing(ArrayList<IceCream> selection,double price) //create new serving and add to the serving
    {      
        Serving serving = new Serving(selection,price);
        ServingList.add(serving);
        return serving;
    }
    public IceCreamCone CreateCone(ArrayList<IceCream> ice_cream,double price, int scoops, int type) //create new cone serving and add to the serving
    {       
        IceCreamCone cone_serving = new IceCreamCone(ice_cream,price, scoops, type);                  
        ServingList.add(cone_serving); 
        return cone_serving;
    } 
    public IceCreamSundae CreateSundae(ArrayList<IceCream> ice_cream,double price, int scoops, int flavor,boolean nuts) //create new sundae serving and add to the serving
    {  
          
        IceCreamSundae sundae_serving = new IceCreamSundae(ice_cream,price,scoops,flavor,nuts);                
        ServingList.add(sundae_serving); 
        return sundae_serving;
    }
     public BananaSplit CreateBananaSplit(ArrayList<IceCream> ice_cream,double price, int scoops, int flavor,boolean nuts, int syrup2, int syrup3) //create new sundae serving and add to the serving
    {  
          
        BananaSplit banana_split = new BananaSplit(ice_cream,price,scoops,flavor,nuts,syrup2,syrup3);                
        ServingList.add(banana_split); 
        return banana_split;
    }
    public IceCreamSoda CreateCreamSoda(ArrayList<IceCream> ice_cream,double price) //create new creamsoda and add to the serving
    {        
        IceCreamSoda soda = new IceCreamSoda(ice_cream,price);
        ServingList.add(soda);  
        return soda;
    }
     public RootBeerFloat CreateRootBeer(ArrayList<IceCream> ice_cream,double price) //create new serving and add to the serving
    {
        
        RootBeerFloat rootbeer = new RootBeerFloat(ice_cream,price);
        ServingList.add(rootbeer);
        return rootbeer;
    }
    public void display(int display_option) //showing the display out put of Order and cashier
    {      
        if(display_option == 1)
        {
            showOrder();
        }
        else if(display_option == 2)
        {
            System.out.println();
            
            System.out.println("Worker:");
            for(Order order: OrderList)
            {                 
                    System.out.println("ID "+order.getWorker().getIdNumber()+" "+order.getWorker().getName());               
            }
            System.out.println("-----------------");
            System.out.println("Customer:");
            
            System.out.println("Stocker:");
            for(Order order: OrderList)
            {                 
                    System.out.println("ID "+order.getStocker().getIdNumber()+" "+order.getStocker().getName());               
            }
            System.out.println("-----------------");
            System.out.println("Cashier:");
            for(Order order: OrderList)
            {                 
                    System.out.println("ID "+order.getCashier().getIdNumber()+" "+order.getCashier().getName());               
            }
            System.out.println("-----------------");
            System.out.println("Customer:");
            System.out.println("Customer:");
            for(Order order: OrderList)
            {
                System.out.println("ID "+order.getCustomer().getIdNumber()+" "+order.getCustomer().getName());               
            }
            System.out.println();
        }
        else if(display_option == 3)
        {           
            System.out.println("-----------------");
            System.out.printf("Cash Register Total: %.2f%n",cashregister.getTotal_money());
            System.out.printf("Credit: %.2f%n",cashregister.getCredit());
            System.out.printf("Cash: %.2f",cashregister.getCash());
            System.out.println("-----------------");
        }
        else if(display_option ==4)
        {
           showIceCream();
        }
        else if(display_option == 5)
        {
            showCustomer();
            System.out.println("---------------------------------------");
            showWorker();
            System.out.println("---------------------------------------");
            showStocker();
            System.out.println("---------------------------------------");
            showCashier();
            System.out.println("---------------------------------------");
            showIceCream();
            System.out.println("---------------------------------------");
        }
     
    }
    public void saveData() //call the filehandling class to save the data 
    {
          FileHandling file = new FileHandling();
          file.writeIceCream(IceList);             
          file.writeCustomer(CustomerList);
          file.writeWorker(WorkerList,CashierList,StockerList);

    }
    public Order CreateOrder(int orderNumber,Customer ActiveCustomer,Worker ActiveWorker,Stocker ActiveStocker,CashierWorker ActiveCashier,ArrayList<Serving> total_serving) //create new order and add to the order list
    {          
        Order order = new Order(orderNumber,ActiveCustomer,ActiveWorker,ActiveStocker,ActiveCashier,total_serving);
        OrderList.add(order);
        return order;

    }
    public void showOrder() //show the order
    {
         for(Order order: OrderList)
          {
                
                System.out.println("---------------------------------------");
                System.out.println("Order Number:"+order.getOrder_number());
                //System.out.println("Worker: "+order.getWorker().getWorker_name());
                System.out.println("Customer: "+order.getCustomer().getName());
                System.out.println("    Servings:");
                int c=1,i;
                
                for(Serving serving: order.getServingList())
                {
                     System.out.printf("%d. Price of serving: %.2f\n",c,serving.getCurrent_price()); 
                     i=1;
                     for(IceCream ice:serving.getIce_cream())
                     {
                         System.out.printf("%d. $%.2f %s\n", i,ice.getPrice(),ice.getName());
                         i++;
                     }
                     c++;
                     System.out.println("----------------------------------------");
                }    
                System.out.println("----------------------------------------");
            }
    }        
    public boolean CreditTransaction(int orderNumber) throws NotEnoughMoney//calling the transaction class for payment
    {
        Transaction transaction = new Transaction();
        boolean paid = transaction.creditPayment(cashregister, OrderList.get(orderNumber));
        
        if(paid == false)
        {
            throw new NotEnoughMoney();
        }
        return paid;
    }
    public boolean CashTransaction(int order_number, int pennies, int nickels, int dimes, int quarters, int dollars, int five, int ten, int twenty)throws NotEnoughMoney
    {
        Transaction transaction = new Transaction();
         boolean paid = transaction.cashPayment(cashregister, OrderList.get(order_number),pennies, nickels, dimes, quarters, dollars, five, ten, twenty);
        
        if(paid == false)
        {
            throw new NotEnoughMoney();
        }
        return paid;
    } 
    
    
    public void UpdateWorker(int i, String worker)//update worker
    {

        String[] tokens=worker.split(",");
         String type = tokens[0];
         long ID=Long.parseLong(tokens[1]);
         String sName=tokens[2];
         long cus_served =Long.parseLong(tokens[3]);
         long scoops =Long.parseLong(tokens[4]);
         double d$takenin=Double.parseDouble(tokens[5]);
         Worker worTemp;
         
         WorkerList.get(i).setType(type);
         WorkerList.get(i).setIdNumber(ID);
         WorkerList.get(i).setName(sName);
         WorkerList.get(i).setCustomers_served(cus_served);
         WorkerList.get(i).setScoops_served(scoops);
         WorkerList.get(i).set$takenin(d$takenin);
    }
    public void UpdateCashier(int i, String worker)//update cashier
    {
         String[] tokens=worker.split(",");
         String type = tokens[0];
         long ID=Long.parseLong(tokens[1]);
         String sName=tokens[2];
         long cus_served =Long.parseLong(tokens[3]);
         long scoops =Long.parseLong(tokens[4]);
         double d$takenin=Double.parseDouble(tokens[5]);
         boolean onB = Boolean.parseBoolean(tokens[6]);
         int patience = Integer.parseInt(tokens[7]);

         CashierList.get(i).setType(type);
         CashierList.get(i).setIdNumber(ID);
         CashierList.get(i).setName(sName);
         CashierList.get(i).setCustomers_served(cus_served);
         CashierList.get(i).setScoops_served(scoops);
         CashierList.get(i).set$takenin(d$takenin);
         CashierList.get(i).setOnBreak(onB);
         CashierList.get(i).setPatience(patience);
    }
    public void UpdateStocker(int i, String worker)//update stocker
    {              
         String[] tokens=worker.split(",");
         String type = tokens[0];
         long ID=Long.parseLong(tokens[1]);
         String sName=tokens[2];
         long cus_served =Long.parseLong(tokens[3]);
         long scoops =Long.parseLong(tokens[4]);
         double d$takenin=Double.parseDouble(tokens[5]);
         boolean onB = Boolean.parseBoolean(tokens[6]);
         int stamina = Integer.parseInt(tokens[7]);

         StockerList.get(i).setType(type);
         StockerList.get(i).setIdNumber(ID);
         StockerList.get(i).setName(sName);
         StockerList.get(i).setCustomers_served(cus_served);
         StockerList.get(i).setScoops_served(scoops);
         StockerList.get(i).set$takenin(d$takenin);
         StockerList.get(i).setOnBreak(onB);
         StockerList.get(i).setStamina(stamina);
    }
    public void UpdateCustomer(int i, String customer)//update customer
    {
        
        String[] tokens = customer.split(",");

         long lID=Long.parseLong(tokens[0]);
         String sName=tokens[1];
         double dCash=Double.parseDouble(tokens[2]);
         double dCredit=Double.parseDouble(tokens[3]);
         int pennies = Integer.parseInt(tokens[4]);
         int nickles = Integer.parseInt(tokens[5]);
         int dimes = Integer.parseInt(tokens[6]);
         int quarters = Integer.parseInt(tokens[7]);
         int one = Integer.parseInt(tokens[8]);
         int five = Integer.parseInt(tokens[9]);
         int ten = Integer.parseInt(tokens[10]);
         int twenty = Integer.parseInt(tokens[11]);
         

        CustomerList.get(i).setIdNumber(lID);
        CustomerList.get(i).setName(sName);
        CustomerList.get(i).setCash_total(dCash);
        CustomerList.get(i).setCredit(dCredit);
        CustomerList.get(i).setCash(pennies, nickles, dimes, quarters, one, five, ten, twenty);
     
     
    } 
    public void UpdateIceCream(int i, String icecream)//update icecream
    {   
     
         String[] tokens=icecream.split(","); 
         long lID=Long.parseLong(tokens[0]);
         String flavor = tokens[1];
         double dPrice=Double.parseDouble(tokens[2]);
         String sName=tokens[3];
         String sDescription = tokens[4]; 
        int scoops = Integer.parseInt(tokens[5]);

        IceList.get(i).setIdNumber(lID);
        IceList.get(i).setFlavor(flavor);
        IceList.get(i).setPrice(dPrice);
        IceList.get(i).setName(sName);
        IceList.get(i).setDescription(sDescription);
        IceList.get(i).setScoops(scoops);                                 
    }
}

