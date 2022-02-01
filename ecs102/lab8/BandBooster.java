public class BandBooster
{
  String name;
  int boxesSold;
  
  public int record(String name)
  {
    boxesSold = 0;
    return boxesSold;
  }
  
  public String getName()
  {
    return name;
  }
  
  public int updateSales(int sales)
  {
    boxesSold = boxesSold + sales;
    return boxesSold;
  }
  
  public String result()
  {
    return ("" + name + ": " + boxesSold);
  }
}