public class Boat implements Vehicle {
    public boolean hasDoor() {      
        System.out.println("A boat doesn't have to have a door!");
        return false;
    }
    public boolean hasTire() {
        System.out.println("A boat doesn't have tires!");
        return false; 
    }
}
