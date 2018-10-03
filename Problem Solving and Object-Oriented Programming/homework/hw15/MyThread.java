public class MyThread extends Thread {
    PowerTable pt;
    int base;
    int powers;
    public MyThread (PowerTable pt, int base, int powers) {
        this.pt = pt;
        this.base = base;
        this.powers = powers;
    }
    public void run() {
        pt.printPowerTable(base, powers);
    }
}
