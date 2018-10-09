import java.io.*;
import javax.swing.*;
import java.util.*;
public class NumericFinderGUI {
    String fileName;
   
    public NumericFinderGUI() {        
        //if selected file not valid, ERRORMESSAGE "Select a valid input file."
        while (true) { //input file using JFileChooser
            try {
                JFileChooser fc = new JFileChooser();        
                fc.setDialogTitle("Choose Important File");
                fc.showOpenDialog(null);        
                File f = fc.getSelectedFile(); 
                fileName = f.getPath();
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog (null, "Select a valid input file.",
                                               "ERROR",
                                               JOptionPane.ERROR_MESSAGE); 
            }            
        }   // prompt the user again to choose a file using JFileChooser.        
    }  
    void showNumeric() { //show InformationMESSAGE    
        File inFile = new File(fileName);
        Scanner in = null;
        String message = "";
        String word;
        try {            
            in = new Scanner(inFile);
            while (in.hasNext()) {
                word = in.next(); 
                System.out.print(word);
                char dot = word.charAt(word.length() - 1);
                try {                     
                    if (isStr2Int (word))  
                        message += "\n" + "Integer: " + word;                        
                    else if (isEnd (word, dot)) {
                        String substr = word.substring(0, word.length() - 1);
                        if (isStr2Int (substr))       
                            message += "\n" + "Double: " + substr + ".0";                            
                        else if (isStr2Double (substr))                
                            message += "\n" + "Double: " + substr;                           
                    }
                    else if (isStr2Double (word))
                        message += "\n" + "Double: " + word;
                } catch (NumberFormatException e) {
                    System.out.print("This is not number.");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist. Provide a valid filename.");
        } finally { 
            if (in != null) 
                in.close(); 
        }          
        JOptionPane.showMessageDialog(null, message, "Numeric Printer", JOptionPane.INFORMATION_MESSAGE); 
    }
    public static void main(String[] args) {
        NumericFinderGUI nf = new NumericFinderGUI();
        nf.showNumeric();       
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
}
