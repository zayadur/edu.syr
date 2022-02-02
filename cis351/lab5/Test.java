import java.io.*;
import java.util.*;
import java.lang.*;

public class Test {

  //////////////////////////////////////////////////////////////////////
  // The main method 
  public static void main(String argv[]) {
    // for (int i = 100; i < 1000; i=i+100) // original loop
    for (int i = 10000; i < 100000; i=i+10000) experiment(i);
  }

  //////////////////////////////////////////////////////////////////////
  // experiment(int arraySize)
  //   Carry out the run-time tests on the sorts on a random array
  //   of size arraySize

  public static void experiment(int arraySize) {
    int a[], b[];
    long steps;
 
    // A example use of the Math.log method.
    // System.out.println("The natural log of 10 is " + Math.log(10));
  
    // create two int arrays of arraySize many elements
    a = new int[arraySize];
    b = new int[arraySize];
    FillRandom(a);
    
 
    System.out.println("The array size is " + arraySize);
 
    System.arraycopy(a,0,b,0,arraySize);  // copy a to b
    steps= Sorts.sort1(b);    
    System.out.printf("Number of steps for Sort 1: %12d %n ",steps);
    //scales(steps, arraySize);
 
    System.arraycopy(a,0,b,0,arraySize);  // recopy a to b
    steps = Sorts.sort2(b);    
    System.out.printf("Number of steps for Sort 2: %12d %n",steps);
    //scales(steps, arraySize);
    
    System.arraycopy(a,0,b,0,arraySize);  // recopy a to b
    steps = Sorts.sort3(b);    
    System.out.printf("Number of steps for Sort 3: %12d %n",steps); 
    //scales(steps, arraySize);
 
    System.arraycopy(a,0,b,0,arraySize);  // recopy a to b
    steps = Sorts.sort4(b);    
    System.out.printf("Number of steps for Sort 4: %12d %n",steps); 
    scales(steps, arraySize);
  }

  //////////////////////////////////////////////////////////////////////
  // FillRandom(int a[])
  //   Fill an int array with random ints

  public static void FillRandom(int a[]) {
    Random r = new Random();
    for (int i = 0; i<a.length; i++) a[i] = r.nextInt();
  }
  
  //////////////////////////////////////////////////////////////////////
  // scales(int t,int n)
  //   Print some ratios of interest
  public static void scales(long t,int n) {
    double a = t/(n*Math.log(n));
    double b = t/((double) n*n);
    double c = t/((double) n*n*n);
    System.out.printf("(i) %8f   (ii) %8f   (iii) %8f %n",a,b,c);
  }
}
