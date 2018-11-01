import java.util.*;

public class Student extends AcademicPerson {

 // Instance variables
 private int[] grades; // grade for the corresponding course
 private static final int MAX_COURSES = 30; // maximum number of courses

 // Constructor
 public Student(String name, String address) {
  super(name, address);
  courses = new String[MAX_COURSES];
  grades = new int[MAX_COURSES];
 }

 // It adds a course and corresponding grade to the lists.
 // Student can take the same course couple of times. If a course that
 // already exists in the list is given as the input of the method you need
 // to compare the input grade with the one that is saved in the Grades list,
 // the higher grade needs to be saved in the Grades list.
 public void addCourseGrade(String course, int grade) {
        int ind = 0;
        if (Arrays.asList( courses ).contains( course ) ) {
             ind = Arrays.asList(courses).indexOf( course);
             if (grade > grades[ind]) grades[ind] = grade;
        }
        else {
            ind = courses.length;
            courses[ind] = course;
            grades[ind] = grade;
        }
              
        
 }

 // This method prints the student's average grade for all the courses.
 // This method throws IllegalDivisionByZero exception, when there is no
 // courses in the list.
 public void getAverageGrade() throws IllegalDivisionByZero {
     try{
         double sum = 0.0;
         double avg = 0.0;
         for (int i = 0; i < grades.length; i++) {
              sum += grades[i];  
         }
         avg = sum/grades.length;
         System.out.println("Average grade of alll courses: " + avg );
     }
     catch ( IllegalDivisionByZero e){ 
         System.out.println("Divided by 0, throw an exception");
     }
 }

 // It prints all the courses with the corresponding grades in each line.
 @Override
 public void printCourses() {
     for (int i = 0; i < courses.length; i++) {
              System.out.print("Course: " + courses[i]);
              System.out.println("     Grade: " + grades[i]);
         }

 }

 public int[] getGrades() {
  return grades;
 }

 public void setGrades(int[] grades) {
  this.grades = grades;
 }

 @Override
 public String toString() {
  return "Student: " + super.toString();
 }
}