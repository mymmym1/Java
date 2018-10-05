public class CoffeeHouse {
    private int coffeeNum;
    private boolean ready;
    
    public CoffeeHouse () {
        coffeeNum = 0;
        ready = false;
    }    
    public void prepare(int i) {        
        synchronized (this) {          
            while (ready) {  // while(boolean true) -> after while loop, boolean = true
                try {       
                    wait();  // "wait()" must inside try, and used together with "notifyAll()"          
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
            }
            ready = true;            
            notifyAll();             
        }        
    }    
    public int order() {
        synchronized (this) {          
            while (!ready) {  // while(boolean false) -> after while loop, boolean = false
                try {                    
                    wait();                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
            }
            ready = false;            
            notifyAll();                  
        }        
        coffeeNum++;
        return coffeeNum; 
    }    
    public static void main(String[] args) {
        CoffeeHouse coffeeHouse = new CoffeeHouse();         
        Barista barista = new Barista(coffeeHouse, 3); //remember
        Thread baristaThread = new Thread(barista);
        baristaThread.start();
        Customer customer = new Customer(coffeeHouse);
        Thread customerThread1 = new Thread(customer, "Joe");
        customerThread1.start();
        Thread customerThread2 = new Thread(customer,  "Nico");  
        customerThread2.start();
        Thread customerThread3 = new Thread(customer, "Jimmy");    
        customerThread3.start();
        Thread customerThread4 = new Thread(customer, "Cindy");    
        customerThread4.start();      
        
        
//        while (count < barista.MAX_COF) {
//            Thread customerThread = new Thread(customer);    
//            customerThread.start();
//            count++;
//        }
        
//         try {
//             for (int i = 0; i < customerThread.length; i++ ) 
//                 customerThread[i].join();
//             } catch (InterruptedException e){
//                 System.out.println("A thread didn't finish!");
//             }
        //Use Thread(Runnable target, String name) to create customer 
        //threads in your main method.Thread.currentThread().getName() can return this thread's name.       
        
        // System.out.println("Coffee is sold out!");          
    }         
}
