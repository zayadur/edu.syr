/************************
  * College.java
  * Part of: ECS-102 HW2
  * By: Zayadur Khan
  * *********************/

//No packages need to be imported, since program is using basic functions

public class College
{
  public static void main(String[] args)
  {
    String name; //String variable for my name
    int age; //int variable for my age
    String college; //String variable for my college
    String petName; //String variable for my non-existent pet's name
    
    name = "Zayadur Khan";
    age = 18;
    college = "Syracuse University";
    petName = "Mew";
    
    System.out.println("Hello, my name is " + name + " and I am " + age + " years");
    System.out.println("old. I'm enjoying my time at " + college + ", though");
    System.out.println("I miss my pet " + petName + " very much!");
  }
}