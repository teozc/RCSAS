/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rcsas;

import java.io.*;

/**
 *
 * @author System Manager
 */
public class Coach {
    String coachID, name, dateJoined, dateTerminated, phone, address, sportCenterID, sportCenterName, sportID, sportName;
    float hourlyRate;
    String rating;
    
    public Coach(String _name, String _dateJoined, String _dateTerminated, float _hourlyRate, String _phone, String _address, String _sportCenterID, String _sportID, String _sportName, String _rating){
        this.generateID();
        name = _name;
        dateJoined = _dateJoined;
        dateTerminated = _dateTerminated;
        hourlyRate = _hourlyRate;
        phone = _phone;
        address = _address;
        sportCenterID = _sportCenterID;       
        sportID = _sportID;
        sportName = _sportName;
        rating = _rating;
        if (sportCenterID.equals("SC001")){
            sportCenterName = "Kuala Lumpur";
        }
        else if (sportCenterID.equals("SC002")){
            sportCenterName = "Selangor";
        }
        else if (sportCenterID.equals("SC003")){
            sportCenterName = "Sabah";
        }
        else if (sportCenterID.equals("SC004")){
            sportCenterName = "Kedah";
        }
        else if (sportCenterID.equals("SC005")){
            sportCenterName = "Sarawak";
        }
    }
    
    public int addRecord(){
        try {
            if (getSportID() == 1){
                return 1;
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter("Coach Records.txt", true));
            bw.write(coachID + "\t" + name + "\t" + dateJoined + "\t" + dateTerminated + "\t" + hourlyRate + "\t" + phone + "\t" + address + "\t" + sportCenterID + "\t" + sportCenterName + "\t" + sportID + "\t" + sportName + "\t" + rating + "\n");
            bw.close();
            return 0;
        }
        catch(Exception e) {
            return 1;
        }
    }

    
    private void generateID(){
        int lines = 0;
        try {
            File f = new File("Coach Records.txt");
            BufferedReader br = new BufferedReader(new FileReader("Coach Records.txt"));
            while (br.readLine() != null) {
                lines++;
            }
            lines++;
            coachID = "CD" + String.format("%03d", lines);
            br.close();
        }
        catch(Exception e) {
            coachID = "";
        }
    }
    
    public int getSportID() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Sport Records.txt"));
            String temp;
            String[] data;
            while ((temp = br.readLine()) != null) {
                data = temp.split("\t", -1);
                if (data[1].equals(sportName) && data[2].equals(sportCenterID)) {
                    sportID = data[0];
                    break;
                }
            }
            br.close();
            return 0;
        } 
        catch (Exception e) {
            return 1;
        }
    }
    
    public int modifyRecord(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Coach Records.txt"));
            Object[] lines = br.lines().toArray();
            String[] data;
            if (getSportID() == 1){
                return 1;
            }
            for (int i = 0; i < lines.length; i++) {
                data = lines[i].toString().split("\t");
                if (coachID.equals(data[0])) {
                    lines[i] = coachID + "\t" + name + "\t" + dateJoined + "\t" + dateTerminated + "\t" + hourlyRate + "\t" + phone + "\t" + address + "\t" + sportCenterID + "\t" + sportCenterName + "\t" + sportID + "\t" + sportName + "\t" + rating;
                    break;
                }
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter("Coach Records.txt"));
            for (int i = 0; i < lines.length; i++){
                bw.write(lines[i].toString());
                bw.newLine();
            }
            bw.close();
            br.close();
            return 0;
        }
        catch (Exception e) {
            return 1;
        }
    }
}
