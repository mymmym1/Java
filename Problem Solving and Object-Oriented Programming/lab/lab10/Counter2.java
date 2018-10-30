import java.util.concurrent.atomic.*; //can't write into "java.util.*"

public class Counter2 implements Counter { 
    AtomicInteger a = new AtomicInteger(0);
 
    public void inc() {
        a.incrementAndGet(); //use the method inside the AtomicInteger class
    }
 
    public void dec() {
        a.decrementAndGet();
    }
 
    public int get() {
        return a.get();
    }
}