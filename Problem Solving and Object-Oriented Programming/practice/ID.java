import java.util.Scanner;
/** chapter 4, 4.14
  * ordinals
 */
public class ID {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.print("Please enter ID number: ");
        int id = in.nextInt();
        if (id >= 1 && id <= 1000000 && id % 7 == 0 && id % 10 == 3) 
            System.out.print("This number can be used as an ID");
        else
            System.out.print("Illegal ID number");   
    }   
}
   