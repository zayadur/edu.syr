//Child.java derived from Person
// Edited by Zayadur Khan for ECS-102
public class Child extends Person {
  
  //member data
  
  String name;
  int age;
  String hobby;
  int grade;
  
  //constructors
  
  //Child 0-parameter constructor
  public Child()
  {
    super(); //calls Person 0-parameter constructor
  }
  
  //Child 2-parameter constructor
  public Child(String n, int a)
  {
    super(n,a); //calls Person 2-parameter constructor
  }
  
  //Child 4-parameter constructor
  public Child(String n, int a, String h, int g)
  {
    super(n,a,h,g); //calls Person 4-parameter constructor
  }

  //other methods
  
  public String toString(String n, int a, String h, int g)
  {
    String result = "Child:\n";
    result+="NAME: " + n + "   AGE: " + a;
    //result+=super.toString();
    result+="\nI love to " + h;
    result+= "\nI am in grade " + g +".";
    return result;
  }
  
  public void identify(String n, int g)
  { System.out.println("My name is " + n + ", and I'm in grade " + g); }
  public void eat()
  { System.out.println("Chomp Chomp"); }
  public void play(String h)
  { System.out.println("This person likes to " + h); }
}
