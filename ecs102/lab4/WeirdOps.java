// WeirdOps   Author: Baruch
// Understand:  increment operator, assignment operator,
//              final constants.

public class WeirdOps
{
   public static void main (String[] args)
   {
      int k,m,p;
      
      k=5;
      m=5;
      System.out.println("1.  k = " + k  + "   m = " + m);
      k++;
      ++m;
      System.out.println("2.  k = " + k  + "   m = " + m);
      
      System.out.println("3.  k = " + k++ 
                          + "   m = " + ++m);
      
      System.out.println("4.  k = " + k 
                          + "   m = " + m);
      
      //Some assignment operators
      int x=57;
      System.out.println("5. x = " + x);
      x+=10;
      System.out.println("6. x = " + x);
      x=+10;
      System.out.println("7. x = " + x);
      
      x=100;
      int y=2;
      x*=y;
      x-=y;
      System.out.println("8. x = " + x);
      
      y--;
      x-=y;
      System.out.println("9. x = " + x 
                            + "   y = " + y);
          
   } // end main
} // end class