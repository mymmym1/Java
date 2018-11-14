import java.util.Scanner;
/**
 * CS180 - HW04
 * This method is written to convert decimal to tenary
 * @author Yimin Miao, <miao28@purdue.edu>
 */
public class BaseConverter2 {   
    public static void main ( String args[] ) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a base 10 number");
        int number = in.nextInt();        
        BaseConverter2 convert = new BaseConverter2();
        System.out.println("Its 16 base number is: " + convert.converter(number));
    }
    String converter(int number) {
        int base = 16;
        int quo = 0;        
        String res = "";
        do {
            int rem; //can not initialize as  0
            rem = number % base;
            if (rem == 10)
                res += "A";
            else if (rem == 11)
                res += "B";
            else if (rem == 12)
                res += "C";
            else if (rem == 13)
                res += "D";
            else if (rem == 14)
                res += "E";
            else if (rem == 15)
                res += "F";
            else
               res += String.valueOf(rem); // remember
            quo = number / base;
            number = quo;
        } while (quo != 0);
        String outputHexadecimal = "";
        for (int i = res.length() -1; i >= 0; i--) {
            outputHexadecimal += res.charAt(i);
        }
        return outputHexadecimal;
    }
}

  
