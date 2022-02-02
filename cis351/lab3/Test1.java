/***********************************\
|   Test1 class to test Box1 class  |
|   @ author                        |
|     Zayadur Khan                  |
|   @ version                       |
|     092216                        |
\***********************************/

/* Report is located in Test1-transcript */

public class Test1 {
  public static void main(String argv[]) {
    
    Box1 x = new Box1();
    Box1 y = new Box1();

    x.setA(23);
    x.setB(32);

    System.out.println(x.getA());
    System.out.println(x.getB());

    y.setA(10);
    y.setB(90);

    System.out.println(x.getA());
    System.out.println(x.getB());
  }
}
