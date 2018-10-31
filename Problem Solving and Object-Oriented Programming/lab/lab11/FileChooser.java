import java.io.File;
import javax.swing.JFileChooser;

public class FileChooser {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        
        fc.setDialogTitle("Choose Important File");
        int val = fc.showOpenDialog(null);
        System.out.println(val);
        
        File f = fc.getSelectedFile();
        System.out.println(f);
    }
}
