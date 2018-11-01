import java.util.*;

// Define class Teacher, subclass of AcademicPerson
public class Teacher extends AcademicPerson {
 // Instance variables
 private static final int MAX_COURSES = 10; // maximum courses

 // Constructor
 public Teacher(String name, String address) {
  super(name, address);
  courses = new String[MAX_COURSES];
 }

 
 // It adds a course into the list of courses.
 // This method throws ArrayElementException when the course that is being
 // added to the list already exists in it.
 public void addCourse(String course) throws ArrayElementException {
         if (Arrays.asList( courses ).contains( course ) ) throw new  ArrayElementException (" Already had this course!");
         else
              courses[courses.length] = course; 
    
 }

 // It removes a course into the list of courses.
 // This method throws ArrayElementException when the course does not exist
 // in the list.
 public void removeCourse(String course) throws ArrayElementException {
     try {
         if (Arrays.asList( courses ).contains( course ) )
             Arrays.asList( courses ).remove( course );
     }  
     catch ( ArrayElementException e ) { 
          System.out.println("No such course!");
     } 
 }

 // It prints all the courses in the list in each line
 @Override
 public void printCourses() {
       for (int i = 0; i < courses.length; i++) {
              System.out.print("Course: " + courses[i]);
       }

 }

 @Override
 public String toString() {
  return "Teacher: " + super.toString();
 }

}