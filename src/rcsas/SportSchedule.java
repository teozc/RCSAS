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
public class SportSchedule {
    String sportScheduleID, sportID, day, time, coachID, sportCenterID, sportCenterName;
    
    public SportSchedule(String _sportID, String _day, String _time, String _coachID, String _sportCenterID){
        sportID = _sportID;
        day = _day;
        time = _time;
        coachID = _coachID;
        sportCenterID = _sportCenterID;
        if (sportCenterID.equals("SC001")) {
            sportCenterName = "Kuala Lumpur";
        } else if (sportCenterID.equals("SC002")) {
            sportCenterName = "Selangor";
        } else if (sportCenterID.equals("SC003")) {
            sportCenterName = "Sabah";
        } else if (sportCenterID.equals("SC004")) {
            sportCenterName = "Kedah";
        } else if (sportCenterID.equals("SC005")) {
            sportCenterName = "Sarawak";
        }
    }
    
    public int addRecord(){
        try{
            generateID();
            BufferedWriter bw = new BufferedWriter(new FileWriter("Sport Schedule Records.txt", true));
            bw.write(sportScheduleID + "\t" + sportID + "\t" + day + "\t" + time + "\t" + coachID + "\t" + sportCenterID + "\t" + sportCenterName + "\n");
            bw.close();
            return 0;
        }
        catch(Exception e){
            return 1;
        }
    }
    
    private void generateID(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Sport Schedule Records.txt"));
            int line = 0;
            while (br.readLine() != null){
                line++;
            }
            line++;
            sportScheduleID = "SS" + String.format("%03d", line);
            br.close();
        }
        catch(Exception e){
            System.out.println("An error occurred.");
        }
    }
    
    public int modifyRecord(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Sport Schedule Records.txt"));
            Object[] lines = br.lines().toArray();
            String[] data;
            for (int i = 0; i < lines.length; i++){
                data = lines[i].toString().split("\t");
                if (data[0].equals(sportScheduleID)){
                    lines[i] = sportScheduleID + "\t" + sportID + "\t" + day + "\t" + time + "\t" + coachID + "\t" + sportCenterID + "\t" + sportCenterName;
                    break;
                }
            }
            br.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter("Sport Schedule Records.txt"));
            for (int i = 0; i < lines.length; i++){
                bw.write(lines[i].toString());
                bw.newLine();
            }
            bw.close();
            return 0;
        }
        catch(Exception e){
            return 1;
        }
    }
}
