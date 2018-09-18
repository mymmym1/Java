/**
 * hw02 -- Caculator
 * @Yimin Miao, miao28
 * @date Januray 19, 2015
*/
public class Calculator { 
    int add(int x, int y) { 
        return x + y; 
    } 
    
    int subtract(int x, int y) { 
        return x - y; 
    } 
    
    int multiply(int x, int y) {
        return x * y;
    }
    
    public static void main(String[] args) { 
        Calculator c = new Calculator();
        
        System.out.println(c.add(3, 5)); 
        System.out.println(c.subtract(3, 5));
        System.out.println(c.multiply(220, 284));
    }
}
 
