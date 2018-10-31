import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
 
public class JOptionPaneMessages {
    public static void main(String[] args) {
        String[] messages = { "PLAIN_MESSAGE", "ERROR_MESSAGE", "INFORMATION_MESSAGE", 
            "WARNING_MESSAGE", "QUESTION_MESSAGE" };
        
        int[] mValues = { JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE,
            JOptionPane.INFORMATION_MESSAGE, JOptionPane.WARNING_MESSAGE,
            JOptionPane.QUESTION_MESSAGE };
        
        for (int i = 0; i < messages.length; i++) {
            String m = String.format("Message type: %s (%d)", messages[i], mValues[i]);
            System.out.println(m);
            JOptionPane.showMessageDialog(null, m, messages[i], mValues[i]);
        }
    }
}