/**
 * CS180 - HW03
 * This method is written to compute the largest of three numbers. 
 * The method takes 3 double precision floating point numbers as arguments and returns the largest. 
 * @author Yimin Miao, <miao28@purdue.edu>
 */
public class Large {
    public static double getLargest(double x, double y, double z) { 
    //notice here "static", because below requires use public "static" void main... So here must also be static.
        if (x >= y && x >= z)
            return x;
        else if (y >= x && y >= z)
            return y;
        else //notice hereafter shouldn't write anything, otherwise error said this is not the end
            return z;
    }
    public static void main (String[] args) {
        double largestNumber = getLargest (0.56789, 0.18940, 0.35679); 
        //name a largestNumber to print it out and try
        System.out.printf ("The largest number is: %.3f", largestNumber);
        //because later used %.3f, so here use printf. And call the largestNumber
        //notice after "..." there is a ',' instead of a '+' which won't work in printf   
        //do not forget ";" after each statement
    }
}
