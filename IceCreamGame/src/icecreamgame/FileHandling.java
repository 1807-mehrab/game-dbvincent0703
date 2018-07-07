/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Formatter;

/**
 *
 * @author vb
 */
public class FileHandling {
    
    ArrayList <String> CustomerList = new ArrayList<>();
    ArrayList <String> WorkerList = new ArrayList<>();
    ArrayList <String> IceList = new ArrayList<>();
    private Object saveCustomer;
    private Scanner get;
    private Formatter write;
    
    public ArrayList<String> readIce() //read in list of icecream from outside text file
    {
        //File iceFile = new File("IceCream.txt");
                String sTemp;
                
        try{
            get = new Scanner(new File("IceCream.txt"));
            while(get.hasNext())
            {
                sTemp = get.nextLine();
                IceList.add(sTemp);
                
            } 
            
        } catch (FileNotFoundException ex){
                System.out.println("No IceCream file found");
        get.close();
    }
    return IceList;
    }
    
    public ArrayList<String> readCustomer() //read in list of customer from outside text file
    {
        //File customerFile = new File("CustomerFile.txt");
        String sTemp;

        try{
            get = new Scanner(new File("CustomerFile.txt"));
            while(get.hasNext())
            {
                sTemp = get.nextLine();
                CustomerList.add(sTemp);
                //System.out.println(s);
            } 
            
        } catch (FileNotFoundException ex){
                System.out.println("No CustomerFile found");
        }
        get.close();
        return CustomerList;
    }

    public ArrayList<String> readWorker() //read in list of worker from outside text file
    {
            //File workerFile = new File("WorkerFile.txt");
            String sTemp;

        try{
            get = new Scanner(new File("WorkerFile.txt"));
            while(get.hasNext())
            {
                sTemp = get.nextLine();
                WorkerList.add(sTemp);
                //System.out.println(sTemp);
            } 
            
            } catch (FileNotFoundException ex){
                System.out.println("No WorkerFile found");
        }
        get.close();
        return WorkerList;
     }
    public void writeIceCream(ArrayList<IceCream> ice_cream) //write out list of icecream from outside text file
    {   
        try{
            write = new Formatter("savedIceCreams.txt");
        }
        catch(Exception e)
        {
            System.out.println("Can't create file");
        }
        System.out.println("Saving ice cream list:");
        System.out.println("************************************");
        for(IceCream ice: ice_cream)
        {
            System.out.printf("%d,%s,%.2f,%s,%s,%d\n",ice.getIdNumber(),ice.getFlavor(),ice.getPrice(),ice.getName(),ice.getDescription(),ice.getScoops());
            write.format("%d,%s,%.2f,%s,%s,%d\n",ice.getIdNumber(),ice.getFlavor(),ice.getPrice(),ice.getName(),ice.getDescription(),ice.getScoops());
        }
        write.close();
    }    
     
    public void writeCustomer(ArrayList<Customer> customerList)//write out list of customer from outside text file
    {   
        try{
            write = new Formatter("savedCustomers.txt");
        }
        catch(Exception e)
        {
            System.out.println("Can't create file");
        }
        System.out.println("Saving customer list:");
        System.out.println("************************************");
        for(Customer cus: customerList)
        {
            System.out.printf("%d,%s,%.2f,%.2f,%d,%d,%d,%d,%d,%d,%d,%d\n",cus.getIdNumber(),cus.getName(),cus.getCash(), cus.getCredit(),cus.getPennies(),cus.getNickels(),cus.getDimes(),cus.getQuarters(),cus.getOne_dollar(),cus.getFive_dollar(),cus.getTen_dollar(),cus.getTwenty_dollar());
            write.format("%d,%s,%.2f,%.2f,%d,%d,%d,%d,%d,%d,%d,%d\n",cus.getIdNumber(),cus.getName(),cus.getCash(), cus.getCredit(),cus.getPennies(),cus.getNickels(),cus.getDimes(),cus.getQuarters(),cus.getOne_dollar(),cus.getFive_dollar(),cus.getTen_dollar(),cus.getTwenty_dollar());
        }
        write.close();
        
    } 
    
    public void writeWorker(ArrayList<Worker> workerList, ArrayList<CashierWorker> CashierList,ArrayList<Stocker> StockerList)//write out list of worker from outside text file
    {
        try{
            write = new Formatter("savedWorkers.txt");
        }
        catch(Exception e)
        {
            System.out.println("Can't create file");
        }
        System.out.println("Saving worker list:");
        System.out.println("************************************");
        for(Worker wor: workerList)
        {
            System.out.printf("%s,%d,%s,%d,%d,%.2f\n",wor.getType(),wor.getIdNumber(),wor.getName(),wor.getCustomers_served(),wor.getScoops_served(),wor.get$takenin());
            write.format("%s,%d,%s,%d,%d,%.2f\n",wor.getType(),wor.getIdNumber(),wor.getName(),wor.getCustomers_served(),wor.getScoops_served(),wor.get$takenin());
        }
        System.out.println("Saving cashier list:");
        System.out.println("************************************");
        for(CashierWorker wor: CashierList)
        {
            System.out.printf("%s,%d,%s,%d,%d,%.2f\n",wor.getType(),wor.getIdNumber(),wor.getName(),wor.getCustomers_served(),wor.getScoops_served(),wor.get$takenin());
            write.format("%s,%d,%s,%d,%d,%.2f\n",wor.getType(),wor.getIdNumber(),wor.getName(),wor.getCustomers_served(),wor.getScoops_served(),wor.get$takenin());
        }
         System.out.println("Saving stocker list:");
        System.out.println("************************************");
        for(Stocker wor: StockerList)
        {
            System.out.printf("%s,%d,%s,%d,%d,%.2f\n",wor.getType(),wor.getIdNumber(),wor.getName(),wor.getCustomers_served(),wor.getScoops_served(),wor.get$takenin());
            write.format("%s,%d,%s,%d,%d,%.2f\n",wor.getType(),wor.getIdNumber(),wor.getName(),wor.getCustomers_served(),wor.getScoops_served(),wor.get$takenin());
        }
                
        write.close();
    }   
}    
    

