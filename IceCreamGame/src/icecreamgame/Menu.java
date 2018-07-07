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
public class Menu {
     public Menu(Shop shop)
    {
        Scanner input = new Scanner(System.in);
        FileHandling file = new FileHandling();
        
        ArrayList<String> IceList;
        ArrayList<String> CustomerList;
        ArrayList<String> WorkerList;        
        ArrayList<String> Customer = new ArrayList<>();
        ArrayList<String> Worker = new ArrayList<>();
        ArrayList<String> Cashier = new ArrayList<>();
        ArrayList<String>  Stocker = new ArrayList<>();
         ArrayList<String>  IceCream = new ArrayList<>();
         
        ArrayList<IceCream> IceCream_selection;
        ArrayList<Serving> total_serving = new ArrayList<>(); 
        Worker ActiveWorker=null;
        CashierWorker ActiveCashier=null;
        Stocker ActiveStocker=null;
        Customer ActiveCustomer=null;
        
        int option,create,count,orderNumber=0;
        
        do
        {                     
            System.out.println("    Main Menu");
            System.out.println("    1. Load Files");       
            System.out.println("    2. Create Order");
            System.out.println("    3. Update Order");
            System.out.println("    4. Task Menu");
            System.out.println("    5. Display Order");
            System.out.println("    6. Save Files");
            System.out.println("    7. Exception Menu");
            System.out.println("    8. Quit");
            System.out.println();
            System.out.println("***Please enter the option number:***");

            option = input.nextInt();
            System.out.println("************************************");
            switch(option)
            {
                case 1://-------------->Load File
                    System.out.println("Loading customer list:");
                    CustomerList = file.readCustomer();
                    count = 1;
                    for(String c: CustomerList)
                    {
                        Customer.add(c); 
                        System.out.println(count+". "+c);
                        shop.CreateCustomer(c); //
                        count++;                    
                    }
                    
                    System.out.println("************************************");
                    System.out.println("Loading worker list:");
                    count = 1;
                    WorkerList = file.readWorker();             
                    for(String w: WorkerList)
                    {
                        System.out.println(count+". "+w);
                        count++;   
                        
                         String[] tokens = w.split(",");
                        switch (tokens[0]) {
                            case "worker":
                                Worker.add(w); 
                                shop.CreateWorker(w);//
                                break;
                            case "cashier":
                                Cashier.add(w); 
                                shop.CreateCashier(w);//
                                break;
                            case "stocker":
                                Stocker.add(w);
                                shop.CreateStocker(w);//
                                break;
                            }
                    }
                    System.out.println("************************************");
                    System.out.println("Loading ice cream list:");
                    count = 1;
                    IceList = file.readIce();    
                    for(String i: IceList)
                    {
                        IceCream.add(i);
                        shop.CreateIce(i);//
                        System.out.println(i);
                        
                        count++;                   
                    }
                    System.out.println("************************************");
                    break;
                    
                    
/*Create Menu*/ case 2:                                    
                    do{
                        System.out.println("Create Menu:");
                        System.out.println("    1. Create Worker");
                        System.out.println("    2. Create Cashier");
                        System.out.println("    3. Create Stocker");
                        System.out.println("    4. Create Customer");
                        System.out.println("    5. Create Ice Cream");
                        System.out.println("    6. Return to previous Menu");
                        System.out.println("************************************");
                        System.out.println("***Please enter the option number:***");
                        create = input.nextInt();
                        
                     
                        int i;
                        switch(create)
                        {
                            case 1:
                                
                    
                                shop.showWorker();
                                System.out.println("Please select worker number?");
                                i = input.nextInt();
                             
                                ActiveWorker = Shop.WorkerList.get(i);  //
                                System.out.printf("You selected: %d %s%n",ActiveWorker.getIdNumber(), ActiveWorker.getName());
                                System.out.println("---------------------------------------------------");                                
                                System.out.println("Active Worker: "+ActiveWorker.getName());
                                break;
                            case 2:
                              
                                
                                if(ActiveCashier == null || ActiveCashier.isOnBreak() == true)
                                {    
                                   shop.showCashier();
                                    System.out.println("Please select cashier worker number?");
                                    i = input.nextInt();
                                    ActiveCashier = Shop.CashierList.get(i); //
                                    System.out.printf("You selected cashier: %d %s %n", ActiveCashier.getIdNumber(),ActiveCashier.getName());
                                    System.out.println("---------------------------------------------------");
                                    System.out.println("Active Cashier: "+ActiveCashier.getName());
                                } 
                                else
                                {
                                    System.out.println("There already an active cashier: "+ActiveCashier.getName());
                                    System.out.println("You can go update cashier worker.");
                                }
                                break;
                             case 3:
                               
                                if(ActiveStocker == null || ActiveStocker.isOnBreak() == true)
                                { 
                                    shop.showStocker();
                                    System.out.println("Please select stocker number?");
                                    i = input.nextInt();
                                    ActiveStocker = Shop.StockerList.get(i); 

                                    System.out.printf("You selected stocker: %d %s %n",ActiveStocker.getIdNumber(),ActiveStocker.getName());
                                    System.out.println("---------------------------------------------------");
                                    System.out.println("Active Stocker: "+ActiveStocker.getName());
                                }
                                 else 
                                 {
                                    System.out.println("There already an active stocker: "+ActiveStocker.getName());
                                    System.out.println("You can go update stocker worker.");
                                 }
                                break;
                            case 4:                               
                               
                                total_serving.clear(); //clear old serving for new customer
                                shop.showCustomer();
                                System.out.println("Which customer is ordering?");
                               
                                i = input.nextInt();       
                                ActiveCustomer = Shop.CustomerList.get(i);
                                System.out.printf("You selected customer: %d %s %n ",ActiveCustomer.getIdNumber(),ActiveCustomer.getName());
                                System.out.println("---------------------------------------------------");
                                System.out.printf("Active customer: %s %n",ActiveCustomer.getName());
                                break;
 /*create ice_cream*/       case 5:
                                int serving_type;
 
                                System.out.println("What type of ice cream serving would you like?");
                                System.out.println("Press 1: Cones");
                                System.out.println("Press 2: Sundaes");
                                System.out.println("Press 3: Splits");
                                System.out.println("Press 4: Floats");
                                System.out.println("Press 5: Sodas");

                                serving_type = input.nextInt(); 
                                int ice_number,num; 
                                double price =0.0;
                                IceCream ice_cream;
                                IceCream_selection = new ArrayList<>();
                                switch(serving_type)
                                {
                                    case 1: System.out.println("What type of cone do you like?");
                                            System.out.println("Press 1: cake cone");
                                            System.out.println("Press 2: sugar cone");
                                            System.out.println("Press 3: waffle cone");
                                            int cone = input.nextInt();

                                            System.out.println("How many scoops do you like to have in your cone? (You may have up to 3)");
                                            num = input.nextInt();
                                                
                                            price = 0.0;
                                            IceCream_selection.clear();
                                            
                                            while(num > 0)
                                            {
                                                shop.showIceCream();
                                                System.out.println("17-No more servings");
                                                System.out.println();
                                                System.out.println("Which flavor do you want?");
                                                ice_number = input.nextInt()-1;

                                                if(ice_number == 16)
                                                {
                                                    break;
                                                }
                                                ice_cream = Shop.IceList.get(ice_number);
                                                
                                                try{
                                                    if(ice_cream.getScoops() > 0)
                                                    {   
                                                       // ice_cream.setScoops(-1);
                                                        IceCream_selection.add(ice_cream.getOneIceCream());
                                                        price += ice_cream.getPrice();
                                                        System.out.println("You selected IceCream:"+ ice_cream.getName());
                                                        System.out.println("---------------------------------------------------");
                                                        System.out.println("Total ice cream so far is for the serving is: "+price);
                                                      
                                                        num--;
                                                    }
                                                    else
                                                    {
                                                         throw new NotEnoughIceCream();
                                                    }
                                                }catch(NotEnoughIceCream e){
                                                    System.out.printf("%s\n",e);
                                                    System.out.println("Please select another flavor");
                                                }                                                                                                                                           
                                            }
                                            total_serving.add(shop.CreateCone(IceCream_selection,price, num,cone));
                                            break;
                                        
                                    case 2: 
                                            IceCream_selection.clear();
                                            price = 1.0;
                                            System.out.println("What do you like with your sundae?");
                                            System.out.println("Press 1: strawberry");
                                            System.out.println("Press 2: chocolate syrup");
                                            System.out.println("Press 3: marshmallow cream");
                                            System.out.println("Press 4: pineapple");
                                            System.out.println("Press 5: ketchup");
                                            System.out.println("Press 6: mustard");
                                            System.out.println("Press 7: pickle relish");

                                            int syrup = input.nextInt()-1;
                                            System.out.println("---------------------------------------------------");

                                            System.out.println("How many scoops of sundae do you like? (You may have up to 2)");
                                            num = input.nextInt();
                                            System.out.println("Would you like to include nuts? (0.No, 1.Yes)");
                                            int n = input.nextInt();

                                            boolean nuts = false;
                                            if(n==1)
                                            {
                                                nuts = true;
                                            } 
                                                                                      
                                            while(num > 0)
                                            {
                                                shop.showIceCream();
                                                System.out.println("17-No more servings");
                                                System.out.println();
                                                System.out.println("Which flavor do you want?");
                                                ice_number = input.nextInt()-1;

                                                if(ice_number == 16)
                                                {
                                                    break;
                                                }
                                                ice_cream = Shop.IceList.get(ice_number);
                                                
                                                try{
                                                    if(ice_cream.getScoops() > 0)
                                                    {   
                                                       // ice_cream.setScoops(-1);
                                                        IceCream_selection.add(ice_cream.getOneIceCream());
                                                        price += ice_cream.getPrice();
                                                        System.out.println("You selected IceCream:"+ ice_cream.getName());
                                                        System.out.println("---------------------------------------------------");
                                                        System.out.println("Total ice cream so far is for the serving is: "+price);
                                                       
                                                        num--;
                                                    }
                                                    else
                                                    {
                                                         throw new NotEnoughIceCream();
                                                    }
                                                }catch(NotEnoughIceCream e){
                                                    System.out.printf("%s\n",e);
                                                    System.out.println("Please select another flavor");
                                                }                                                                                                                                           
                                            }
                                            total_serving.add(shop.CreateSundae(IceCream_selection,price,num, syrup,nuts));
                                        
                                        break;
                                
                                case 3: 
                                    IceCream_selection.clear();
                                    
                                    price = 2.0;
                                    
                                    System.out.println("What 3 type of syrups do you like with your banana split?");
                                    System.out.println("Press 1: strawberry");
                                    System.out.println("Press 2: chocolate syrup");
                                    System.out.println("Press 3: marshmallow cream");
                                    System.out.println("Press 4: pineapple");
                                    System.out.println("Press 5: ketchup");
                                    System.out.println("Press 6: mustard");
                                    System.out.println("Press 7: pickle relish");

                                    int syrup1,syrup2,syrup3;
                                    syrup1 = input.nextInt(); 
                                    syrup2 = input.nextInt(); 
                                    syrup3 = input.nextInt(); 
                                    
                                    System.out.println("---------------------------------------------------");
                                    System.out.println("How many scoops of sundae do you like? (You may have up to 3)");
                                    num = input.nextInt();
                                    System.out.println("Would you like to include nuts? (0.No, 1.Yes)");
                                    int nu = input.nextInt();

                                    boolean nut = false;
                                    if(nu==1)
                                    {
                                        nut = true;
                                    }

                                    while(num > 0)
                                    {
                                        shop.showIceCream();
                                        System.out.println("17-No more servings");
                                        System.out.println();
                                        System.out.println("Which flavor do you want?");
                                        ice_number = input.nextInt()-1;

                                        if(ice_number == 16)
                                        {
                                            break;
                                        }
                                        ice_cream = Shop.IceList.get(ice_number);

                                        try{
                                            if(ice_cream.getScoops() > 0)
                                            {   
                                               // ice_cream.setScoops(-1);
                                                IceCream_selection.add(ice_cream.getOneIceCream());
                                                price += ice_cream.getPrice();
                                                System.out.println("You selected IceCream:"+ ice_cream.getName());
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("Total ice cream so far is for the serving is: "+price);
                                              
                                                num--;
                                            }
                                            else
                                            {
                                                 throw new NotEnoughIceCream();
                                            }
                                        }catch(NotEnoughIceCream e){
                                            System.out.printf("%s\n",e);
                                            System.out.println("Please select another flavor");
                                        }                                                                                                                                           
                                    } 
                                    total_serving.add(shop.CreateBananaSplit(IceCream_selection,price,num,syrup1,nut,syrup2,syrup3));
                                    break;
                                        
                             case 4: 
                                    IceCream_selection.clear();
                                    price = 0.05;
                                    num = 1;
                                    shop.showIceCream();
                                    System.out.println("17-No more servings");
                                    System.out.println();
                                    System.out.println("Which flavor do you want?");
                                    ice_number = input.nextInt()-1;

                                    if(ice_number == 16)
                                    {
                                        break;
                                    }
                                    
                                    do{
                                        
                                        ice_cream = Shop.IceList.get(ice_number);

                                        try{
                                            if(ice_cream.getScoops() > 1)
                                            {   
                                               // ice_cream.setScoops(-2);
                                                IceCream_selection.add(ice_cream.getOneIceCream());
                                                IceCream_selection.add(ice_cream.getOneIceCream());
                                                price += ice_cream.getPrice();
                                                price += ice_cream.getPrice();
                                                
                                          
                                                System.out.println("You selected IceCream:"+ ice_cream.getName());
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("Total ice cream so far is for the serving is: "+price);
                                                num--;
                                            }
                                            else
                                            {
                                                 throw new NotEnoughIceCream();
                                            }
                                            }catch(NotEnoughIceCream e){
                                                System.out.printf("%s\n",e);
                                                System.out.println("Please select another flavor");   
                                            }                                                                                                                                           
                                    }while(num >0);
                                    total_serving.add(shop.CreateCreamSoda(IceCream_selection,price));
                                    break;

                                case 5: 
                                    num = 1;
                                    IceCream_selection.clear();
                                 
                                    price = 1.25; 
                                    
                                    do{
                                        
                                        ice_cream = Shop.IceList.get(0);

                                        try{
                                            if(ice_cream.getScoops() > 0)
                                            {   
                                               // ice_cream.setScoops(-1);
                                                IceCream_selection.add(ice_cream.getOneIceCream());
                                                
                                                price += ice_cream.getPrice();

                                               
                                                System.out.println("You selected IceCream:"+ ice_cream.getName());
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("Total ice cream so far is for the serving is: "+price);
                                                num--;
                                            }
                                            else
                                            {
                                                 throw new NotEnoughIceCream();
                                            }
                                        }catch(NotEnoughIceCream e){
                                            System.out.printf("%s\n",e);
                                            System.out.println("Please select another flavor");   
                                        }                                                                                                                                           
                                    }while(num >0); 
                                    total_serving.add(shop.CreateRootBeer(IceCream_selection,price));
                                    break;          
                                }            
                        }
                      }while(create != 6);
                      break;
                
                
/*Update Menu*/  case 3:
                    int update;    
                    do{
                        System.out.println("Update Menu:");
                        System.out.println("    1. Update Worker");
                        System.out.println("    2. Update Cashier");
                        System.out.println("    3. Update Stocker");
                        System.out.println("    4. Update Customer");
                        System.out.println("    5. Update Ice Cream");
                        System.out.println("    6. Return to previous Menu");
                        System.out.println("************************************");
                        System.out.println("***Please enter the option number:***");
                        update = input.nextInt();
                        
                        int i;
                        switch(update)
                        {
                            case 1:
                                shop.showWorker();
                                System.out.println("Which worker number need to be update?");
                                i = input.nextInt();
                                Worker up = Shop.WorkerList.get(i); 
                                System.out.printf("You selected update worker: ID %d %s %n",up.getIdNumber(),up.getName());
                                System.out.println("---------------------------------------------------");
                                System.out.println("Please enter the update information in the order of : Type worker, ID,Name,customers served, scoops served, $taken in");
                                input.nextLine();
                                String worker = input.nextLine();
                                shop.UpdateWorker(i,worker);
                                break;
                            case 2:
                                shop.showCashier();
                                 System.out.println("Which cashier worker number need to be update?");
                                i = input.nextInt();
                                CashierWorker cas = Shop.CashierList.get(i); 

                                System.out.printf("You selected update cashier worker: ID %d %s %n",cas.getIdNumber(),cas.getName());
                                System.out.println("---------------------------------------------------");
                                System.out.println("Please enter the update information in the order of : Type worker, ID,Name,customers served, scoops served, $taken in, on break, patience level");
                                input.nextLine();
                                String cashier = input.nextLine();
                                shop.UpdateCashier(i,cashier);
                                break;
                             case 3:
                                shop.showStocker();
                                System.out.println("Which stocker worker number need to be update?");
                                i = input.nextInt();
                                Stocker sto = Shop.StockerList.get(i); 

                                System.out.printf("You selected update stocker worker: ID %d %s %n"+sto.getIdNumber(),sto.getName());
                                System.out.println("---------------------------------------------------");
                                System.out.println("Please enter the update information in the order of : Type worker, ID,Name,customers served, scoops served, $taken in, on break, stamina level");
                                input.nextLine();
                                String stocker = input.nextLine();
                              
                                shop.UpdateStocker(i,stocker);
                                break;
                            case 4:
                                shop.showCustomer();
                                System.out.println("Which customer number need to be update?");
                                i = input.nextInt();
                                Customer cus = Shop.CustomerList.get(i); 
                                System.out.printf("You selected update customer: ID %d %s %n"+cus.getIdNumber(),cus.getName());
                                System.out.println("---------------------------------------------------");
                                System.out.println("Please enter the update information in the order of :ID, Name, cash amount, credit amount, number of pennies,nickels, dimes, quarters, one, five, ten, twenty");
                                input.nextLine();
                                String customer = input.nextLine();
                                shop.UpdateCustomer(i,customer);
                                break;
                            case 5:
                                shop.showIceCream();
                                System.out.println("Which icecream number need to be update?");
                                i = input.nextInt();
                                IceCream ice = Shop.IceList.get(i); 
                                System.out.printf("You selected ice cream: ID %d %s %n",ice.getIdNumber(),ice.getName());
                                System.out.println("---------------------------------------------------");
                                System.out.println("Please enter the update information in the order of :ID, flavor,price, name, description, scoops ");
                                input.nextLine();
                                String icecream = input.nextLine();
                                shop.UpdateIceCream(i, icecream);
                                break;
                            case 6: break;
                                
                            default:           
                                System.out.println("Invalid entry. Please try again");
                                break;
                        }
                    }while(update != 6);    
                        
                    break;    
                    
                    
                    
 /*Task Menu*/  case 4: //---task menu create order
      
                    int tas;
                    do{
                        System.out.println("Task Menu");
                        System.out.println("1. Place an Order");
                        System.out.println("2. Pay for Orders");
                        System.out.println("3. Return to previous Menu");
                        tas = input.nextInt();
                        if(tas == 1)
                        {   
                            shop.CreateOrder(orderNumber,ActiveCustomer,ActiveWorker,ActiveStocker,ActiveCashier,total_serving);                            
                            orderNumber++;  
                        }
                        else if(tas == 2)
                        {
                            shop.showOrder();
                            System.out.println("What is your order number for payment?");                       
                            int order_num = input.nextInt();
                            System.out.println("$$$$$$$$$$$---------CHECK OUT-------$$$$$$$$$$$$$$");
                            System.out.println("How would you like to pay for the ice cream?");
                            System.out.println("Press 1: Credit");
                            System.out.println("Press 2: Cash");
                            int payment_option = input.nextInt();
                            if(payment_option == 1)
                            {
                                try{                       
                                    shop.CreditTransaction(order_num);  
                                }catch(NotEnoughMoney e)
                                {
                                    System.out.println(e);
                                    System.out.println("Please retry other payment option");
                                }
                            }
                            else if(payment_option ==2)
                            {
                               int pennies;
                               int nickels;
                               int dimes;
                               int quarters;
                               int dollars;
                               int five;
                               int ten;
                               int twenty; 
                               
                                System.out.println("Please enter how much you like to pay in:");
                                
                                System.out.println("Pennies:");
                                pennies = input.nextInt();
                                System.out.println("Nickles:");
                                nickels = input.nextInt();
                                System.out.println("Dimes:");
                                dimes  = input.nextInt();
                                System.out.println("Quarters:");
                                quarters = input.nextInt();
                                System.out.println("One dolar:");
                                dollars = input.nextInt();
                                System.out.println("Five dollar:");
                                five  = input.nextInt();
                                System.out.println("Ten dollar:");
                                ten = input.nextInt();
                                System.out.println("Twenty dollar");
                                twenty = input.nextInt();
                                
                                try {
                                    shop.CashTransaction(order_num,pennies, nickels, dimes, quarters, dollars, five, ten, twenty);
                                } catch (NotEnoughMoney ex) {
                                    System.out.println(ex);
                                }
                            }
                        }
                    }while(tas !=3);
                    break;
                    
                case 5: //--------------------------------->Display Menu
                    int dis;
                    do{
                        System.out.println("Display Menu");
                        System.out.println("1. What is the current list of available orders?");
                        System.out.println("2. Who is in the shop report?");
                        System.out.println("3. How much money is in the cash register?");
                        System.out.println("4. Show inventory");
                        System.out.println("5. Total report");
                        System.out.println("6. Return to previous Menu");
                        dis = input.nextInt();
                        shop.display(dis);
                    }while(dis != 6);
                    break;
                    
                 case 6: //------------------------->save data                   
                    shop.saveData();
                    break;
            }        
        }while(option != 8);
    }       
}

