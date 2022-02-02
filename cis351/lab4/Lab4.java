/*****************\
* @author         *
*   Zayadur Khan  *
* @version        *
*   093016        *
\*****************/

import java.io.*;

public class Lab4 {

  public static void main (String... argv) {
    System.out.println("fact(4) = "  + fact(4) + "\n");
    System.out.println("Even(4) = "  + Even(4) + "\n");
    System.out.println("fib(5) = "   + fib(5)  + "\n");
  }

  ////////////////////////////////////////////////////////////////////////
  // Our old friend the factorial function done recursively with tracing.
  public static int fact(int n) {
    Trace t = new Trace("fact","argument n = " + n);
    int result;
    if (n==0)
      result = 1;
    else
      result = n * fact(n-1);

    t.bye(result);
    return result;
  }

  ////////////////////////////////////////////////////////////////////////
  // This method tests whether an integer is even.
  public static boolean Even(int n) {
    Trace t = new Trace("Even","argument n = " + n);
    boolean result;

    if (n==0)
      result = true;
    else
      result = Odd(n-1);

    t.bye(result);
    return result;
  }

  ////////////////////////////////////////////////////////////////////////
  // This method tests whether an integer is even.

  public static boolean Odd(int n) {
    boolean result;
    Trace t = new Trace("Odd","argument n = " + n);

    if (n==0)
      result = false;
    else
      result = Even(n-1);

    t.bye(result);
    return result;
  }

  ////////////////////////////////////////////////////////////////////////
  // fib(n) = the nth Fibonacci number

  public static int fib(int n) {
    int result;
    Trace t = new Trace("fib","argument n = " + n);

    if (n<2) 
      result = n;
    else
      result = fib(n-2) + fib(n-1);

    t.bye(result);
    return result;
  }
  ////////////////////////////////////////////////////////////////////////
}
