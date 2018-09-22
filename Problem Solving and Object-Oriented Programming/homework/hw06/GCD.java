import java.util.Scanner;
/**
 * CS180 - HW04
 * This method is written to compute the greatest common divisor (GCD) of two integers 
 * @author Yimin Miao, <miao28@purdue.edu>
 */
public class GCD { 
    int num; 
    int greatestCommonDivisor(int a, int b) {
        int big;
        int small;
        if (a > b) { 
            big = a; 
            small = b;
        } 
        else {
            big = b; 
            small = a;
        }   
        int remainder = -1;
        while (remainder != 0) {                
            remainder =  big % small; // 49 % 9 = 5...4
            big = small; // 9 % 4 = 2...1
            small = remainder;// 4 % 1 = 4...0
        }
        return num = big; 1
    }
    public static void main (String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Please input a positive integer a");
        int a = in.nextInt();
        System.out.println("Please input a positive integer b");
        int b = in.nextInt();    
           
        GCD g = new GCD();
        System.out.println("GCD is " + g.greatestCommonDivisor(a, b));
    }
}
