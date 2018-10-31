import javax.swing.JOptionPane;  
/** 
 * CS 180 - Lab 08 - CollegeFeeCalculator 
 *  
 * (Brief description of the class file) 
 *  
 * @author (Yimin Miao) <(miao28@purdue.edu)> 
 *  
 * @lab (L11) 
 * 
 * @date (Today's date) 
 */ 
public class CollegeFeeCalculator { 
    public static void main(String[] args) { 
        int result10 = 0; 
        do {JOptionPane.showMessageDialog (null, "Welcome to CollegeFeeCalculator!", 
                                       "CollegeFeeCalculator", JOptionPane.INFORMATION_MESSAGE); 
         
        String[] messages = { "Name", "Enrollment", "Credit Hours", "Invalid no. of credits", 
            "Residency", "Housing", "Residence-Hall", "CollegeFeeCalculator", "Are you done?"}; 
         
        String result1 = ""; 
        result1 = JOptionPane.showInputDialog(null,  
                                              "Please enter your name, then press OK", 
                                              messages[0], 
                                              JOptionPane.QUESTION_MESSAGE);                          
         
        int result2 = 0; 
        String result3 = ""; 
        int creditHour = 0;
                    
        do{   String[] selections2 = { "Full-Time", "Part-Time"}; 
            result2 = JOptionPane.showOptionDialog(null,  
                                               "Please select your enrollment",  
                                               "Enrollment", 
                                               JOptionPane.DEFAULT_OPTION, 
                                               JOptionPane.QUESTION_MESSAGE, 
                                               null, /* icon */ 
                                               selections2, 
                                               selections2[1]);  
    
        
         
                result3 = JOptionPane.showInputDialog(null, 
                                              "Please enter the no. of credit hours, then press OK", 
                                              messages[2], 
                                                      JOptionPane.QUESTION_MESSAGE);
        creditHour = Integer.parseInt(result3);
        
        if ((result2 == 1 && creditHour >= 8) || (result2 == 0 && creditHour < 8)){
            JOptionPane.showMessageDialog (null, "Please enter valid credit hours for the current enrollment",
                                               "Invalid no. of credits",
                                               JOptionPane.ERROR_MESSAGE); 
        }
        else 
        
            break;}
        
                
        while ((result2 == 1 && creditHour >= 8) || (result2 == 0 && creditHour < 8));
        
        
                
       
            

         
//        String result4 = ""; 
//        result4 = JOptionPane.showInputDialog(null, 
//                                              "Please enter valid credit hours for the current enrollment", 
//                                              messages[3], 
//                                              JOptionPane.ERROR_MESSAGE); 
        int result5 = 0; 
        String[] selections5 = { "In-state", "Out-of-state", "International"}; 
        result5 = JOptionPane.showOptionDialog(null,  
                                               "Please select the appropriate residency",  
                                               "Residency", 
                                               JOptionPane.DEFAULT_OPTION, 
                                               JOptionPane.QUESTION_MESSAGE, 
                                               null, /* icon */ 
                                               selections5, 
                                               selections5[1]); 
        int result6 = 0; 
        String[] selections6 = { "ON-Campus", "OFF-Campus"}; 
        result6 = JOptionPane.showOptionDialog(null,  
                                               "Please select your housing",  
                                               "Housing", 
                                               JOptionPane.DEFAULT_OPTION, 
                                               JOptionPane.QUESTION_MESSAGE, 
                                               null, /* icon */ 
                                               selections6, 
                                               selections6[1]); 
        int result7 = 0; 
        if (result6 ==0) {             
            String[] selections7 = { "Earhart", "Hillenbrand", "Owen", "Windsor"}; 
            result7 = JOptionPane.showOptionDialog(null,  
                                                   "Please select the residence hall",  
                                                   "Residence-Hall", 
                                                   JOptionPane.DEFAULT_OPTION, 
                                                   JOptionPane.QUESTION_MESSAGE, 
                                                   null, /* icon */ 
                                                   selections7, 
                                                   selections6[1]); 
        } 
        int creditHours = Integer.parseInt(result3); 
        String message = ""; 
        if (result2 == 0) {            
            if (result6 == 1) { 
                if (result5 == 0) 
                    message = " Name: " + result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: In-state\n Tuition fee: $4996\n Housing Expense: $0\n Total Sem.Fee: $4996"; 
                if (result5 == 1) 
                    message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: Out-of-state\n Tuition fee: $" + (9401 + 4996) + "\n Housing Expense: $0\n Total Sem.Fee: $" + (9401 + 4996); 
                if (result5 == 2) 
                    message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: International\n Tuition fee: $" + (1000 + 9401 + 4996) + "\n Housing Expense: $0\n Total Sem.Fee: $" + (1000 + 9401 + 4996); 
            } 
            if (result6 == 0) { 
                if (result7 == 0) { 
                    if (result5 == 0) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: In-state\n Tuition fee: $4996\n Housing Expense: $4745\n Total Sem.Fee: $" + (4996 + 4745); 
                    if (result5 == 1) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: Out-of-state\n Tuition fee: $" + (9401 + 4996) + "\n Housing Expense: $4745\n Total Sem.Fee: $" + (9401 + 4996 + 4745); 
                    if (result5 == 2) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: International\n Tuition fee: $" + (1000 + 9401 + 4996) + "\n Housing Expense: $4745\n Total Sem.Fee: $" + (1000 + 9401 + 4996 + 4745); 
                } 
                if (result7 == 1) { 
                    if (result5 == 0) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: In-state\n Tuition fee: $4996\n Housing Expense: $5307\n Total Sem.Fee: $" + (4996 + 5307); 
                    if (result5 == 1) 
                        message = "Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: Out-of-state\n Tuition fee: $" + (9401 + 4996) + "\n Housing Expense: $5307\n Total Sem.Fee: $" + (9401 + 4996 + 5307); 
                    if (result5 == 2) 
                        message = "Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: International\n Tuition fee: $" + (1000 + 9401 + 4996) + "\n Housing Expense: $5307\n Total Sem.Fee: $" + (1000 + 9401 + 4996 + 5307); 
                } 
                if (result7 == 2) { 
                    if (result5 == 0) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: In-state\n Tuition fee: $4996\n Housing Expense: $4130\n Total Sem.Fee: $" + (4996 + 4130); 
                    if (result5 == 1) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: Out-of-state\n Tuition fee: $" + (9401 + 4996) + "\n Housing Expense: $4130\n Total Sem.Fee: $" + (9401 + 4996 + 4130); 
                    if (result5 == 2) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: International\n Tuition fee: $" + (1000 + 9401 + 4996) + "\n Housing Expense: $4130\n Total Sem.Fee: $" + (1000 + 9401 + 4996 + 4130); 
                } 
                if (result7 == 3) { 
                    if (result5 == 0) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: In-state\n Tuition fee: $4996\n Housing Expense: $4150\n Total Sem.Fee: $" + (4996 + 4150); 
                    if (result5 == 1) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: Out-of-state\n Tuition fee: $" + (9401 + 4996) + "\n Housing Expense: $4150\n Total Sem.Fee: $" + (9401 + 4996 + 4150); 
                    if (result5 == 2) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: FULL TIME\n Residency: International\n Tuition fee: $" + (1000 + 9401 + 4996) + "\n Housing Expense: $4150\n Total Sem.Fee: $" + (1000 + 9401 + 4996 + 4150); 
                } 
            } 
        } 
        if (result2 == 1) {            
            if (result6 == 1) { 
                if (result5 == 0) 
                    message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: In-state\n Tuition fee: $" + 350 * creditHours + "\n Housing Expense: $0\n Total Sem.Fee: $" + 350 * creditHours; 
                if (result5 == 1) 
                    message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: Out-of-state\n Tuition fee: $" + (600 + 350) * creditHours + "\n Housing Expense: $0\n Total Sem.Fee: $" + (600 + 350) * creditHours; 
                if (result5 == 2) 
                    message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: International\n Tuition fee: $" + (70 + 600 + 350) * creditHours + "\n Housing Expense: $0\n Total Sem.Fee: $" + (70 + 600 + 350) * creditHours;                 
            } 
            if (result6 == 0) { 
                if (result7 == 0) { 
                    if (result5 == 0) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: In-state\n Tuition fee: $" + 350 * creditHours + "\n Housing Expense: $4745\n Total Sem.Fee: $" + (350 * creditHours + 4745); 
                    if (result5 == 1) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: Out-of-state\n Tuition fee: $" + (600 + 350) * creditHours + "\n Housing Expense: $4745\n Total Sem.Fee: $" + ((600 + 350) * creditHours + 4745); 
                    if (result5 == 2) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: International\n Tuition fee: $" + (70 + 600 + 350) * creditHours + "\n Housing Expense: $4745\n Total Sem.Fee: $" + ((70 + 600 + 350) * creditHours + 4745);                 
                } 
                if (result7 == 1) { 
                    if (result5 == 0) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: In-state\n Tuition fee: $" + 350 * creditHours + "\n Housing Expense: $5370\n Total Sem.Fee: $" + (350 * creditHours + 5307); 
                    if (result5 == 1) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: Out-of-state\n Tuition fee: $" + (600 + 350) * creditHours + "\n Housing Expense: $5370\n Total Sem.Fee: $" + ((600 + 350) * creditHours + 5307); 
                    if (result5 == 2) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: International\n Tuition fee: $" + (70 + 600 + 350) * creditHours + "\n Housing Expense: $5370\n Total Sem.Fee: $" + ((70 + 600 + 350) * creditHours + 5307);                 
                } 
                if (result7 == 2) { 
                    if (result5 == 0) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: In-state\n Tuition fee: $" + 350 * creditHours + "\n Housing Expense: $4130\n Total Sem.Fee: $" + (350 * creditHours + 4130); 
                    if (result5 == 1) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: Out-of-state\n Tuition fee: $" + (600 + 350) * creditHours + "\n Housing Expense: $4130\n Total Sem.Fee: $" + ((600 + 350) * creditHours + 4130); 
                    if (result5 == 2) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: International\n Tuition fee: $" + (70 + 600 + 350) * creditHours + "\n Housing Expense: $4130\n Total Sem.Fee: $" + ((70 + 600 + 350) * creditHours + 4130);                 
                } 
                if (result7 == 3) { 
                    if (result5 == 0) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: In-state\n Tuition fee: $" + 350 * creditHours + "\n Housing Expense: $4150\n Total Sem.Fee: $" + (350 * creditHours + 4150); 
                    if (result5 == 1) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: Out-of-state\n Tuition fee: $" + (600 + 350) * creditHours + "\n Housing Expense: $4150\n Total Sem.Fee: $" + ((600 + 350) * creditHours + 4150); 
                    if (result5 == 2) 
                        message = " Name: " +  result1 + "\n Credit Hours: " + creditHour + "\n Enrollment: Part Time\n Residency: International\n Tuition fee: $" + (70 + 600 + 350) * creditHours + "\n Housing Expense: $4150\n Total Sem.Fee: $" + ((70 + 600 + 350) * creditHours + 4150);                 
                }                
            } 
        }         
        JOptionPane.showMessageDialog(null, 
                                      message, 
                                      "CollegeFeeCalculator", 
                                      JOptionPane.INFORMATION_MESSAGE); 
         
         
        String[] selections10 = { "YES", "NO"}; 
        result10 = JOptionPane.showConfirmDialog(null,  
                                               "Would you like to perform another fee calculation?",  
                                               "Are you done?", 
                                               JOptionPane.YES_NO_OPTION);      
        } while (result10 == 0);} 
    } 
 
