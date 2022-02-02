import java.util.Arrays;
// Sharing, cloning of arrays, arraycopy
// Refs:
//  http://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#toString-int:A-
//  http://docs.oracle.com/javase/8/docs/api/java/lang/System.html#arraycopy-java.lang.Object-int-java.lang.Object-int-int-
  
public class ADemo {
  /////////////////////////////////////////////////////////////  
  public static String stringify(String name, int[] xs) {
    return (name + ": " + Arrays.toString(xs) + "\n");
  }
  /////////////////////////////////////////////////////////////  
  public static void main(String argv[]) {
    String sep = "=======================================\n";
    int a[] = {11,22,33,44,55,66,77,88,99};
    int b[] = {10,20,30,40,50,60,70,80,90};
    int c[] = {-1,-2,-3,-4,-5,-6,-7,-8,-9};
    
    System.out.print(sep + "\t Initially \n" + stringify("a",a) + stringify("b",b) + stringify("c",c));
    
    a = b;
    System.out.print(sep + "\t After a = b \n"+ stringify("a",a) + stringify("b",b) + stringify("c",c));
    
    a[0] = 60;
    System.out.print(sep + "\t After a[0] = 60 \n"+ stringify("a",a) + stringify("b",b) + stringify("c",c));
    
    b[1] = 70;
    System.out.print(sep + "\t After b[1] = 70 \n"+ stringify("a",a) + stringify("b",b) + stringify("c",c));
        
    b = c.clone();
    System.out.print(sep + "\t After b = c.clone()\n" + stringify("a",a) + stringify("b",b) + stringify("c",c));

    c[0]=23;
    System.out.print(sep + "\t After c[0] = 23\n" + stringify("a",a) + stringify("b",b) + stringify("c",c));
    
    System.arraycopy(a,2,b,5,3); //  === b[5]=a[2];  b[6]=a[3];  b[7]=a[4];
    //  a === source array
    //  b === target array
    //  2 === start in source array
    //  5 === start in target array
    //  3 === number of items to copy
    System.out.print(sep + "\t After the arraycopy\n" + stringify("a",a) + stringify("b",b) 
                       + stringify("c",c) + sep);
  }
}