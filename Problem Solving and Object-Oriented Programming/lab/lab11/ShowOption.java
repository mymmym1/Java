import javax.swing.JOptionPane;
 
public class ShowOption {
    public static void main(String[] args) {
        int result;
        
        // showOptionDialog...
        String[] selections = { "Red", "Blue", "Green", "Cyan", "Magenta", "Gold" };
        result = JOptionPane.showOptionDialog(null, 
                                              "Choose a color:", 
                                              "Color Chooser",
                                              JOptionPane.DEFAULT_OPTION,
                                              JOptionPane.PLAIN_MESSAGE,
                                              null, /* icon */
                                              selections,
                                              selections[2]);
        if (result == -1)
            System.out.printf("user closed window\n");
        else
            System.out.printf("result = \"%s\" (%d)\n", selections[result], result);
    
        // showOptionDialog with more options...
        String[] xselections = { "Red", "Blue", "Green", "Cyan", "Magenta", "Gold",
        "Dog", "Cat", "Horse", "Mouse", "Lion", "Bird", "Chicken", "Henway" };
        result = JOptionPane.showOptionDialog(null, 
                                              "Choose a color:", 
                                              "Color Chooser",
                                              JOptionPane.DEFAULT_OPTION,
                                              JOptionPane.PLAIN_MESSAGE,
                                              null, /* icon */
                                              xselections,
                                              xselections[2]);
        if (result == -1)
            System.out.printf("user closed window\n");
        else
            System.out.printf("result = \"%s\" (%d)\n", selections[result], result);
    }
}