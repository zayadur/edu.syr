import java.lang.Math;
import java.util.Arrays;
import java.time.YearMonth;

public class HW02 {
  //////////////////////////////////////////////////////////
  // factIter(n) = n!, computed iteratively
  public static int factIter(int n) {
    int result = 1; // variable to store final result
    if(n == 0 || n == 1) result = 1; // edge cases: when base is 0 or 1, product is always 1
    for(int i = n; i > 1; i--) { // let i be n, as long as i is greater than 1, decrement i each time
      result *= i; // set result equal to result times i
    }
    return result;
    // return Integer.MIN_VALUE; // FIX ME!!!
  }
    
  //////////////////////////////////////////////////////////
  // factRec(n) = n!, computed via a recursion
  public static int factRec(int n) {
    int result = 1;
    if(n == 0 || n == 1) result = 1;
    for(int i = n; i > 1; i--) {
      result = n * factRec(n-1); // recursively compute factorials
    }
    return result;
    // return Integer.MIN_VALUE; // FIX ME!!!
  } 
 
  //////////////////////////////////////////////////////////
  // formatPrice
  public static String formatPrice(int[] price) {
    return (price[0]+"/"+price[1]+"/"+price[2]);
  }
  
  //////////////////////////////////////////////////////////
  // LSD tally
  public static int[] tally(int[][] price) {
    int[] ans = {0,0,0};

    for(int i=0; i < price.length; i++) {
      if(i == 0) {
        int[] pounds = price[i];
      } else if(i == 1) {
        int[] shillings = price[i];
      } else {
        int[] pence = price[i];
      }
      ans = price[i];
    }
    
    return ans;  // FIX ME!!!
  }
  
  //////////////////////////////////////////////////////////////////////
  // the monthly payment problem
  public static double payMonthly(double prin, double apr, int yrs) {
    double mpr = apr / 12.0;
    int ms = yrs * 12;
    double payment = 0.0;
    
    if(apr == 0) {
      payment = (prin * mpr * Math.pow((1 + mpr), ms)) / (Math.pow((1 + mpr), ms));
    } else {
      payment = (prin * mpr * Math.pow((1 + mpr), ms)) / (Math.pow((1 + mpr), ms) - 1);
    }
    return payment;
  }
  
  public static void testPay(double prin,double arp,int yrs) {
    System.out.println("For a loan of "+prin+" at interest rate "+arp+
                       " (APR) for "+yrs+ " years, ");
    System.out.println("  the monthy payment is: "
         + payMonthly(prin,arp,yrs) + "\n");
  }

  //////////////////////////////////////////////////////////
  // days(y,m) = the number of days in month n of year y
  public static int days(int year, int month) {
    // Thirty days have September, April, June and November. 
    // All the rest have thirty-one, 
    // Except February the only one  
    // Which Leap Years change each fourth time  
    // From twenty-eight to twenty-nine. 
    // Century 100s don't always leap, 
    // each 400 years that leap we keep.
    // return Integer.MIN_VALUE; // FIX ME!!!

    YearMonth ym = YearMonth.of(year, month); // create YearMonth object to get current date
    int days = ym.lengthOfMonth(); // retrieve number of days by getting the length of the specified month

    return days;
  }
  
  //////////////////////////////////////////////////////////
  // I little method for printing out tests for problem 5.
  public static void testDays(int year, int month) {

    System.out.println(month+"/"+year+" has " + 
                       days(year,month)+" days");
  }
  
  //////////////////////////////////////////////////////////
  /**
   * The main method for testing the assignment's methods.
   */
  public static void main(String argv[]) {
    
    /////////////////////////////////////////////////////////
    System.out.println("\n**Tests for Problem 1**");
    for (int i = 1; i<=10; i++) 
      System.out.println("factIter("+i+") =\t"+ factIter(i));
    
    /////////////////////////////////////////////////////////
    System.out.println("\n**Tests for Problem 2**");
    for (int i = 1; i<=10; i++) 
      System.out.println("factRec("+i+") =\t"+ factRec(i));
    
    /////////////////////////////////////////////////////////
    System.out.println("\n**Tests for Problem 3**");
    testPay(10000.0, 0.0, 3);
    testPay(10000.0, 0.02, 3);
    testPay(10000.0, 0.06, 3);
    testPay(10000.0, 0.3, 3);
    testPay(10000.0, 0.02, 4);
    testPay(10000.0, 0.06, 4);
    testPay(10000.0, 0.2, 4);
    
    /////////////////////////////////////////////////////////
    System.out.println("\n**Tests for Problem 4**");
    int[][] p1 = {{1,12,11},{0,14,2},{1,17,11},{0,4,10},{2,3,10},
                  {0,13,9},{1,17,1},{1,13,1},{1,6,5},{2,3,3}};
    // NOTE: p1[0][0] = 1, p1[0][1] = 12, p1[0][2] = 11, p1[1][0] = 0, ...
    int[][] p2 = {{1,17,1},{1,17,11},{0,4,11},{0,16,3},{2,14,5},
                  {0,16,2},{1,18,10},{2,9,1},{0,10,11},{1,4,4}};
    int[][] p3 = {{2,3,3},{0,11,0},{1,16,10},{1,0,6},{1,1,5},
                 {1,8,1},{1,14,3},{0,14,0},{0,15,10},{0,10,2}};
    int[][] p4 = {{0,17,8},{0,16,9},{1,2,6},{0,10,11},{0,10,5},
                  {0,9,2},{1,13,6},{0,12,7},{0,2,5},{2,10,10}};
    int[][] p5 = {{0,4,11},{2,7,10},{0,15,5},{1,13,4},{0,10,0},
                  {2,4,9},{0,17,1},{1,15,3},{2,9,6},{2,14,5}};
    System.out.println("\nLSD sums"); 
    System.out.println("Sum 1 = "+formatPrice(tally(p1))); // answer: 14/7/3
    System.out.println("Sum 2 = "+formatPrice(tally(p2))); // answer: 14/9/11
    System.out.println("Sum 3 = "+formatPrice(tally(p3))); // answer: 11/15/4
    System.out.println("Sum 4 = "+formatPrice(tally(p4))); // answer: 9/6/9
    System.out.println("Sum 5 = "+formatPrice(tally(p5))); // answer: 15/12/6
    
    /////////////////////////////////////////////////////////
    System.out.println("\n**Tests for Problem 5**");
    testDays(1900,2);  // 28
    testDays(2000,2);  // 29
    testDays(2004,2);  // 29
    testDays(2016,1);  // 31
    testDays(2016,2);  // 29
    testDays(2016,9);  // 30
    testDays(2016,12); // 31
    testDays(2100,2);  // 28
    
  
  }
    
}