public class Matrix {
    double[][] mat;    
    Matrix (double[][] matrix) {
        this.mat = matrix;
    }
    double average () {
        if (mat == null) { 
            System.out.println("Matrix is null, cannnot find the average!");
            return 0;
        }
        if (mat.length == 0) {
            System.out.println("Empty matrix, cannnot find the average!");
            return 0;
        }
        else {
            double sum = 0.0;
            double average = 0.0;
            int num = 0;    
           
            for (int i = 0; i < mat.length; i++) { 
                for (int j = 0; j < mat[i].length; j++) {
                    sum += mat[i][j]; 
                    num++;
                }
            }     
            average = sum / num; 
        return average;
        }                 
    }
// public static void main (String[] args)  
 //{
  // your code goes here
 //}
}
