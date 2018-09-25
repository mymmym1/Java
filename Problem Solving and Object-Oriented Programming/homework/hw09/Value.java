public class Value {
    static int n = 0;
    static double sum = 0.0;
    double value;
    Value(double value) {  
        this.value = value;         
        n = n + 1;
        //System.out.println(n);
        sum += this.value;
        //System.out.println(sum);
    }     
    double getDiffWithAvg() { 
        double avg;        
        avg = sum / n; 
        return Math.abs(value - avg);
    }
    public static void main(String[] args) {
        Value v1 = new Value (10.0);
        System.out.printf("%.2f\n", v1.getDiffWithAvg());
        System.out.println(" ");
          
          
        Value v2 = new Value (0.0);
        System.out.printf("%.2f\n", v1.getDiffWithAvg());
        System.out.printf("%.2f\n", v2.getDiffWithAvg());
        System.out.println(" ");
           
        Value v3 = new Value (15.0);
        System.out.printf("%.2f\n", v1.getDiffWithAvg());
        System.out.printf("%.2f\n", v2.getDiffWithAvg());
        System.out.printf("%.2f\n", v3.getDiffWithAvg());
        System.out.println(" "); 
    }    
}
