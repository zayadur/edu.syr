//Book
//abstract
public abstract class Book
{
  protected String title;
  protected String author;
  
  //construct a Book given its title and author
  public Book (String t, String a)
  {
    title = t;
    author = a;
  }
  
  //return a string representing the Book
  public String toString()
  {
    String result = "Title: " + title + "\n";
    result += "Author: " + author;
    return result;
  }
  
  //to represent checking out a book
  public abstract void checkOut();  //abstract, no body
  
  //to assess a fine on a book
  public abstract void assessFine(int late);
  
}// end class Book