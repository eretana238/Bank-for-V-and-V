import models.people.Customer;
import models.people.Staff;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    public HashMap<String, Customer> readCSV(String fileName){
        HashMap<String, Customer> map = new HashMap<>();
        try{
            Scanner scnr = new Scanner(new File(fileName));
            scnr.nextLine();
            while(scnr.hasNextLine()){
                String[] userInfo = scnr.nextLine().split(",");
                // Customer c = new Customer(userInfo[1], userInfo[2], );

            }

        } catch (IOException e){

        }




        return map;
    }
}
