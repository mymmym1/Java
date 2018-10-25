public class Shelf {
    private String shelfType;
    private Book[] books;
    public Shelf (String newType, Book[] newBooks) {
        this.shelfType = newType;
        this.books = newBooks;
    }
    public void addBooks(Book newBook) {
        Book[] replaceBooks = new Book[books.length + 1];
        for (int i = 0; i < replaceBooks.length; i++) {
            if (i == replaceBooks.length -1) {
                replaceBooks[i] = newBook;
                
            }
            else {
                replaceBooks[i] = books[i];
            }
        }
        books = replaceBooks;
    }
    public String getShelfType() { 
        return shelfType;
    }
    public boolean lendBook (Book newBook, int byAttributes) { //called from Library when is borrowed             
        int index = searchBook(newBook, byAttributes); //calls serchBook(), 
        if (index == -1) //return index, if index = -1 return false(not exist)
            return false;
        else {  //else true false means borrowed
            for (int i = 0; i < books.length; i++) {
                if (books[i].number == index) {
                    books[i].availability = false;
                    
                } //byAttributes = 0 to search for a book by number
            } // byAttributes = 1 to search for a book by name
        }       
        return true;
    }
    public boolean returnBook (Book newBook, int byAttributes) { //called from Library when want return
        int index = searchBook(newBook, byAttributes); //calls searchBook()
        for (int i = 0; i < books.length; i++) {
            if (books[i].number == index) {
                books[i].availability = true;
                return true; //return index; true availability,
            } // byAttributes = 0 to return a book by number
        } // byAttributes = 1 to return a book by name
        return false;        
    }
    public boolean getBookDetails(Book newBook, int byAttributes) {
        int index = searchBook(newBook, byAttributes); //calls serchBook(), 
        if (index == -1) //if serchBook() return -1, return false;
            return false;
        else {
            for (int i = 0; i < books.length; i++) {
                if (books[i].number == index) {
                    System.out.print("Index: " + books[i].number + ","); 
                    System.out.print("Name: " + books[i].name + ",");
                    System.out.print("Category: " + books[i].category + ",");
                    System.out.print("Availability: " + books[i].availability + ".");
                    System.out.println();                    
                } //else true,not new,print the details of the book             
            }
        } 
        return true;
    }
    public int searchBook(Book newBook, int byAttibutes) {
        int index = -1; //search book in the library list
        for (int i = 0; i < books.length; i ++) {
            if (books[i].equals(newBook, byAttibutes))
                index = books[i].number;
        }
        return index; //return int index; else -1
    }
}