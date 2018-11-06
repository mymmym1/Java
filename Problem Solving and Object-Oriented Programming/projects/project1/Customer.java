import java.util.Scanner;
public class Customer { 
    public int compare(Camera camOne, Camera camTwo) {       
        int valueOne = camOne.computeValue();
        int valueTwo = camTwo.computeValue();
        if (valueOne == valueTwo && Math.abs(camOne.price - camTwo.price) < 0.01 
            && camOne.userRating == camTwo.userRating) 
            return 0; 
        
        if (valueOne == valueTwo && Math.abs(camOne.price - camTwo.price) < 0.01) 
            return ( camOne.userRating > camTwo.userRating ? 1 : 2);
        if (Math.abs(camOne.price - camTwo.price) < 0.01 && camOne.userRating 
            == camTwo.userRating ) 
            return ( valueOne > valueTwo ? 1 : 2); 
         
        if (valueOne == valueTwo && camOne.userRating == camTwo.userRating ) 
            return  ( camOne.price < camTwo.price  ? 1 : 2); 
       
        //if ((camOne.price / valueOne ) == (camTwo.price / valueTwo) ) 
        if (Math.abs((camOne.price / valueOne) - (camTwo.price / valueTwo)) < 0.01)
            return 0;
        else 
            return  ((camOne.price / valueOne ) < (camTwo.price / valueTwo) ?  1 : 2);
        
    
   
   // if ((valueOne / camOne.userRating) == (valueTwo / camTwo.userRating))
   //     return 0;
   // else
   //     return ((valueOne / camOne.userRating) > (valueTwo / camTwo.userRating)? 1 : 2);
   // if ( (camOne.price / camOne.userRating ) == (camTwo.price / camOne.userRating) ) 
   //     return 0;
   // else
   //     return ( (camOne.price / camOne.userRating ) < (camTwo.price / camOne.userRating)? 1 : 2); 
    }
    public static void main ( String args[] ) {       
        System.out.println("Enter attributes of Camera 1:" );        

        Scanner in = new Scanner(System.in);
        System.out.println("Is WiFi enabled? (true/false)" );
        boolean wiFi1 = in.nextBoolean();
         
        System.out.println("Is water resistant? (true/false)" );
        boolean waterResistant1 = in.nextBoolean();

        System.out.println("Is GPS enabled? (true/false)" );
        boolean hasGPS1 = in.nextBoolean();

        System.out.println("Condition? (New/Refurbished/Used)" );
        String condition1 = in.next();
          
        System.out.println("Enter price in $ (0.00 to 1000.00)" );
        double price1 = in.nextDouble();

        System.out.println("Enter user rating (0 to 5)" );
        int userRating1 = in.nextInt();
         
        Camera camOne = new Camera(wiFi1, waterResistant1, hasGPS1, condition1, price1, userRating1);
     
        System.out.println("============================================" );  

        System.out.println("Enter attributes of Camera 2:" );        

         
        System.out.println("Is WiFi enabled? (true/false)" );
        boolean wiFi2 = in.nextBoolean();
         
        System.out.println("Is water resistant? (true/false)" );
        boolean waterResistant2 = in.nextBoolean();

        System.out.println("Is GPS enabled? (true/false)" );
        boolean hasGPS2 = in.nextBoolean();

        System.out.println("Condition? (New/Refurbished/Used)" );
        String condition2 = in.next();
          
        System.out.println("Enter price in $ (0.00 to 1000.00)" );
        double price2 = in.nextDouble();

        System.out.println("Enter user rating (0 to 5)" );
        int userRating2 = in.nextInt();
     
        Camera camTwo = new Camera(wiFi2, waterResistant2, hasGPS2, condition2, price2, userRating2);

        System.out.println("============================================" ); 

        Customer guy = new Customer();
       
        int res = guy.compare(camOne, camTwo);

        System.out.println("Result of Comparison:" ); 

        if (res == 0 )
            System.out.println("Cannot tell which one is better"); 
        else if (res == 1) 
            System.out.println("Camera 1 is better than Camera 2!"); 
        else if (res == 2)  
            System.out.println("Camera 2 is better than Camera 1!"); 
    }
}
