public class Barista implements Runnable {
    private CoffeeHouse coffeeHouse;
    public static int max;
    public int coffeeNum;
    public Barista (CoffeeHouse coffeeHouse, int max) {
        this.coffeeHouse = coffeeHouse;
        this.max = max;         
    }
    public void run() {
        for (int i = 1; i <= max; i++) {  //while not sold out, keep prepare
            coffeeHouse.prepare(i);           
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
