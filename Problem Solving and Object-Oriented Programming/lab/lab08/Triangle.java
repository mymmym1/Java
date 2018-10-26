public class Triangle {
    double l1;
    double l2;
    double l3;
    double angle;    
/* Constructor with 3 sides */
    public Triangle(int l1, int l2, int l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    } 
/* Constructor with 2 sides and the included angle */
    public Triangle(int l1, int l2, double angle) {
        this.l1 = l1;
        this.l2 = l2;        
        this.angle = angle;
    }     
/* compute the perimeter */
    public double perimeter() {
        return (l1 + l2 + l3);
    } 
/* compute the area */
    public double area() {
       double h;
       double rad = Math.toRadians(angle);  // angle must be in radians !!!
       h = l2 * Math.sin(rad);
       return l1 * h * 0.5;
    }
    public static double area(double l1, double l2, double angle){
        
        double rad = Math.toRadians(angle);  // angle must be in radians !!!
        return l1 * l2 * Math.sin(rad) * 0.5;
    }
 // Auxiliary functions given

 /**
  * This functions computes the included angles of a triangle
  *
  * @param adj1 one of the adjacent side
  * @param adj2 the other adjacent side
  * @param opp the opposite side
  */
    public static double angleFromSides(double adj1, double adj2, double opp) {
        double pythagoras = opp * opp - adj1 * adj1 - adj2 * adj2;
        return Math.acos(-pythagoras/(2*adj1*adj2));
    }

 /**
  * This functions computes the length of the opposite side
  *
  * @param angle the included angle
  * @param adj1 one of the adjacent side
  * @param adj2 the other adjacent side
  */
    public static double oppSide(double angle, double adj1, double adj2) {
        return Math.sqrt(adj1 * adj1 - 2 * adj1 * adj2 * Math.cos(angle) + adj2 * adj2);
    }
    
}
