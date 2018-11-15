import java.util.Scanner;
/* Chapter 4, 4.11
 */

public class Coins2 {    
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        System.out.println("Please input cents: '5','10','25','50','100'");//This statement must be above int "cents = in.nextInt()",otherwise it won't be excuted
        int cents = in.nextInt();//under this import, you can only use nextInt(), next() for String, nextDouble() and so on
        String coin = "";//Initialize case
        switch (cents) { //Initialize case what
            case 1: coin = "penny"; break;
            case 5: coin = "nickel"; break;
            case 10: coin = "dime"; break;
            case 25: coin = "quater"; break;
            case 50: coin = "half-dollar"; break;
            case 100: coin = "dollar"; break;
            default: coin = "no coin"; break;
        }
        System.out.print(coin);
    }
}
          