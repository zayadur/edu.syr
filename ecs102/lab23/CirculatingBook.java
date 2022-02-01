//CirculatingBook
public class CirculatingBook extends Book
{
  private double dailyFine;
  
  //Construct a CirculatingBook given its title
  //and author
  public CirculatingBook(String t, String a)
  {
    super(t,a);
    dailyFine = .50;
  }
  
  //Print message for checking out a CirculatingBook
  public void checkOut()
  {
    System.out.println("Due in 2 weeks:" + this);
  }
  
  //Assess a fine on a late book
  public void assessFine(int daysLate)
  {
    if (daysLate>0)
      System.out.println("Your late fee is $" + daysLate*dailyFine);
  }
} // end class CirculatingBook