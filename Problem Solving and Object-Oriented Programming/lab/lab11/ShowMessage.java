import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
 
public class ShowMessage {
    public static void main(String[] args) {
        
        // showMessageDialog with minimal message argument...
        JOptionPane.showMessageDialog(null, "Simple Message");
 
        // showMessageDialog with window title and message type...
        JOptionPane.showMessageDialog(null, 
                                      "Another Message",
                                      "Window Title",
                                      JOptionPane.WARNING_MESSAGE);
 
        // showMessageDialog (and others) allow embedded HTML in message string...
        JOptionPane.showMessageDialog(null,
                                      "<html>Here is a more <i>complex message</i><br>" +
                                      "with <b>lots more text</b>.");
 
        // showMessageDialog with supplied icon image...
        ImageIcon ii = new ImageIcon("images.jpeg");
        JOptionPane.showMessageDialog(null,
                                      "Woof!",
                                      "Dog Picture",
                                      JOptionPane.PLAIN_MESSAGE,
                                      ii);
    }
}