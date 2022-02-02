import java.io.*;

public class Poke {
  public static void main(String argv[]) {
    Puzzle0 p0 = new Puzzle0();
    Puzzle1 p1 = new Puzzle1();
    Puzzle2 p2 = new Puzzle2();
    Puzzle3 p3 = new Puzzle3();
    
    // Do your tests on p1.a, p1.b, p2.a, p2.b, p3.a, and p3.b below.
       
    // Example: Figuring out Puzzle0.
    System.out.println("\n**PUZZLE 0 Experments**");
    System.out.println("p0.a is " + p0.a); // prints: -T-O-
    System.out.println("p0.b is " + p0.b); // prints: -Y-O-
    // The O might be in a shared Node
    p0.a.changeAll('O','X');
    System.out.println("p0.a is " + p0.a); // prints: -T-X-
    System.out.println("p0.b is " + p0.b); // prints: -Y-X- 
    // Since p0.b's last Node's letter changed from an O to an X,
    // that Node must be shared between p0.a and p0.b.
    // So we have the digram given in Part I of the Lab writeup
   
  
    System.out.println("\n**PUZZLE 1 Experments**");
    System.out.println("p1.a is "+ p1.a);
    System.out.println("p1.b is "+ p1.b);

    System.out.println("\nChange all the e's in p1.b to h's");
    p1.b.changeAll('e','h');
    System.out.println("p1.a is "+ p1.a);
    System.out.println("p1.b is "+p1.b);

    System.out.println("\nChange all the a's in p1.a to e's");
    p1.a.changeAll('a','e');
    System.out.println("p1.a is "+ p1.a);
    System.out.println("p1.b is "+p1.b);

    System.out.println("\nChange all the s's in p1.b to a's");
    p1.b.changeAll('s','a');
    System.out.println("p1.a is "+ p1.a);
    System.out.println("p1.b is "+p1.b);

    System.out.println("\nChange all the y's in p1.a to r's");
    p1.a.changeAll('y','r');
    System.out.println("p1.a is "+ p1.a);
    System.out.println("p1.b is "+p1.b);

    // Now write down a box and arrow diagram for p1.a and p1.b.
    // Explain why your diagram *must* be correct.

    System.out.println("\n**PUZZLE 2 Experments**");
    System.out.println("p2.a is "+ p2.a);
    System.out.println("p2.b is "+ p2.b);

    System.out.println("\nChange all the l's in p2.a to r's");
    p2.a.changeAll('l','r');
    System.out.println("p2.a is "+p2.a);
    System.out.println("p2.b is "+p2.b);

    System.out.println("\nChange all the o's in p2.a to u's");
    p2.a.changeAll('o','u');
    System.out.println("p2.a is "+p2.a);
    System.out.println("p2.b is "+p2.b);

    System.out.println("\nChange all the k's in p2.a to n's");
    p2.a.changeAll('k','n');
    System.out.println("p2.a is "+p2.a);
    System.out.println("p2.b is "+p2.b);
    
    if (p2.a.front==null)
      System.out.println("Hey, p2.a is empty");
    else
      System.out.println("The first letter in p2.a is: "
    + p2.a.front.letter);

    // Etc.
    System.out.println("\n**PUZZLE 3 Experments**");
    System.out.println("p3.a is "+ p3.a);
    // System.out.println("p3.b is "+ p3.b); // This causes bad things to happen.

    System.out.println("\nPushing a, b, c to p3.a");
    p3.a.push('c');
    p3.a.push('b');
    p3.a.push('a');
    System.out.println("p3.a is "+p3.a);

    System.out.println("\nPoking p3.b");
    // p3.b.push('f');
    // p3.b.push('e');
    // p3.b.push('d');
    // System.out.println(p3.b.toString());
    // System.out.println(p3.b.find(''));
    // p3.b.changeAll(' ','s');

    p3.b = p3.a.rest();
    //System.out.println(p3.b);
    p3.b.push('f');
    //System.out.println(p3.b);
    p3.a.changeAll('b','y');
    //System.out.println(p3.b);
    p3.a = p3.b.rest();
    System.out.println(p3.a);
    System.out.println(p3.b);
  }
}
