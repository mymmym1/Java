/**
 * CS180 - HW07
 * Write a class Array with a constructor and two methods
 * @author Yimin Miao, <miao28@purdue.edu>
 */
public class Array {    
    double[] array;       
    Array(double[] arr) {  //constructor initialize the array above
        this.array = arr;
    }    
    double sum() {  //method sum         
        if (array == null ) {  
            System.out.println("Array is null, cannot find the sum!"); 
            return 0.0; //every method needs a return (if not void)
        }
        else {  
            int n = array.length;
            double sum = 0.0;
            for (int i = 0; i < n; i++)      
                sum += array[i];
            return sum; 
        }               
    }    
    double average() {   //method average        
        if (array == null ) {  
            System.out.println("Array is null, cannot find the average!"); 
            return 0.0;
        }
        else {
            double average;
            //Here it is OK not to write = 0.0 because the next line calculate (initialize) it
            average = this.sum() / array.length; //use "this" to get rid of the compile error. Which "sum"? "this" sum.
            return average; 
        }           
    }
}
        
