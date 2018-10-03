public class TestPowerTalbe {
    public static void main(String[] args) {
        PowerTable pt = new PowerTable();
        MyThread t1 = new MyThread (pt, 2, 5);
        MyThread t2 = new MyThread (pt, 3, 5);
        t1.start();
        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}