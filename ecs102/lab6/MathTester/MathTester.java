//MathTester.java  Author: Baruch
//Try out some of the math functions.
//Also, play with formatting.
import java.text.DecimalFormat;
import java.text.NumberFormat;
public class MathTester
{
  public static void main(String[] args)
  {
    int i;
    double d, z;
    DecimalFormat dfmtA=new DecimalFormat("##.###");
    DecimalFormat dfmtB=new DecimalFormat("00.##");
    NumberFormat curFmt=NumberFormat.getCurrencyInstance();
    NumberFormat pctFmt=NumberFormat.getPercentInstance();
    
    d = -3.67;
    z = Math.abs(d);
    System.out.println("abs: d=" + d + "  abs(d)=" + z);
    
    d = 4.345;
    System.out.println("ceil: d=" + d + "  ceil(d)=" + Math.ceil(d));
    
    z = Math.floor(d);
    System.out.println("floor: d=" + d + "  floor(d)=" + z);
    
    d=-d;
    z = Math.ceil(d);
    System.out.println("ceil: d=" + d + "  ceil(d)=" + z);
    
    z = Math.floor(d);
    System.out.println("floor: d=" + d + "  floor(d)=" + z);
    
    z = Math.pow (2.0, 3.0);
    System.out.println("pow: 2.0^3.0=" + z);
    
    z = Math.pow (3.0, 2.0);
    System.out.println("pow: 3.0^2.0=" + z);
    
    // e=2.7182818284590455 (approx)
    z = Math.exp(1.0);
    System.out.println("exp: e^1.0 = " + dfmtA.format(z));
    System.out.println("exp: e^1.0 = " + dfmtB.format(z));//round or truncate?
    
    z = Math.sqrt(16.0);
    System.out.println("sqrt: sqrt(16.0) = " + z);
    
    z = Math.pow (16.0, 1/2);
    System.out.println("pow: 16.0^(1/2) =" + z);
    
    z = 50.0/500.0;
    System.out.println("50.0 is " + pctFmt.format(z) + " of 500.0");
    
    int intRate = 5;
    double investment = 1000.00;
    double interest;
    interest = (double)intRate/100 * investment;
    System.out.print(pctFmt.format(intRate) + " of " + curFmt.format(investment));
    System.out.println(" is " + curFmt.format(interest));
    
    //oops
    double rate = .05;
    interest = rate*investment;
    System.out.print(pctFmt.format(rate) + " of " + curFmt.format(investment));
    System.out.println(" is " + curFmt.format(interest));
    
  }
} // end class