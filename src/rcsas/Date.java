/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rcsas;

/**
 *
 * @author System Manager
 */
public class Date {
    String day, month, year;
    
    public Date(String _day, String _month, String _year){
        day = _day;
        month = _month;
        year = _year;
    }
    public boolean isLeapYear(){
        int y = Integer.parseInt(year);
        if (y % 4 == 0) {
            if (y % 100 == 0){
                if (y % 400 == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    
    public int getMonthType(){
        if (month == "2"){
            return 2;
        }
        else if (month == "4" || month == "6" || month == "9" || month == "11"){
            return 1;
        }
        else{
            return 0;
        }
    }
}
