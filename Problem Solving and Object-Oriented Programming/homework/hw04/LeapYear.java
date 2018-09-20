/**
 * CS180 - HW03
 * Implement a class LeapYear with method boolean isLeapYear(int year). 
 * This method returns true if year is a leap year, otherwise false. 
 * A year is a leap year if it is divisible by 4, unless it is also divisible by 100, 
 * except that all years divisible by 400 are leap years. 
 * @author Yimin Miao, <miao28@purdue.edu>
 */
public class LeapYear {
    static boolean isLeapYear(int year) { 
    //if in main the number int year is entered, put "static" here
        if (year % 4 == 0 && year % 100 != 0)
            return true;
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0 && year % 400 != 0)
            return false;
        else
            return false;
    }
    
    public static void main(String[] args) {  
        boolean theYear = isLeapYear(2013);
        System.out.println(theYear);
    }
}
     
