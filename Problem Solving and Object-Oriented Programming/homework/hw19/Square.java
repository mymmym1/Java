

public class Square extends Rectangle {
 double side;
 public Square(double side) throws IllegalArgumentException {
  super(side, side);
  if (side <= 0) throw new IllegalArgumentException ("can't be negative");
  else 
   this.side = side;
    }
 @Override
 public Type getType() {
  Type type = Type.SQUARE;  
  return type;
    }
// public double getPerimeter() {  
//  return super.getPerimeter();
// }
// 
// public double getArea() {  
//  return super.getArea();
// }
 public static void main(String[] args) {
     Square s = new Square(1.1);
     System.out.print (s.getPerimeter());         
 }
}