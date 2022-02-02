import java.io.*;

public class Sums {
  public static void main(String argv[]) {
    
    Loop0(100,2000,100);
    
    Loop1(100,2000,100);  // possibly change these values 
    
    Loop2(100,2000,100);  // possibly change these values 
    
    Loop3(100,2000,100);  // possibly change these values 
    
    Loop4(100,2000,100);  // possibly change these values 
    
    Loop5(100,2000,100);  // possibly change these values 
  }
  
  
  ////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////
  // LOOP 0 --- an example
  ////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////
  
  public static void Loop0(int nMin, int nMax, int nStep) {
    int i, j, n;
    long z;
    
    System.out.println("\n\nLoop 0 -- an example");
    
    for (n=nMin; n <= nMax; n=n+nStep) {
      
      ////////////////////////////////////////
      // Get a measurement for the value of z
      i = 1;    
      z = 0;
      while (i < 0.5*n*n + 50*n + 3 ) {
        i++;
        z++;
      }
      ////////////////////////////////////////
      
      // Report results
            ////////////////////////////////////////
      // Report results
      System.out.println("  n = "    + n +
                         "  i = "    + i +
                         "  z = "    + z +
                         "  z/f(n) = "  + (double)z/((double) n*n)
                        );  
    }
    
    System.out.println("\nNote that z/n*n seems to " +
                       "be converging to something near 0.5.\n");
    
  }
  
  
  ////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////
  // LOOP 1
  ////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////
  
  public static void Loop1(int nMin, int nMax, int nStep) {
    int i, j, n;
    long z;
    
    System.out.println("\n\nLOOP 1");
    
    for (n=nMin; n <= nMax; n=n+nStep) {
      
      ////////////////////////////////////////
      // Get a measurement for the value of z
      i = 1;    z = 0;
      for (i = n-1; i > 1; i--)
        for (j = i+1; j<=n; j++) z++;
      ////////////////////////////////////////
      // Report results
      System.out.println("  n = "    + n +
                         "  i = "    + i +
                         "  z = "    + z +
                         "  z/f(n) = "  + (double)z/((double) (n*n)-1)
                           // Choose a more interesting ratio than z/1
                        );
    }

       ////////////////
      //  My report //
     ////////////////

     System.out.println("\nLoop 1 report\n\n" +
                        "When z is divided by the function (n^2 - 1),\n" + 
                        "I get the results above and they seem to\n" +
                        "approach a constant of 0.49\n\n" +
                        
                        "i starts at n-1 and goes down until it is\n" +
                        "greater than 1. Since we know the function\n" +
                        "is Θ(n^2), itfollows that z is Θ(n^2).");

  }


  
  
  ////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////
  // LOOP 2
  ////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////
  
  public static void Loop2(int nMin, int nMax, int nStep) {
    int j, n;
    long z;
       
    System.out.println("\n\nLOOP 2");
    
    for (n=nMin; n <= nMax; n=n+nStep) {
      
      ////////////////////////////////////////
      // Get a measurement for the value of z
      float i = n;     
      z = 1;
      while (i >= 1.0 ) {
        i = (7*i)/8;
        z = z + 1;
      }
      ////////////////////////////////////////
      
      // Report results
      System.out.println("  n = "    + n +
                         "  i = "    + i +
                         "  z = "    + z +
                         "  z/f(n) = "  + (double)z/((double) n)
                           // Choose a more interesting ratio than z/1
                        );
    }

       ////////////////
      //  My report //
     ////////////////

     System.out.println("\nLoop 2 report\n\n" +
                        "When z is divided by the function (n),\n" + 
                        "I get the results above and they seem to\n" +
                        "approach a constant of 0.03\n\n" +
                        
                        "i starts at n and continues to loop until it is\n" +
                        "greater than or equal to 1. Since we know the\n" + 
                        "function is Θ(n), it follows that z is Θ(n).");

  }
  
  ////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////
  // LOOP 3
  
  public static void Loop3(int nMin, int nMax, int nStep) {
    int i, j, n;
    double z; 
    
    System.out.println("\n\nLOOP 3");
    
    
    for (n=nMin; n <= nMax; n=n+nStep) {
      ////////////////////////////////////////
      // Get a measurement for the value of z
      z = 0;
      for (i=1; i*i<=6*n ; i++) z=z+1;
      ////////////////////////////////////////
      
      // Report results
      double logn = Math.log(n), sqrtn = Math.sqrt(n);
      System.out.println("  n = "    + n +
                         "  i = "    + i +
                         "  z = "    + z +
                         "  z/?? = "  + (double)z/((double) Math.log(n*n))
                           // Choose a more interesting ratio than z/1
                        );      
    }

       ////////////////
      //  My report //
     ////////////////

     System.out.println("\nLoop 3 report\n\n" +
                        "When z is divided by the function (log(n^2)),\n" + 
                        "I get the results above and they seem to\n" +
                        "approach a constant of 6 to 7 as n becomes larger\n\n" +
                        
                        "i starts at 1 and loops until it is less\n" +
                        "than 6*n. Since we know the function is Θ(log(n^2)), it\n" +
                        "follows that z is Θ(log(n)).");

  }
  
  
  ////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////
  // LOOP 4
  
  public static void Loop4(int nMin, int nMax, int nStep) {
    int i, j, n;
    long z;
    double logn;
    
    System.out.println("\n\nLOOP 4");
    
    for (n=nMin; n <= nMax; n=n+nStep) {
      
      ////////////////////////////////////////
      // Get a measurement for the value of z
      z = 0;
      for (i=1; i<n ; i=i*3)
	for (j=0; j<i; j++) z++;

      ////////////////////////////////////////
      
      // Report results
      logn = Math.log(n);
      System.out.println("  n = "    + n +
                         "  i = "    + i +
                         "  z = "    + z +
                         "  z/f(n) = "  + (double)z/((double) 1)  
                           // Choose a more interesting ratio than z/1
                        );
    }

       ////////////////
      //  My report //
     ////////////////

     System.out.println("\nLoop 4 report\n\n" +
                        "Loop 4 seems to be already at a constant of\n" +
                        "z/f(n) = 1093.0.\n\n" +

                        "Therefore, z is linear, so it is Θ(n)");
  }
  
  
  ////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////
  // LOOP 5
  ////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////
  
  public static void Loop5(int nMin, int nMax, int nStep) {
    int i, j, k, n;
    long z;
    
    System.out.println("\n\nLOOP 5");
    
    for (n=nMin; n <= nMax; n=n+nStep) {
      
      ////////////////////////////////////////
      // Get a measurement for the value of z
      z = 0;
      for (i=1; i<=n; i++)
	for (j=0; j<i; j++)
	  for (k=1; k<=i+1; k++)
	    z = z+1;
      
      ////////////////////////////////////////
      
      // Report results
      System.out.println("  n = "    + n +
                         "  i = "    + i +
                         "  z = "    + z +
                         "  z/f(n) = "  + (double)z/((double) n*n*n)  
                           // Choose a more interesting ratio than z/1
                        );
    }

       ////////////////
      //  My report //
     ////////////////

     System.out.println("\nLoop 5 report\n\n" +
                        "Loop 5 has 3 for loops, which indicate a quadratic\n" +
                        "relation. As such, it was assumed f(n) was Θ(n^3),\n" +
                        "and the z/f(n) constant appears to be 0.33.\n\n" +

                        "As such, z is Θ(n^3)");

  }
  
  ////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////
} // end of the class Sums
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////


