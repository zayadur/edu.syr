// Person.java
// Edited by Zayadur Khan for ECS-102
public class Person
{
  //instance data
  protected String name;
  protected int age;
  protected String hobby; //added to make 4-parameter Child constructor work
  protected int grade; //added to make 4-parameter Child constructor work
  
  //constructors
  
  //Constructor with 0 parameters
  public Person()
  {
    name = "Ghost";
    age = 1000;
  }

  //Constructor with 2 parameters
  public Person(String n, int a)
  {
    name = n;
    age = a;
  }
  
  //Constructor with 4 parameters *this was added to make the 4-parameter Child constructor function properly
  public Person(String n, int a, String h, int g)
  {
    name = n;
    age = a;
    hobby = h;
    grade = g;
  }

  //other methods
  public String toString()
  {
    String result;
    result="Person:\n";
    result+= "   name: " + name + "   age: " + age;
    return result;
  }//end toString
  
  public void identify()
  { System.out.println("My name is " + name); }
  
  public void eat()
  { System.out.println("Mmm. Tastes good."); }

}  //endPerson
