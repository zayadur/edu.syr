/*******************************************************\
|   Test3 class to trigger timestamp() from Box3 class  |
|   @ author                                            |
|     Zayadur Khan                                      |
|   @ version                                           |
|     092216                                            |
\*******************************************************/

public class Test3 {
  public static void main(String argv[]) {

    System.out.println("Box 3 run on: " + Box3.timestamp());

    Box3 x = new Box3();
    Box3 y = new Box3();
    x.set(34);  y.set(8);
    System.out.println("x: " + x.get());
    System.out.println("y: " + y.get());
  }
}
