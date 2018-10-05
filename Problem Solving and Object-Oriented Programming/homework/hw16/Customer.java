public class Customer implements Runnable {
    private CoffeeHouse coffeeHouse;
    public Customer(CoffeeHouse coffeeHouse) {
        this.coffeeHouse = coffeeHouse;
    }    
    public void run() {
        int i = 0;
        while (i < Barista.max) {  //while not sold out, keep order
            int coffeeNum = coffeeHouse.order();                           
            System.out.printf("%s RECEIVES: %d" + "\n", Thread.currentThread().getName(), coffeeNum);  
            // remember Thread.currentThread().*
            try {
                Thread.sleep(1000); //Thread.sleep must inside try
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }     
    
    //     public String getName() { 
//        String names[] = {"Mary", "John", "Jimmy", "Sam", "Nico", "Cindy", "Linda"};
//        Random r = new Random();       
//        int i = r.nextInt(names.length);        
//        String customerName = names[i];
//        return customerName;
//    }
}