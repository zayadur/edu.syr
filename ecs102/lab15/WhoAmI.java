//WhoAmI?
public class WhoAmI
{
  //Part E. 
  int i = 1; 
  public static void main(String[] args)
  {
    System.out.println("In main, before declaring i.");
    System.out.println(i);
    int i = 2;
    System.out.println("In main, after declaring i.");
    System.out.println(i);
    
    {
      //Part C.
      System.out.println("In block, before declaring i.");
      System.out.println(i);
      //int i = 3;
      int k=3;
      System.out.println("In block, after declaring k.");
      System.out.println(k);
    } //end block
    
    //Part D.
    //System.out.println("In main, after block declaring k.");
    //System.out.println(k);
    f();
    g(4);
    h();
    System.out.println("In main, after all methods.");
    System.out.println(i);
  } //end main
  public static void f()
  {
    System.out.println("In f.");
    System.out.println(i);
  } //end f
  public static void g(int i)
  {
    System.out.println("In g, with parameter i.");
    System.out.println(i);
  } //end g
  public static void h()
  {
    int i=5;
    System.out.println("In h with local i.");
    System.out.println(i);
  }  //end h   
} //end WhoAmI
