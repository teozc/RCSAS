
package rcsas;
import java.util.*;
import java.io.*;

public class Student {
    String name, gender, username, password, sportCenterID, sportID, studentID = "", SportScheduleIDs = "";
    List<String> sportScheduleIDs;
    int age;
    
    public int register() {
        try {
            String data = "";
            BufferedWriter bw = new BufferedWriter(new FileWriter("Student Records.txt", true));
            generateStudentID();
            if (studentID.equals("")) {
                throw new FileNotFoundException("Error opening file");
            }
            for (int i = 0; i < sportScheduleIDs.size(); i++) {
                if (i == sportScheduleIDs.size() - 1) {
                    SportScheduleIDs = SportScheduleIDs.concat(sportScheduleIDs.get(i));
                }
                else {
                    SportScheduleIDs = SportScheduleIDs.concat(sportScheduleIDs.get(i) + ", ");
                }
            }
            data = studentID + "\t" + name + "\t" + username + "\t" + age + "\t" + gender + "\t" + sportID + "\t" + SportScheduleIDs + "\t" + sportCenterID + "\n";
            bw.write(data);
            bw.close();
            writeUsernameAndPassword();
        }
        catch (Exception e) {
            return 0;
        }
        return 1;
    }
    
    
    public void generateStudentID() {
        int lines = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Student Records.txt"));
            while (br.readLine() != null) {
                lines++;
            }
            lines++;
            studentID = "ST" + String.format("%03d", lines);
            br.close();
        }
        catch (Exception e) {
            studentID = "";
        }
    }
    
    
    public void writeUsernameAndPassword() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Username & Password.txt", true));
            bw.write(username + "\t" + password + "\n");
            bw.close();
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    
    public static String getProfileDetails(int index, String check, String fileName) {
        try {
            String line;
            String[] tempArray;
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(check)) {
                    br.close();
                    return tempArray[index];
                }
            }
            br.close();
        }
        catch (Exception e) {
            return "-1";
        }
        return "";
    }
    
    
    public int modifyProfile() {
        try {
            String line;
            String[] tempArray;
            File oldFile = new File("Student Records.txt");
            File newFile = new File("Temp File.txt");
            BufferedReader br = new BufferedReader(new FileReader(oldFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
            while ((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(LoginSession.StudentID)) {
                    tempArray[1] = this.name;
                    tempArray[3] = Integer.toString(this.age);
                    tempArray[4] = this.gender;
                    line = String.join("\t", tempArray);
                }
                bw.write(line + "\n");
            }
            bw.close();
            br.close();
            oldFile.delete();
            newFile.renameTo(oldFile);
            int result = modifyPassword();
            if (result == -1) {
                return -1;
            }
        }
        catch (Exception e) {
            return -1;
        }
        return 0;
    }
    
    
    public int modifyPassword() {
        try {
            String line;
            String[] tempArray;
            File oldFile = new File("Username & Password.txt");
            File newFile = new File("Temp File.txt");
            BufferedReader br = new BufferedReader(new FileReader(oldFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
            while ((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(LoginSession.Username)) {
                    tempArray[1] = password;
                    line = String.join("\t", tempArray);
                }
                bw.write(line + "\n");
            }
            bw.close();
            br.close();
            oldFile.delete();
            newFile.renameTo(oldFile);
        }
        catch (Exception e) {
            return -1;
        }
        return 0;
    }
    
    
    public static List getSportList() {
        String SportCenterID = "", line;
        List<String> SportNames = new ArrayList<String>();
        String[] tempArray, SportIDs = {};
        try {
            BufferedReader br = new BufferedReader(new FileReader("Student Records.txt"));
            while ((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(LoginSession.StudentID)) {
                    SportCenterID = tempArray[7];
                    SportIDs = tempArray[5].split(", ", -1);
                    break;
                }
            }
            br.close();
            BufferedReader br1 = new BufferedReader(new FileReader("Sport Records.txt"));
            while ((line = br1.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[2].equals(SportCenterID)) {
                    SportNames.add(tempArray[1]);
                }
            }
            br1.close();
        }
        catch (Exception e) {
            return SportNames;
        }
        return SportNames;
    }
    
    
    public static List getSportScheduleList(String sportName) {
        List<String> SportScheduleList = new ArrayList<String>();
        List<String> RegisteredSportScheduleIDs = new ArrayList<String>();
        String SportCenterID = "", line, SportID = "";
        String[] tempArray;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Student Records.txt"));
            while((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(LoginSession.StudentID)) {
                    SportCenterID = tempArray[7];
                    RegisteredSportScheduleIDs = Arrays.asList(tempArray[6].split(", ", -1));
                    break;
                }
            }
            br.close();
            BufferedReader br1 = new BufferedReader(new FileReader("Sport Records.txt"));
            while((line = br1.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[1].equals(sportName) & tempArray[2].equals(SportCenterID)) {
                    SportID = tempArray[0];
                    break;
                }
            }
            br1.close();
            BufferedReader br2 = new BufferedReader(new FileReader("Sport Schedule Records.txt"));
            while((line = br2.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[1].equals(SportID)) {
                    if (!(RegisteredSportScheduleIDs.contains(tempArray[0]))) {
                        SportScheduleList.add(tempArray[2] + ", " + tempArray[3] + " (" + tempArray[0] + ")");
                    }
                }
            }
            br2.close();
        }
        catch(Exception e) {
            return SportScheduleList;
        }
        return SportScheduleList;
    }
    
    
    public static int modifyRegisteredSportSchedules(String sportName, List selectedSportScheduleIDs) {
        String line, sportID = "", sportCenterID = "";
        String[] tempArray;
        try {
            // Find out the sportCenterID
            BufferedReader br = new BufferedReader(new FileReader("Student Records.txt"));
            while((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(LoginSession.StudentID)) {
                    sportCenterID = tempArray[7];
                    break;
                }
            }
            br.close();
            // Find out the selected sportID
            BufferedReader br1 = new BufferedReader(new FileReader("Sport Records.txt"));
            while((line = br1.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[1].equals(sportName) & tempArray[2].equals(sportCenterID)) {
                    sportID = tempArray[0];
                    break;
                }
            }
            br1.close();
            // Write new content to file
            File oldFile = new File("Student Records.txt");
            File newFile = new File("Temp File.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(oldFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
            while ((line = br2.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(LoginSession.StudentID)) {
                    // Write new sport ID if there is any.
                    if (!(tempArray[5].contains(sportID))) {
                        tempArray[5] = tempArray[5] + ", " + sportID;
                    }
                    //Write new sport schedule ids.
                    tempArray[6] = tempArray[6] + ", " + String.join(", ", selectedSportScheduleIDs);
                    line = String.join("\t", tempArray);
                }
                bw.write(line + "\n");
            }
            bw.close();
            br2.close();
            oldFile.delete();
            newFile.renameTo(oldFile);
        }
        catch (Exception e) {
            return -1;
        }
        return 0;
    }
    
    
    public static List getRegisteredSportScheduleList() {
        List<String> registeredSportSchedules = new ArrayList<String>();
        List<String> registeredSportScheduleIDs = new ArrayList<String>();
        String line, line2;
        String[] tempArray, tempArray2;
        try {
            // Get registered sport schedule ids.
            BufferedReader br = new BufferedReader(new FileReader("Student Records.txt"));
            while((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(LoginSession.StudentID)) {
                    registeredSportScheduleIDs = Arrays.asList(tempArray[6].split(", ", -1));
                    break;
                }
            }
            br.close();
            // Get registered sport schedules.
            BufferedReader br1 = new BufferedReader(new FileReader("Sport Schedule Records.txt"));
            while((line = br1.readLine()) !=  null) {
                tempArray = line.split("\t", -1);
                if (registeredSportScheduleIDs.contains(tempArray[0])) {
                    BufferedReader br2 = new BufferedReader(new FileReader("Sport Records.txt"));
                    while((line2 = br2.readLine()) != null) {
                        tempArray2 = line2.split("\t", -1);
                        if (tempArray2[0].equals(tempArray[1])) {
                            registeredSportSchedules.add(tempArray2[1] + ", " + tempArray[2] + ", " + tempArray[3] + " (" + tempArray[0] + ")");
                            br2.close();
                            break;
                        }
                    }
                }
            }
            br1.close();
        }
        catch (Exception e) {
            return registeredSportSchedules;
        }
        return registeredSportSchedules;
    }
    
    
    public static int removeRegisteredSportSchedules(List<String> selectedSportScheduleIDs) {
        try {
            String line;
            String[] tempArray;
            File oldFile = new File("Student Records.txt");
            File newFile = new File("Temp File.txt");
            BufferedReader br = new BufferedReader(new FileReader(oldFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
            while ((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(LoginSession.StudentID)) {
                    List<String> sportScheduleIDs = new LinkedList<String>(Arrays.asList(tempArray[6].split(", ", -1)));
                    for (String selection: selectedSportScheduleIDs) {
                        sportScheduleIDs.remove(selection);
                    }
                    tempArray[6] = String.join(", ", sportScheduleIDs);
                    line = String.join("\t", tempArray);
                }
                bw.write(line + "\n");
            }
            bw.close();
            br.close();
            oldFile.delete();
            newFile.renameTo(oldFile);
            int result = updateSportIDs();
            if (result == -1) {
                return -1;
            }
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
    
    
    public static int updateSportIDs() {
        try {
            String line;
            String[] tempArray;
            List<String> sportScheduleIDs = new ArrayList<String>();
            List<String> sportIDs = new ArrayList<String>();
            BufferedReader br = new BufferedReader(new FileReader("Student Records.txt"));
            while((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(LoginSession.StudentID)) {
                    sportScheduleIDs = Arrays.asList(tempArray[6].split(", ", -1));
                    break;
                }
            }
            br.close();
            BufferedReader br1 = new BufferedReader(new FileReader("Sport Schedule Records.txt"));
            while((line = br1.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (sportScheduleIDs.contains(tempArray[0])) {
                    if (!(sportIDs.contains(tempArray[1]))) {
                        sportIDs.add(tempArray[1]);
                    }
                }
            }
            br1.close();
            File oldFile = new File("Student Records.txt");
            File newFile = new File("Temp File.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(oldFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
            while ((line = br2.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(LoginSession.StudentID)) {
                    tempArray[5] = String.join(", ", sportIDs);
                    line = String.join("\t", tempArray);
                }
                bw.write(line + "\n");
            }
            bw.close();
            br2.close();
            oldFile.delete();
            newFile.renameTo(oldFile);
        }
        catch (Exception e) {
            return -1;
        }
        return 0;
    }
    
    
    public static List getCoachNames() {
        List<String> coachNames = new ArrayList<String>();
        try {
            String line;
            String[] tempArray;
            BufferedReader br = new BufferedReader(new FileReader("Coach Records.txt"));
            while((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                coachNames.add(tempArray[1] + " (" + tempArray[0] + ")");
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error!");
            return coachNames;
        }
        return coachNames;
    }
    
    
    public static int writeFeedback(String CoachID, String rating, String feedback) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Feedback Records.txt", true));
            String completeFeedback = CoachID + "\t" + rating + "\t" + feedback + "\t" + LoginSession.StudentID;
            bw.write(completeFeedback + "\n");
            bw.close();
            int result = updateRating(CoachID);
            if (result == -1) {
                return -1;
            }
        }
        catch (Exception e) {
            return -1;
        }
        return 0;
    }
    
    
    public static int updateRating(String CoachID) {
        try {
            String line;
            String[] tempArray;
            int count = 0, total = 0, average = 0;
            BufferedReader br = new BufferedReader(new FileReader("Feedback Records.txt"));
            while((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(CoachID)) {
                    total += Integer.parseInt(tempArray[1]);
                    count++;
                }
            }
            average = total / count;
            br.close();
            File oldFile = new File("Coach Records.txt");
            File newFile = new File("Temp File.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(oldFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
            while ((line = br2.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(CoachID)) {
                    tempArray[11] = Integer.toString(average);
                    line = String.join("\t", tempArray);
                }
                bw.write(line + "\n");
            }
            bw.close();
            br2.close();
            oldFile.delete();
            newFile.renameTo(oldFile);
        }
        catch (Exception e) {
            return -1;
        }
        return 0;
    }
    
    
    
}
