import java.util.*;
public class SorterFirstGeneration {
    private Triangle[] small;
    private Triangle[] medium;
    private Triangle[] large;
    
    ArrayList<Triangle> moreTriangle = new ArrayList<Triangle>();     
 
    private int nSmall;
    private int nMedium;
    private int nLarge;
    
    int moreTriangleSize;
 
    public SorterFirstGeneration() {
        this.small = new Triangle[5];
        this.medium = new Triangle[5];
        this.large = new Triangle[5];
 
        this.moreTriangleSize = 0;
        
        this.nSmall = 0;
        this.nMedium = 0;
        this.nLarge = 0;
    }
 
    /**
     * Add the triangle in the good container and update the statistics.
     */
    public void sort(Triangle p) {  
        
        if (p.area() < 10.0 ) {
            if (nSmall >= 5){
                for (int i = 0 ; i < nSmall; i++) 
                    moreTriangle.add(small[i]); 
                moreTriangleSize++;
            }
            else {
                small[nSmall] = p; 
                nSmall++;
            }
        }
        else if (p.area() > 10.0 && p.area() < 50.0) {
            if (nMedium >= 5){
                for (int i = 0 ; i < nMedium; i++) 
                    moreTriangle.add(medium[i]); 
                moreTriangleSize++;
            }
            else {
                medium[nMedium] = p; 
                nMedium++;
            }
        }
        else if (p.area() > 50.0) {
            if (nLarge >= 5){
                for (int i = 0 ; i < nLarge; i++) 
                    moreTriangle.add(large[i]); 
                moreTriangleSize++;
            }
            else {
                large[nLarge] = p; 
                nLarge++;      
            }
        }
    }
/**
 * This function check the state of the three arrays. 
 * If one of them is full, it constructs a new array with one more
 * element and transfers all the Triangles.
 */    
//    public void checkAndExpand() {            
//        ArrayList<Triangle> moreTriangle = new ArrayList<Triangle>();        
//        if (nSmall > 5 || nMedium > 5 || nLarge > 5) {
//            for (int i = 0 ; i < nSmall; i++) 
//               moreTriangle.add(small[i]); 
//            for (int i = 0 ; i < nMedium; i++) 
//                 moreTriangle.add(medium[i]);
//            for (int i = 0 ; i < nLarge; i++) 
//                 moreTriangle.add(large[i]);              
//        }
//        moreTriangleSize = moreTriangle.size();
//    }
    
 
    public void printStatistics() {
        System.out.printf("There are currently %d triangles in stock:\n", this.nSmall + this.nMedium + this.nLarge);
        System.out.printf(" - %d small\n", this.nSmall);
        System.out.printf(" - %d medium\n", this.nMedium);
        System.out.printf(" - %d large\n\n", this.nLarge);
        System.out.printf(" - %d additional triangles\n\n", this.moreTriangleSize);   

    }
}

