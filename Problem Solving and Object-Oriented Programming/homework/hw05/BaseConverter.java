import java.util.Scanner;
/**
 * CS180 - HW04
 * This method is written to convert decimal to tenary
 * @author Yimin Miao, <miao28@purdue.edu>
 */
public class BaseConverter {   
    public static void main ( String args[] ) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a base 10 number");
        int number = in.nextInt();
        
        BaseConverter convert = new BaseConverter();         
        System.out.println("Your number in base 3 is");
        System.out.println( convert.converter(number));
    }   

    int converter(int number) {
        int base = 3;
        int rem = 0;  
        int quo = 0;    
        String res = "";
        String outputTernary = "";
        do {  
            rem = number % base;
            res += String.valueOf(rem);  //store the remainder into a string
            quo = number / base; 
            number = quo;  //take the quotient and divide 3 again        
        } while (quo != 0);  //if quotient is zero, done!
        for (int i = res.length() - 1; i >= 0; i--) { //reverse the direction of your string
            outputTernary += res.charAt(i);  
        }
        return Integer.parseInt(outputTernary); //output as an integer!
    }
}
