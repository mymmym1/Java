import java.util.Scanner;
/* Chapter 4, 4.9(a)
 */
public class Larger {
    public static void main (String[] args) {
        Scanner in = new Scanner (System.in);
            System.out.print("Please enter number a");
            double a = in.nextDouble();
        System.out.print("Please enter number b");
            double b = in.nextDouble();
            if (a>b)
                System.out.println("The larger number is " + a);
            else if (a<b)
                System.out.println("The larger number is " + b);
            else
                System.out.println("The two numbers are equal.");
    }
}
        