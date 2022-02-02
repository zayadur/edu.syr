/*********************************************************
* Quadradic is a simple representation of quadratic expressions.
*
* @author
*   Zayadur Khan
* @version
*   19 September 2016
*
**********************************************************/
public class Quadratic {
  /** The x<sup>2</sup> coeffecient */
  double a;
  /** The x<sup>1</sup> coeffecient */
  double b;
  /** The constant coeffecient      */
  double c;
  /////////////////////////////////////////////////////////
  // Constructor
  /////////////////////////////////////////////////////////
  /**
   * Initialize a quadratic expression with all coeffecients 0.0 
   **/   
  public Quadratic() { 
    a = b = c = 0.0;
  }

  /////////////////////////////////////////////////////////
  // Setters and Getters
  /////////////////////////////////////////////////////////
  /**
   * Initialize a quadratic expression with the specified
   * values of the coeffecients.
   * @param aVal
   *   the initial value of the x<sup>2</sup> coeff.
   * @param bVal
   *   the initial value of the x<sup>1</sup> coeff.
   * @param cVal
   *   the initial value of the constant coeff.
   **/   
  public Quadratic(double aVal, double bVal, double cVal) {
    a = aVal; b = bVal; c = cVal; 
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Sets the x<sup>2</sup>-coeff.
   * @param  aVal
   *   the value that the x<sup>2</sup> coeff is set to.
   **/   
  public void setA(double aVal) { 
    a = aVal;
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Gets the x<sup>2</sup>-coeff.
   * @return
   *   The value of the x<sup>2</sup> coeff
   **/   
  public double getA() { 
    return a;
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Sets the x<sup>1</sup>-coeff.
   * @param bVal
   *   the value that the x<sup>1</sup> coeff is set to.
   **/   
  public void setB(double bVal) { 
    b = bVal;
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Gets the x<sup>1</sup>-coeff.
   * @return
   *   The value of the x<sup>1</sup> coeff
   **/   
  public double getB() { 
    return b;
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Sets the constant-coeff.
   * @param cVal
   *   the value that the x<sup>2</sup> coeff is set to.
   **/   
  public void setC(double cVal) { 
    c = cVal;
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Gets the constant-coeff.
   * @return
   *   The value of the x<sup>0</sup> coeff
   **/   
  public double getC() { 
    return c;
  }
  
  /////////////////////////////////////////////////////////
  // Other methods
  /////////////////////////////////////////////////////////
  /**
   * Evaluates the quadratic expression at x.
   * @param x
   *   the value at which to evaluate the expression
   * @return
   *   The value of the expression at x
   * <br><br><b>Example:</b>  For  
   * <blockquote>
   * <code>Quadratic p = new Quadratic(1,-4,3);</code> </blockquote> 
   * <ul>
   * <li><code>p.eval(0)</code> returns 3, 
   * <li><code>p.eval(1)</code> returns 0, 
   * <li><code>p.eval(2)</code> returns -5, 
   * <li><code>p.eval(3)</code> returns 0, and 
   * <li><code>p.eval(4)</code> returns 3.</ul>
   **/   
  public double eval(double x)  {
    Quadratic q = new Quadratic(a, b, c);
    return (Math.pow(x,2)*q.a) + (x*q.b) + (q.c);
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Adds two quadratic expressions
   * @param q1
   *   the first quadratic expression
   * @param q2
   *   the second quadratic expression
   * @return
   *   the quadratic expression that is the sum of q1 and a2
   **/   
  public static Quadratic sum(Quadratic q1, Quadratic q2) {
    double sumA = (q1.a + q2.a);
    double sumB = (q1.b + q2.b);
    double sumC = (q1.c + q2.c);   
    return new Quadratic(sumA, sumB, sumC);
  }
  
  /////////////////////////////////////////////////////////
  /**
   * Multiply the coeffs by a scaling value
   * @param r
   *   the scaling value
   * @param q
   *   the quadratic to scale
   * @return
   *   the resulting quadratic expression
   **/   
  public static Quadratic scale(double r, Quadratic q) {
    double productA = (q.a * r);
    double productB = (q.b * r);
    double productC = (q.c * r);
    return new Quadratic(productA, productB, productC);
  }
  
  /////////////////////////////////////////////////////////
  /**
   * The number of roots of a quadratic expression
   * @return
   *   The number of roots: either 0, 1, 2, or 3 (which
   *   stands for infinity)
   **/   
  public int numRoots() {
    double num = Math.pow(b,2) - 4 * a * c;
    if(num > 0) {
      return 2;
    } else if(num == 0) {
      return 1;
    } else {
      return 3;
    }
  }
  
  /////////////////////////////////////////////////////////
  /**
   * The smallest root of the quadratic expression
   * @return
   *   the smallest root of the quadratic expression.
   *   If there are infinitely many roots or no roots, 0.0
   *   is returned.
   **/   
  public double smallRoot() {
    return (-b-(Math.sqrt(Math.pow(b,2)-4*a*c)/2*a));
  }    

  
  /////////////////////////////////////////////////////////
  /**
   * The biggest root of the quadratic expression
   * @return
   *   the biggest root of the quadratic expression.
   *   If there are infinitely many roots or no roots, 0.0
   *   is returned.
   **/   
  public double bigRoot() {
     return (-b+(Math.sqrt(Math.pow(b,2)-4*a*c)/2*a));
  }    
 
  /////////////////////////////////////////////////////////
  /**
   * Convert the Quadratic to a string for printing.
   * @return
   *   a Sting version of the Quadratic
   **/  
  public String toString() {
    return Double.toString(a) + "*x^2 + " +
           Double.toString(b) + "*x + " +
           Double.toString(c);
  }
  
  /////////////////////////////////////////////////////////
  /**
   * <i>A test method:</i> Print the Quadratic and report on its roots.
   * @param q the Quadratic to report on
   **/   
  public static void report(Quadratic q) {
    System.out.println(q+" has:");
    switch (q.numRoots()) {
      case 0: 
        System.out.println("  no roots");
        break;
      case 1: 
        System.out.println("  one root: "+q.smallRoot());
        break;
      case 2: 
        System.out.println("  two roots: "+q.smallRoot()+" and "+q.bigRoot());
        break;
      default: 
        System.out.println("  infinitely many roots");
        break;
    }       
  } 

  /////////////////////////////////////////////////////////
  /**
   * A test program for the Quadratic class
   * @param argv command line arguments (not used) 
   */
  public static void main(String argv[]) {
    Quadratic q1 = new Quadratic();
    Quadratic q2 = new Quadratic();

    int e = 3; // test for eval
    int s = 2; // test for scale
    
    //                            Expected Output
    report(q1);                //  infinitely many roots
    report(q2);
    
    q1.setC(1);     report(q1); //  no roots
    q1.setB(-1);    report(q1); //  one root: 1.0
    q1.setA(1);     report(q1); //  no roots
    q1.setB(-2);    report(q1); //  one root: 1.0
    q1.setB(-3);    report(q1); //  two roots: 0.3819660112501051 and 2.618033988749895

    q2.setA(1);
    q2.setB(-1);
    q2.setC(1);
    
    // include more tests of, among other things, eval, scale, and sum.
    System.out.println("Evaluating Quadratic at " + e + ": " + q1.eval(e));
    System.out.println("Scaling Quadratic by " + s + ": " + scale(s, q1));
    System.out.println("Sum of quadratics: " + sum(q1, q2));
  }
}
