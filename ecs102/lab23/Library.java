//Library
public class Library
{  
  public static void main(String [] args)
  {
    //Create bookList
    Book[] bookList = new Book[10];
    int numberOfBooksCreated = 0;
    
    // Comment B: Create a Book
    
    
    // Comment C: Create two CirculatingBooks
   
    // Comment F: Create three OvernightReserveBooks
    
    // Comment G: Create two HourlyReserveBooks
    
    
    
    // Comment D: update numberOfBooksCreated
    
    
    // Comment H: set Late fee of bookList[6]
    
    
    //Display books
    for(int id=0; id<numberOfBooksCreated; id++)
    {
      bookList[id].checkOut();
      
      //Comment E: Asses Fines
      
      
      System.out.println();
    }
    
    //Comment I:  Create a TwoHourReserveBook not using polymorphism
    
    
  }
  
  
} // end class Library