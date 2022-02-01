//OvernightReserveBook
public class OvernightReserveBook extends Book
{
  private double hourlyFine;
  
  //Construct an OvernightReserveBook given its
  //title and author
  public OvernightReserveBook(String t, String a)
  {
    super(t,a);
    hourlyFine = 1.00;
  }
  
  //Print message for checking out an OvernightReserveBook
  public void checkOut()
  {
    System.out.println("Due in 24 hours:" + this);
  }
  
  //Assess a fine on a late book
  public void assessFine(int hoursLate)
  {
    if (hoursLate>0)
    {
      System.out.println(hoursLate + " hours late.");
      System.out.println("Your late fee is $" + hoursLate*hourlyFine);
    }
  }
} // end class OvernightReserveBook