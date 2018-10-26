public class Parallelogram {
    Polygon t = new Triangle(10, 15, 20);
    Polygon p = new Parallelogram(10, 20, 20.0);
    //................
    if (t instanceof Triangle) {
        System.out.println("t is a Triangle");
    } else {
        System.out.println("t is not a Triangle");
    }
    
    if (p instanceof Triangle) {
        System.out.println("p is a Triangle");
    } else {
        System.out.println("p is not a Triangle");
    }
}