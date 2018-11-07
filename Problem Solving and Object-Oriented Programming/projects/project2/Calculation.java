public class Calculation{   
    
      public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false; 
        }
    }
      
    private static void stats(String[] args) {
        if (args.length == 1) {
            System.out.println("Error: Argument count mismatch");
            return;
        }
        int[] arr = new int[args.length - 1]; 
        for (int i = 1; i < args.length ; i++) { 
            if (isInteger(args[i])) 
                arr[i - 1] = Integer.parseInt(args[i]);
            else { 
                System.out.println("Error: Argument type mismatch");
                return;
            }
        }
        int tot = 0;
        int max = arr[0];
        int min = arr[0];
        int n = arr.length; 
        double avg = 0.0;      
        for (int i = 0; i < n; i++) {
            tot += arr[i];
            if (arr[i] > max) 
                max = arr[i];
            if (arr[i] < min) 
                min = arr[i];
        }        
        avg = (double) tot / n;      
        System.out.println("Total " + tot);
        System.out.println("Max " + max);
        System.out.println("Min " + min);  
        System.out.println("n "+ n);
        System.out.print("Average " );
        System.out.printf("%.2f\n", avg);
    }
    public static void main(String[] args){
        Calculation cal = new Calculation();
        String[] str = {"-stats", "10", "48", "20", "29"};
        String[] str1 = { "-stats", "35"};
        cal.stats(str);
        cal.stats(str1);
        
    }
}
