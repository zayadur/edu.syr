public class DishTester
{
  public static void main(String[] args)
  {
    Dish dish = new Dish("ceramic");
    Bowl bowl = new Bowl("wooden", 32);
    
    System.out.println(dish);
    System.out.println(bowl);
    
    dish.sayPretty("ceramic");
    bowl.sayUse(32);
  }
}

/* OUTPUT
> run DishTester
Dish is made of: ceramic 
Bowl is made of ceramic
and holds 32oz.
What a pretty ceramic dish! 
soup bowl
> 