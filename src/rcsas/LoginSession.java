package rcsas;
import java.io.*;

public class LoginSession {
    String username, password;
    static String StudentID = "";
    static String Username = "";

    public int validation() {
        String line;
        String[] tempArray;
        if (username.equals("admin") & password.equals("admin123")) {
            return 1;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader("Username & Password.txt"));
            while ((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[0].equals(username) & tempArray[1].equals(password)) {
                    br.close();
                    getStudentID(username);
                    Username = username;
                    return 2;
                }
            }
            br.close();
            return 0;
        }
        catch (Exception e) {
            return -1;
        }
    }
    
    public void getStudentID(String username) {
        try {
            String line;
            String[] tempArray;
            BufferedReader br = new BufferedReader(new FileReader("Student Records.txt"));
            while ((line = br.readLine()) != null) {
                tempArray = line.split("\t", -1);
                if (tempArray[2].equals(username)) {
                    StudentID = tempArray[0];
                    break;
                }
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }
}
