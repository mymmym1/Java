import java.util.*;
public class SorterThirdGeneration {
    SorterFirstGeneration sorterFirst = new SorterFirstGeneration();
//    sorterFirst.sort(Triangle p);
    /**
 * This function check the state of the three arrays. 
 * If one of them is full, it constructs a new array with one more
 * element and transfers all the Triangles.
 */
    public void checkAndExpand() {    
        ArrayList<Triangle> moreTriangle = new ArrayList<Triangle>(); 
        if (nSmall > 5 || nMedium > 5 || nLarge > 5) {
            for (int i = 0 ; i < nSmall; i++) System.out.println(i);
            moreTriangle.add(small[i]); 
            for (int i = 0 ; i < nMedium; i++) 
                moreTriangle.add(medium[i]);
            for (int i = 0 ; i < nLarge; i++) 
                moreTriangle.add(large[i]);              
        }
        moreTriangleSize = moreTriangle.size();
    }
}