/** 
 * CS180 - Lab 04 - Student
 * 
 * Overall Exam Points, attendance, and  participation   
 * 
 * @author (Yimin Miao) <(miao28@purdue.edu)>  
 * 
 * @lab (Lab section: L11) 
 * 
 * @version (02/06/2015) 
 */
public class Student {
    // instance variables
    String id;
    String dept;
    int abs;
    int exam;
    int part;
    // constructor
    public Student(String id, String dept, int abs, int exam, int part) {
        this.id = id;
        this.dept = dept;
        this.abs = abs;
        this.exam = exam;
        this.part = part;
    }
    //methods: describing the method, parameters (if any), and return value (if any)    
    public int getOverallScore(int exam, int part, int abs) {
        int totScore = 0;
        int attendanceScore = 0;
        if (abs == 0) 
            attendanceScore = 2;
        if (abs >= 1 && abs <= 4) 
            attendanceScore = 0;
        else if (abs >= 5)
            attendanceScore = 0;               
        totScore = exam + part + attendanceScore;
        return totScore;
    }
    public String getLetterGrade(int score) {
        String letterGrade = "";
        if (score > 95 && score <= 100)
            letterGrade = "A+";
        if (score > 90 && score <= 95)
            letterGrade = "A";
        if (score > 80 && score <= 90)
            letterGrade = "B";
        if (score > 70 && score <= 80)
            letterGrade = "C";
        if (score > 60 && score <= 70)
            letterGrade = "D";
        if (this.abs >= 5) // if more than 5 times abs, make it F
            letterGrade = "F";
        else if (score < 60)
            letterGrade = "F";
        return letterGrade;
    }
    public boolean hasPassedCourse(String letterGrade) {
        if (dept == "PH") {
            if (letterGrade == "A" || letterGrade == "B" || letterGrade == "A+")
                return true;
            else
                return false;
        }
        if (dept == "CS") {
            if (letterGrade == "A" || letterGrade == "B" || letterGrade == "C" || 
                letterGrade == "A+" || letterGrade == "D")
                return true;
            else
                return false;
        }
        return true; //boolean method needs a default return-either true or false as you like
    } 
    public static void main(String[] args) {
        Student s = new Student ("1020101", "PH", 4, 75, 5);
        int totScore = s.getOverallScore(75, 5, 4);
        String grade = s.getLetterGrade(totScore);
        boolean result = s.hasPassedCourse(grade);
        System.out.println(s.id);
        System.out.println("Score: " + totScore);
        System.out.println("Grade: " + grade);
        if (result == true)
            System.out.println("Student " + s.id + " has passed the course");
        else
            System.out.println("Student " + s.id + " has failed the course");
    }
}

        
            
            
                
