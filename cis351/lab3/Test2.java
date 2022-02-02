/***********************************\
|   Test2 class to test Box2 class  |
|   @ author                        |
|     Zayadur Khan                  |
|   @ version                       |
|     092216                        |
\***********************************/

public class Test2 {
  
  public static void main(String argv[]) {
    
    Box2 x = new Box2(97,101);
    Box2 y = Box2.copy1(x);
    Box2 z = Box2.copy2(x);
    
    System.out.println("x: " + x.pair[0] + "  " + x.pair[1]);
    System.out.println("y: " + y.pair[0] + "  " + y.pair[1]);
    System.out.println("z: " + z.pair[0] + "  " + z.pair[1]);

    System.out.println("x: " + x.pair);
    System.out.println("y: " + y.pair);
    System.out.println("z: " + z.pair);

  }
}
