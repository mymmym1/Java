
public class Circle implements Shape2D {
 double radius;
 public Circle (double radius) throws IllegalArgumentException {
  if (radius <= 0) throw new IllegalArgumentException ("can't be negative");
  else
   this.radius = radius;
 }
 
 public double getPerimeter() {
  return 2 * Math.PI * radius;
 }  
 
 public double getArea() {
  return Math.PI * radius * radius;
 }
 
 @Override
 public Type getType() {
  Type type = Type.CIRCLE;  
  return type;
 } 
 public static void main(String[] args) {
     Circle c = new Circle (0);
     System.out.print(c.getArea());
 }
}
