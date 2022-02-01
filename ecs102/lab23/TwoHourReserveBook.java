//TwoHourReserveBook
public class TwoHourReserveBook extends Book
{
  private double hourlyFine;
  
  //Construct a TwoHourReserveBook given the
  //title, author, and the hourly fine
  public TwoHourReserveBook(String t, String a, double hf)
  {
    super(t,a);
    hourlyFine = hf;
  }
  
  //print message for checking out a book
  public void checkOut()
  {
    System.out.println("Due in 2 hours:" + this);
  }
  
  //set the hourly fine for a late book
  public void setFine(double hf)
  {
    hourlyFine =  hf;
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
} // end class TwoHourReserveBook