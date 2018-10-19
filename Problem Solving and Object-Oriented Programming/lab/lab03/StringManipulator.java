import java.util.Scanner;
/**
 * CS180 - Lab 03 - StringManipulator
 * 
 * This method inputs user name and domain name returns email adress.
 * 
 * @author (Yimin Miao) <(miao28@purdue.edu)>
 * 
 * @lab (Lab section: L11)
 *
 * @date (01/30/2015)
 */
public class StringManipulator {
    public String makeUserName(String fullName) { 
        String str = fullName;
        String substr1 = str.substring(0, 1); //notice here not include the 1st char
        int i = str.indexOf(' ');
        String substr2 = str.substring(i + 1, str.length());
        String simplifier = substr1.concat(substr2);
    //      System.out.println(simplifier);
        String userName = simplifier.toLowerCase();
        return userName;
    }    
    public String makeEmail(String username, String domain) {
        String label = "@";
    //      String universityName = "Purdue.EDU"; Should not make it static
        String domainName = label.concat(domain);
        String lowCaseDomain = domainName.toLowerCase();    
        String emailAdress = username.concat(lowCaseDomain);
        return emailAdress;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Full Name of the person. First Name followed by Last Name.");
        String fullName = s.nextLine();
        System.out.println("Enter the domain");
        String domain = s.nextLine();
        createEmailAdress(fullName, domain); 
        s.close();
    }
    public static void createEmailAdress(String fullName, String domain) {
        StringManipulator m = new StringManipulator(); //call the class
        System.out.print("The user name for the person is:" + m.makeUserName(fullName)
                                                          //call the method under the class 
                        + "\nThe email id for the person is:"
                           + m.makeEmail(m.makeUserName(fullName), domain)); 
    }
}
 
