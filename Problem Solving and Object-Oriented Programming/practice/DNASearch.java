import java.util.Scanner;
public class DNASearch {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);       
        Boolean valid;
        char c;
        String sequence, subsequence;
        do {
            System.out.print("Please enter the DNA sequence: ");
            sequence = in.next().toUpperCase();
            valid = true;
            for (int i = 0; i < sequence.length(); i++){
                c = sequence.charAt(i);                
                if (c != 'A'&& c != 'T'&& c != 'C'&& c != 'G') {
                    valid = false;                
                    System.out.print("Invalid DNA sequence.");
                }
            }
        }while(!valid);
        do {
            System.out.print("Please enter the subsequence for search: ");
            subsequence = in.next().toUpperCase();
            valid = true;
            for (int i = 0; i < subsequence.length(); i++){
                c = subsequence.charAt(i);                
                if(c != 'A'&& c != 'T'&& c != 'C'&& c != 'G') {                    
                    valid = false;
                    System.out.print("Invalid DNA subsequence.");
                }
            }
        }while(!valid);
        for (int i = 0; i < sequence.length() - subsequence.length() + 1; i++) {
            for (int j = 0; j < subsequence.length(); j++) {
                if (subsequence.charAt(j) != sequence.charAt(i+j))
                    break;
                else
                    System.out.print("subsequence occured at the index of sequence: " + sequence.indexOf(subsequence, 0));
            }
        }
    }
}
            
        
            