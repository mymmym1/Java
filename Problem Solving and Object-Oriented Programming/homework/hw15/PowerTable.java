public class PowerTable {
    public void printPowerTable(int n, int k) {       
        synchronized (this) {
            for (int i = 1; i <= k; i++)            
                 System.out.print((int)(Math.pow(n, i)) + " ");        
            System.out.println();
        }
        
    }
}