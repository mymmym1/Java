import java.util.Scanner;
/* Chapter 4, 4.10(a)
 */

public class Coins {    
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        System.out.println("Please input cents: '5','10','25','50','100'");//This statement must be above int "cents = in.nextInt()",otherwise it won't be excuted
        int cents = in.nextInt();//under this import, you can only use nextInt(), next() for String, nextDouble() and so on
        
            
            if (cents == 1)
                 System.out.println("penny");
            else if (cents == 5)
                System.out.println("nickel");
            else if (cents == 10)
                System.out.println("dime");
            else if (cents == 25)
                System.out.println("quater");
            else if (cents == 50)
                System.out.println("half-dollar");            
            else if (cents == 100)
                System.out.println("dollar");
            else 
                System.out.println("no coin");
    }
}