public class BabyYatzee
{
  public static void main(String[] args)
  {
    Die r, y, b, g, w;
    
    r = new Die();
    y = new Die();
    b = new Die();
    g = new Die();
    w = new Die();
    
    System.out.println("Initial values: " + r + " " + y + " " + b + " " + g + " " + w);
    
    r.roll();
    y.roll();
    b.roll();
    g.roll();
    w.roll();
    
    System.out.println("New values: " + r + " " + y + " " + b + " " + g + " " + w);
  }
}
    