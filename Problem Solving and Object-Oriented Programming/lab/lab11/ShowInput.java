import javax.swing.JOptionPane;
 
public class ShowInput {
    public static void main(String[] args) {
        String result;
        
        // showInputDialog with simplified argument list...
        result = JOptionPane.showInputDialog("Please provide an answer:");
        System.out.printf("result = \"%s\"\n", result);
 
        // showInputDialog with simplified argument list and default value...
        result = JOptionPane.showInputDialog("Please provide an answer:", "42");
        System.out.printf("result = \"%s\"\n", result);
        
        // showInputDialog with drop-down box...
        String[] selections = { "red", "blue", "green", "cyan", "magenta", "gold" };
        result = (String) JOptionPane.showInputDialog(null, 
                                                      "Choose a color:",
                                                      "Color Chooser",
                                                      JOptionPane.INFORMATION_MESSAGE,
                                                      null, /* icon */
                                                      selections,
                                                      "green");
        System.out.printf("result = \"%s\"\n", result);
        
        // showInputDialog with list box (more than 20 items)...
        String[] alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ");
        result = (String) JOptionPane.showInputDialog(null,
                                                      "Choose your favorite letter:",
                                                      "Letter Chooser",
                                                      JOptionPane.INFORMATION_MESSAGE,
                                                      null, /* icon */
                                                      alphabet,
                                                      "k");
        System.out.printf("result = \"%s\"\n", result);
    }
}