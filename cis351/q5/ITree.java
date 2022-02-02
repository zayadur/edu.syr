class Node {
  // Node's instance variables
  protected int data;
  protected Node left, right;  
  // Node's Constructor
  public Node(int d, Node lft, Node rght) {
    data = d;  left = lft;  right = rght;
  }
  public boolean isLeaf() { 
    return (left==null) && (right==null); 
  }
}
////////////////////////////////////////////
public class ITree {
  /** The root of the ITree */
  protected static Node root;
  // ITree's constructor
  public ITree() { root = null; }
  // ITree's instance methods
  
  public static void autumn() {
    root = fall(root);
    System.out.print(root);
  }

  /** return a leafless version of the subtree rooted at u */
  protected static Node fall(Node u) {
    if (u==null || u.isLeaf()) return null;
    u.left  = fall(u.left);
    u.right = fall(u.right);  
    return u;
  }

  public static void main(String[] args) {
      autumn();
  }

}