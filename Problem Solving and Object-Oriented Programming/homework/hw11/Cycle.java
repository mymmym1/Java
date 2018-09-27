public class Cycle implements Vehicle {
    public boolean hasDoor() {      
        System.out.println("A cycle doesn't have a door!");
        return false;
    }
    public boolean hasTire() {
        System.out.println("A cycle has tires!");
        return true; 
    }
}
