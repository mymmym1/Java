import java.util.HashMap;

public class TeachingAssistantStudent extends Student {

 private int hours; // total hours of TA
 protected HashMap<String, Integer> courseHour = new HashMap<String, Integer>();

 public TeachingAssistantStudent(String name, String address) {
  super(name, address);
  this.hours = 0;
 }

 // It adds a course into the HashMap with the key of course and hours as the
 // value.
 // This method throws ArrayElementException when the course that is being
 // added to the HashMap already exists in it.
 public void addCourseHour(String course, int hours)  throws ArrayElementException {
     try {
         if (!Arrays.asList( courses ).contains( course ) )
             courseHour.put(course, hours);
     }
     catch ( ArrayElementException e) {
         System.out.println("Course already in the HashMap");
     }

 }

 // This method first should print the courses along with the grades that the
 // TA is taking as a student and then print out the courses with the
 // corresponding hours which the TA is assisting in each line.
 // Use Iterator to iterate the HashMap.
 @Override
 public void printCourses() {
    System.out.println("The student takes the following courses:");
    for (int i = 0; i < courses.length; i++) {
              System.out.print("Course: " + courses[i]);
              System.out.println("     Grade: " + grades[i]);
         }
    System.out.println("As a TA, he is teaching: ");
    
    Iterator iterator = courseHour.keySet().iterator();
  
    while (iterator.hasNext()) {
          String key = iterator.next().toString();
          String value = map.get(key).toString();
  
          System.out.println(key + " " + value);
    }
 }

 public int getHours() {
  return hours;
 }

 public void setHours(int hours) {
  this.hours = hours;
 }

 @Override
 public String toString() {
  return super.toString() + " Also serving as Teaching Assistant.";
 }

}