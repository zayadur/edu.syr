//lab13
public class Lab13
{
  public static void main(String [] args)
  {
    // initialize products
    int intprod = 1;
    double doubprod=1.0;
    int k;

    for (k=1; k<=50; k++)
    {
      intprod*=k;
      doubprod*=k;
      System.out.println("k= " + k + "  intprod= " + intprod 
                        + "  doubprod= " + doubprod);
    }  //end for
  } //end main
} //end class