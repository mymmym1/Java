import java.util.Scanner; 
/**
 * CS 180 - Lab 05 - Repetition
 * 
 * (Brief description of the class file)
 * 
 * @author (Yimin Miao) <(miao28@purdue.edu)>
 * 
 * @lab (Your lab section)
 *
 * @version (Feb.13,2015)
 */
public class Repetition { 
 /** Generate and print out all even numbers from 0 to 100 (inclusively) on the same line. 
 */ 
    public static void even() { 
        int[] evenNumber = new int[51]; // because there is more than one number, so need an array 
        for (int i = 0; i < 51; i++) { 
            evenNumber[i] = 2 * i; 
            System.out.print(evenNumber[i] + " ");  
        } //"println" means print one on one line. "print" can print everytime on one line. 
    }    
/** get the value of 2^(exp),increased values until less than 1000  
 */ 
    public static void powers() { 
        int exp = 0; 
        double n = 0.0; 
        while (exp < 10) {  //2exp10=1024 
            n = Math.pow(2, exp); 
            exp++; 
            System.out.print(n + " "); 
        }  
    } 
 /** Print out the alphabet using Characters and a 'for loop'. 
 */ 
    public static void alphabet() { 
        int i = 0; 
        char letters = 'a'; 
        for (i = 0; i < 26; i++) {  
            letters = (char)((int)('a') + i); //remember this           
            System.out.print(letters);  
        } 
    } 
/** Verically print out string 
 */ 
    public static void vertical (String s) { 
        int n = s.length(); // don't forget "()" after length! 
        int i = 0;         
        for (i = 0; i < n; i++) { 
            char characters = s.charAt(i); //this statement must be inside the{} 
            System.out.println(characters); 
        } 
    } 
    
/** Find average, highest, lowest
  */  
    public static void testResults() {          
        int sum = 0; 
        int count = 0; 
        int lowest = 0; 
        int highest = 0; 
        int average = 0;        
        Scanner in = new Scanner (System.in);
        System.out.println("Enter scores now:"); 
        //Should not type "score = in.nextInt()" here, otherwise the first score will be ignored                     
        do {
            int x = in.nextInt();               
            if (x < lowest || lowest == 0) //here the initial of lowest = 0, which is always the smallest
                lowest = x;
            if (x > highest)
                highest = x;           
            sum += x;
            count ++;                 
            } while (in.hasNextInt());           
        average = sum / count;        
        System.out.println("=====-----=====-----=====-----====="); 
        System.out.println("=           Test Results          ="); 
        System.out.println("= Average:                     " + average + " ="); 
        System.out.println("= Lowest:                      " + lowest  + " ="); 
        System.out.println("= Highest:                    " + highest + " ="); 
        System.out.println("=====-----=====-----=====-----====="); 
    } 
    
/** Print integer reversely
 */
    public static void reverse() { 
        int num = 0;          
        Scanner in = new Scanner (System.in); 
        System.out.println("Enter an integer please:");        
        num = in.nextInt();          
        while ( (num / 10) != 0 ) { // 124/10=12...4 
            System.out.print(num % 10); //print 4
            num = num / 10; // 12 = 124/10
        } 
        System.out.print(num);          
    }        
    
/** Print out perfect squares and cubes between 1 and 25000.
 */
    public static void sqrAndCube() {
        for(int i = 1; i < 25000; i++ ) { 
           if ( Math.sqrt(i) == (int) Math.sqrt(i) && Math.cbrt(i) == (int) Math.cbrt(i))
               System.out.println(i + " is the cube of " + (int) Math.cbrt(i)  +" and the square of " + (int) Math.sqrt(i)+".");  
       } 
   }
     
    public static void main(String[] args) { 
        Repetition r = new Repetition(); 
        r.even();// call the even() method 
        System.out.println();//cant put r.even inside because it is a void method having no return 
        r.powers(); 
        System.out.println(); 
        r.alphabet(); 
        System.out.println(); 
        r.vertical ("Hello"); 
        System.out.println();
        r.testResults();
        System.out.println();
        r.reverse();
        System.out.println();
        r.sqrAndCube();
        System.out.println();
    } 
}
