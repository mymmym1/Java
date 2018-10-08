import java.io.*;
import java.util.*;
public class NumericFinder {
    String fileName;
    public NumericFinder(String fileName) {
        this.fileName = fileName;
    }
    public static boolean isStr2Double (String str1) {
        try {
            Double.parseDouble(str1);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isStr2Int (String str2) {
        try {
            Integer.parseInt(str2);  
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }       
    public static boolean isEnd (String str3, char c) {        
        c = str3.charAt(str3.length() - 1);
        if (c == '.')
            return true;         
        else
            return false;
    }
    void printNumeric() {
        File inFile = new File(fileName);
//        File outFile = new File("C:\\numberFile.txt");
        Scanner in = null;
//        PrintWriter out = null;
        String word;
//        double a = 0.0;
//        int b = 0;        
        try {
            in = new Scanner(inFile);
//            out = new PrintWriter(outFile);            
            while (in.hasNext()) {
                word = in.next(); 
                char dot = word.charAt(word.length() - 1);
                try {                     
                    if (isStr2Int (word))
                        System.out.println("Integer: " + word);
                    else if (isEnd (word, dot)) {
                        String substr = word.substring(0, word.length() - 1);
                        if (isStr2Int (substr))
                            System.out.println("Double: " + substr + ".0");
                        else if (isStr2Double (substr))
                            System.out.println("Double: " + substr);
                    }
                    else if (isStr2Double (word))
                            System.out.println("Double: " + word);
                } catch (NumberFormatException e) {
                    System.out.print("This is not number.");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist. Provide a valid filename.");
        }
        finally {
            if (in != null) in.close();
//            if (out != null) out.close();
        }                     
    }
    public static void main(String[] args) {
        NumericFinder nf = new NumericFinder("C:\\hw17.txt");
        nf.printNumeric();       
    }    
}
