public class Book {
//Fields
    int number;
    String name;
    String category;
    boolean availability;
//constructor
    public Book(int num, String name, String cat ) {
        this.number = num;
        this.name = name;
        this.category = cat;
        this.availability = true;
    }


//Methods
    public boolean equals(Book newBook, int byAttributes) {       
    //comparison method: if two book objects are equal, i.e. their names or their numbers are equal
        if (byAttributes == 0) { //search by index
            if (newBook.number == this.number) 
                return true;
//            else 
//                return false;
        }
        else if (byAttributes == 1) { //search by name
            if (newBook.name.equals(this.name)) 
                return true;
//            else
//                return false;
        }    
        return false;
    }
}
    //mutator
    //accessor
    
