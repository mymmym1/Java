import java.util.Scanner;
/**
 * CS180 - Lab 02
 * The functionality of the program is given the lengths of the two sides a and b of a right triangle, 
 * calculates the length of the hypotenuse c.
 * @author Yimin Miao, <miao28@purdue.edu>
 */
 
public class Pythagoras {
    public static void main(String[] args) {
        Pythagoras p = new Pythagoras(); // creat an object instance of the class Pythagoras; p: variable
        
        Scanner scanner = new Scanner(System.in); // create a console scanner object
        System.out.print("Enter side 'a': "); // prompt the user for input
        int a = scanner.nextInt(); // read 'a' from the console
        
        System.out.print("Enter side 'b': "); // prompt the user for input
        int b = scanner.nextInt(); // read 'b' from the console
        
        double h = p.getHypotenuse(a, b);
        System.out.println("Hypotenuse: " + h);
    }
    
    public double getHypotenuse(int a, int b) {
        double result;
        result = Math.sqrt(a * a + b * b); { // public instance method
            return result;
        }        
    }    
}
