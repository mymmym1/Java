

public class Rectangle implements Shape2D {
 double side1;
 double side2;
 public Rectangle (double side1, double side2) throws IllegalArgumentException {
  if (side1 <= 0 || side2 <= 0) throw new IllegalArgumentException ("can't be negative");
  else {
   this.side1 = side1;
   this.side2 = side2;
  }
 }

 @Override
 public Type getType() {
  Type type = Type.RECTANGLE;  
  return type;
 }

 @Override
 public double getPerimeter() {  
  return 2 * (side1 + side2);
 }

 @Override
 public double getArea() {  
  return side1 * side2;
 }
}
