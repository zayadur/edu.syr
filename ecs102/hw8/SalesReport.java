/* SalesReport for HW8, ECS-102
 * By: Zayadur Khan, 11/22/14 */

import java.io.IOException;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SalesReport
{
  static DecimalFormat round = new DecimalFormat("0.00");
  
  public static void main(String[] args) throws IOException
  {
    Scanner fileScan = new Scanner(new File("salesdata.txt"));
    
    double[][] sale = new double[4][5];
    
    double[] salesPerson = new double[4];
    
    double[] salesProduct = new double[5];
    
    scanFile(sale, fileScan);
    personTotals(sale, salesPerson);
    productTotals(sale, salesProduct);
    
    printData(sale, salesPerson, salesProduct);
  }
  
  static void scanFile(double[][] arr, Scanner fileScan)
  {
    fileScan.nextLine();
    int intID;
    
    int intProduct;
    
    while (fileScan.hasNext())
    {
      intID = fileScan.nextInt() - 1;
      intProduct = fileScan.nextInt() - 1;
      arr[intID][intProduct] += fileScan.nextDouble();
    }
  }
  
  static void personTotals(double[][] arr, double[] total)
  {
    for (int x = 0; x < arr.length; x++)
    {
      for (int y = 0; y < arr[x].length; y++)
      {
        total[x] += arr[x][y];
      }
    }
  }
  
  static void productTotals(double[][] Array, double[] Total)
  {
    for (int x = 0; x < Array.length; x++)
    {
      for (int y = 0; y < Array[x].length; y++)
      {
        Total[y] += Array[x][y];
      }
    }
  }
  
  static void printData(double[][] Array, double[] Person, double[] Product)
  {
    System.out.println("\t\t\tProduct Number");
    System.out.println("Salesperson\t\t1\t\t2\t\t3\t\t4\t\t5\t\tperson totals");
    
    for (int x = 0; x < Array.length; x++)
    {
      System.out.print((x + 1) + "\t");
      for (int y = 0; y < Array[x].length; y++)
      {
        System.out.print("\t\t" + round.format(Array[x][y]));
      }
      System.out.println("\t\t" + round.format(Person[x]));
    }
    System.out.print("Product Totals");
    for (int x = 0; x < Product.length; x++)
    {
      System.out.print("\t" + round.format(Product[x]));
    }
    System.out.println();
  }
}


/* OUTPUT
> run SalesReport
   Product Number 
Salesperson  1  2  3  4  5  person totals 
1   558.98  686.66  687.45  464.05  644.66  3041.80 
2   365.39  483.40  627.27  473.27  445.03  2394.36 
3   675.27  390.16  441.38  573.35  483.12  2563.28 
4   351.11  711.91  593.49  935.73  671.99  3264.23 
Product Totals 1950.75 2272.13 2349.59 2446.40 2244.80 
> */