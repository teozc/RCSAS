
package rcsas;
import java.util.*;
import java.io.*;

public class Admin {
    
    public static List getRecords(int searchByIndex, String searchCriteria, String fileName) {
        List<String> records = new ArrayList<String>();
        try {
            String line;
            String[] tempArray;
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[searchByIndex].equals(searchCriteria)) {
                    records.add(line);
                }
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error");
            return records;
        }
        return records;
    }
    
    
    public static List getAllRecords(String fileName) {
        List<String> records = new ArrayList<String>();
        try {
            String line;
            String[] tempArray;
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine()) != null) {
                records.add(line);
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error");
            return records;
        }
        return records;
    }
    
    
    /*public static List sortCoachRecords() {
        
        
        
        
    }*/
    
    
    
    
    
    
}
