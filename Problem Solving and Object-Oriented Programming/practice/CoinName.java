import java.util.Scanner;
/* Chapter 4, 4.10(b)
 */

public class CoinName {    
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        System.out.println("Please input coin name.");
        String coinName = in.next();//under this import, you can only use nextInt(), next() for String, nextDouble() and so on
                
            if (coinName.equals("penny"))//remember use .equals("name")
                 System.out.println("1");
            else if (coinName.equals("nickel"))
                System.out.println("5");
            else if (coinName.equals("dime"))
                System.out.println("10");
            else if (coinName.equals("quater"))
                System.out.println("25");
            else if (coinName.equals("half-dollar"))
                System.out.println("50");            
            else if (coinName.equals("dollar"))
                System.out.println("100");
            else 
                System.out.println("unknown coin");
    }
}