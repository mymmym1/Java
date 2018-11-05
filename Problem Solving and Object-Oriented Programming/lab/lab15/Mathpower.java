import java.io.*;

public class Mathpower {
    public static long power (int a, int b) {
        if (b == 0)
            return 1;
        else 
            return a * power (a, b-1);
    }
    public static long power2 (int a, int b) {
        int pow = 1;
        for (int i = 0; i < b; i++)         
            pow *= a;  
        return pow; 
    }
    public static int fileCount (File f) {
        int count = 0;       
        File[] files = f.listFiles();
        if (f.isDirectory()) {
            for(File file : files)             
                count += fileCount(file);          
            count++;  
        }
        else 
            count += 1;                         
        
        return count;
    }
    public static void hanoi (int n, char src, char dest, char aux) {
        if (n == 1) 
            System.out.printf("move disk from peg %s to peg %s\n", src, dest);
        else {
            hanoi(n-1, src, dest, aux);
            hanoi(1, src, aux, dest);
            hanoi(n-1, aux, src, dest);
        }  
    }
    public static int mysterySeries (int i, int j) {
        if (i < 0 || j < 0 || i < j)
            return 0;
        else if (i == j || j == 0)
            return 1;
        else 
            return mysterySeries(i-1, j) + mysterySeries(i-1, j-1);
    }
    public static void main (String[] args) {
        System.out.println(power(3,3));
        System.out.println(power2(3,3));
        System.out.println(mysterySeries(6,3));  
        System.out.println(fileCount(new File("/homes/miao28/cs180/lab14")));
    }
}
