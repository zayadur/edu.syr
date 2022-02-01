public class Dish
{
  String material; //could be glass, ceramic, metal
  
  //Constructor with 1 parameter
  public Dish(String material)
  {
    material = "ceramic";
  }
  
  public String toString()
  {
    String result = "";
    result += "Dish is made of: " + material;
    return result;
  }
  
  public void sayPretty(String material)
  { System.out.println("What a pretty " + material + " dish!"); }
}
