public class Bowl extends Dish
{
  //member data
  int size; //number of ounces
  
  //constructors
  public Bowl(String material, int size)
  {
    super(material);
  }
  
  public String toString()
  {
    String result = "";
    result += "Bowl is made of " + material;
    result += "\nand holds " + size + "oz.";
    return result;
  }
  
  public void sayUse(int size)
  {
    if(size <= 20)
      System.out.println("serving bowl");
    else
      System.out.println("soup bowl");
  }
}
