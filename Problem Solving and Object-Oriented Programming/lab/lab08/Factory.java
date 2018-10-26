public class Factory {
 
    public static void main(String[] args) {
 
        SorterFirstGeneration sort = new SorterFirstGeneration();
        PiecesFactory fact = new PiecesFactory();
 
        String[] triangleSpecs = fact.getNext(); //called generatePieces()
 
        while (triangleSpecs != null) {
            /* Construct the triangle */
       // System.out.println(triangleSpecs[0]);
            int l1 = Integer.parseInt (triangleSpecs[1]);
            int l2 = Integer.parseInt (triangleSpecs[2]);     
            double last = Double.parseDouble (triangleSpecs[3]);
           
       //     int l3 = 0;                                          // Ask TA about this !!!
       //     double angle = 0.0;            
       //     if (triangleSpecs[0].equals("S"))  {
       //         l3 = Integer.parseInt (triangleSpecs[3]); 
       //         Triangle p = new Triangle(l1, l2, l3);
       //     }
       //     else if (triangleSpecs[0].equals("A")) {
       //         angle = Double.parseDouble (triangleSpecs[3]);
       //         Triangle p = new Triangle (l1, l2, angle);
       //     }
            Triangle p = new Triangle (l1, l2, last);
            /* Sort the triangle */
            sort.sort(p);          
 
            /* get the next specifications */
            triangleSpecs = fact.getNext();            
        }       
        sort.printStatistics();   
    }
}

///////////////////////////////        Ask TA about SorterSecondGeneration or SorterThirdGeneration !!!
