import java.util.Scanner;
/** chapter 4, 4.13
  * ordinals
 */
public class Location {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.print("Please enter the code: ");
        int code = in.nextInt();
        String location;
        if (code == 917) 
            location = "Cellular";    
        else if (code == 212 || code == 347 || code == 646 || code == 718)
            location = "New York City";
        else if (code == 315) //must use "else if", because "else if" belongs to the "if" above, otherwise it is excuted individually -> only the last "if" counts which will always give the last result
            location = "Syracuse";
        else if (code == 516) 
            location = "Nassau County";
        else if (code == 518) 
            location = "Albany";
        else             
            location = "Unknown Area Code";
               
        System.out.print("The location is " + location);
    }   
}
   