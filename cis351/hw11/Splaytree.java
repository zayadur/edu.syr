// STARTING CODE: Version 1.3 (Thu Nov 10 10:10:32 EST 2016)

import java.util.*;

/******************************************************************************
  * This is splay tree class over items of type T.  It is roughly 
  * along the lines of the class described in section 6.2 of Open Data Structures.  
  * The one big change is that this class uses a sentinel node ANCHOR, where
  * <ul>
  *   <li> ANCHOR.left = the actual root of the tree
  *   <li> ANCHOR.parent = ANCHOR.right = ANCHOR.data = null
  * </ul>
  * We compare data fields via the method <code>compare</code> below where
  * we arrange that null acts like +&infin;, so that the ANCHOR node is the 
  * rightmost/largest node in the (extended) tree. 
  * 
  * @author Zayadur Khan
  *
  * @version
  *   Nov 15, 2016
  ****************************************************************************/

public class Splaytree<T extends Comparable<T>> {
  //////////////////////////////////////////////////////////////////////
  // instance variables
  /** The sentinel node for of the tree ANCHOR.left is the actual root */
  protected BSNode<T> ANCHOR;
  
  //////////////////////////////////////////////////////////////////////
  // Constructor
  public Splaytree() { ANCHOR = new BSNode<T>(null); }
  
  //////////////////////////////////////////////////////////////////////
  /** compares two T values where null is treated as +infinity
    * @param x first thing to compare
    * @param y second thing to compare
    * @return (i) a negative number if x &lt; y; (ii) 0, if x = y; 
    *   (iii) a positive number, if x &gt; y
    */
  public int compare(T x,T y) {
    if (x==null && y==null) return 0; // null == null
    if (y==null) return -1;           // y < null
    if (x==null) return 1;            // null > y
    return x.compareTo(y);
  }
  //////////////////////////////////////////////////////////////////////  
  /** Tests if root is empty
    * @return true iff root is null
    */
  public boolean isEmpty() { return (ANCHOR.left==null); }
  
  //////////////////////////////////////////////////////////////////////  
  /** Tests if a BSNode is the last one on the search path for z
    * @param z the value sought
    * @param u the BSNode to test
    * @return true iff in doing a BST search for z on the tree rooted at u
    *   the search would not continue on beyond u
    */
  private boolean terminal(T z,BSNode<T> u) {
    if (u==null) return true;
    if (compare(z,u.data)==0) return true;
    if (compare(z,u.data)<0) return u.left==null;
    return (u.right==null);
  }
  //////////////////////////////////////////////////////////////////////
  /** Splays trees at a given key value
    * @param pivot the value at the pivot node
    */
  public void splay(T pivot) { ANCHOR.left = splay(pivot,ANCHOR.left); }
  
  // helper function (where all the work takes place)
  // methods follow general structure of splay.hs methods, provided on website

  private BSNode<T> splay(T pivot, BSNode<T> u) {
    if (u==null || terminal(pivot,u)) return u;
    if (compare(pivot,u.data)<0) {
      if (terminal(pivot,u.left)) return zig(u.left,u.data,u.right);
      BSNode<T> ull = u.left.left;
      T           w = u.left.data;
      BSNode<T> ulr = u.left.right;
      if (compare(pivot,w)<=0) 
        return zigzig(splay(pivot,ull),w,ulr,u.data,u.right);
      else 
        return zigzag(ull,w,splay(pivot,ulr),u.data,u.right);
    }
    else { // pivot > x
      if (terminal(pivot,u.right)) return zag(u.left,u.data,u.right);
      BSNode<T> url = u.right.left;
      T           y = u.right.data;
      BSNode<T> urr = u.right.right;
      if (compare(pivot,y)<=0) 
        return zagzig(u.left,u.data,splay(pivot,url),y,urr);
      else 
        return zagzag(u.left, u.data, url, y, splay(pivot,urr));
    }
  }
  ////////////////////////////////////////////////////////////////////// 
  private BSNode<T> zig(BSNode<T> ux,T y,BSNode<T> uc) {
    BSNode<T> ua = ux.left;
    T          x = ux.data;
    BSNode<T> ub = ux.right;
    return new BSNode<T>(ua,x,new BSNode<T>(ub,y,uc));
  }
  ////////////////////////////////////////////////////////////////////// 
  private BSNode<T> zag(BSNode<T> ua,T x,BSNode<T> uy) {
    BSNode<T> uc = uy.left;
    BSNode<T> ud = uy.right;
    T y = uy.data;
    return new BSNode<T>(uc,y,new BSNode<T>(ud,x,uc));
  }
  ////////////////////////////////////////////////////////////////////// 
  private BSNode<T> zigzig(BSNode<T> ux,T y, BSNode<T> uc, T z,BSNode<T> ud) {
    BSNode<T> ua = ux.left;
    T          x = ux.data;
    BSNode<T> ub = ux.right;
    return new BSNode<T>(ua,
                         x,
                         new BSNode<T>(ub,y,new BSNode<T>(uc,z,ud)));
  }
  ////////////////////////////////////////////////////////////////////// 
  private BSNode<T> zagzag(BSNode<T> ua, T x, BSNode<T> ub, T y, BSNode<T> uz) {
    BSNode<T> uc = uz.left;
    T          z = uz.data;
    BSNode<T> ud = uz.right;
    return new BSNode<T>(new BSNode<T>(new BSNode<T>(ua, x, ub), y, uc), z, ud);
  }  
  ////////////////////////////////////////////////////////////////////// 
  private BSNode<T> zigzag(BSNode<T> ua,T x, BSNode<T> uy, T z,BSNode<T> ud) {
    BSNode<T> ub = uy.left;
    T          y = uy.data;
    BSNode<T> uc = uy.right; 
    return new BSNode<T>(new BSNode<T>(ua, x, ub), y, new BSNode<T>(uc, z, ud));
  }
  ////////////////////////////////////////////////////////////////////// 
  private BSNode<T> zagzig(BSNode<T> ua,T x, BSNode<T> uy, T z,BSNode<T> ud) {
    return zigzag(ua,x,uy,z,ud);
  }
  
  //////////////////////////////////////////////////////////////////////
  /** Adds value x to the splay tree
    * @param x the value to be added
    * @return true if value was added, false iff no change was made
    */
  public boolean add(T x) {
    if (isEmpty()) {
      ANCHOR.left = new BSNode<T>(x);
      return true;
    }
    BSNode<T> u = splay(x,ANCHOR.left);
    if (x==u.data) {
      ANCHOR.left = u;
      return false;
    }
    else if (compare(x,u.data) < 0)
      ANCHOR.left = new BSNode<T>(new BSNode<T>(u.left,x,null),u.data,u.right);
    else 
      ANCHOR.left = new BSNode<T>(u.left,u.data,new BSNode<T>(null,x,u.right));   
    return true;
  }
  
  //////////////////////////////////////////////////////////////////////
  /** Deletes the key x from the tree
    * @param x the key to be deleted
    * @return true iff key was deleted, false iff no change was made
    */
  public boolean delete(T x) {
    if (isEmpty()) return false;
    BSNode<T> u = splay(x,ANCHOR.left);
    
    // TODO
    int c = x.compareTo(u.data); // comparison variable
    if(c==0) {
      if(u.left == null) {
        u = u.right; // make parent node u.right
      } else {
        BSNode<T> n = u.right; // Node n
        u = u.left; // make parent node u.left
        splay(x); //splay on x
        u.right = n; //make right child node n
      }
      return true; // since key was deleted
    }
    return false; // default case, where key was not deleted
  }

  //////////////////////////////////////////////////////////////////////
  /** Joins two trees rooted at u and v into new BST, iff all values in
    * u's tree are less than ll of the values in v's tree
    * @param u tree rooted at u
    * @param v tree rooted at v
    * @return new BST after joining u and v
    */
  public BSNode<T> join(BSNode<T> u, BSNode<T> v) {
    if (u==null) return v;
    if (v==null) return u;
    BSNode<T> w = u;  while (w.right != null) w = w.right;
    // now w.data is the maximum value in u
    
    // TODO, needs updating
    /** Pseudocode
      * splay(w);
      * w.right = v; OR ANCHOR.left = v;
      */

    return new BSNode<T>(w.left, w.data, w.right);
  }
  
  //////////////////////////////////////////////////////////////////////
  /** Print the tree */
  private void show() { 
    if (ANCHOR.left==null) System.out.println("--");
    else ANCHOR.left.show(0);
  }
  
  //////////////////////////////////////////////////////////////////////
  private static Splaytree<Character> make(String str) {
    Splaytree<Character> ans = new Splaytree<Character>();
    for(char c : str.toCharArray()) ans.add(c);
    return ans;
  }
  
  //////////////////////////////////////////////////////////////////////
  // Tests of the Splaytree class
  public static void main(String[] argv) {

    // abcdefghijklmnopqrstuvwxyz

    Splaytree<Character> t1 = new Splaytree<Character>();  
        
    // Zig demo
    t1 = make("mno");
    System.out.println("Zig demonstration, before:");
    t1.show();
    System.out.println("-------------------------------");
    System.out.println("After splaying on 'o':");
    t1.splay('o');
    t1.show();
    System.out.println("-------------------------------");
    
    // Zag demo
    t1 = make("pqr");
    System.out.println("Zag demonstration, before:");
    t1.show();
    System.out.println("-------------------------------");
    System.out.println("After splaying on 'p':");
    t1.splay('r');
    t1.show();
    System.out.println("-------------------------------");
    
    // YOUR OUTPUT SHOULD LOOK LIKE:
    //-------------------------------
    // Zag demonstration, before:
    //       --
    //    r
    //       --
    // q
    //       --
    //    p
    //       --
    //-------------------------------
    //After splaying on 'r':
    //    --
    // r
    //       --
    //    q
    //          --
    //       p
    //          --
    //-------------------------------
    
    System.out.println("-------------------------------");    

    // Zagzag demo
    t1 = make("zyxw");
    System.out.println("Zagzag demonstration, before:");
    t1.show();
    System.out.println("-------------------------------");
    System.out.println("After splaying on 'z':");
    t1.splay('z');
    t1.show();
    System.out.println("-------------------------------");
    System.out.println("-------------------------------");
    
    // YOUR OUTPUT SHOULD LOOK LIKE:    
    // -------------------------------
    // Zagzag demonstration, before:
    //          --
    //       z
    //          --
    //    y
    //       --
    // x
    //       --
    //    w
    //       --
    // -------------------------------
    // After splaying on 'z':
    //    --
    // z
    //       --
    //    y
    //          --
    //       x
    //             --
    //          w
    //             --
    // -------------------------------  

    // Zigzig demo
    t1 = make("zyxw");
    System.out.println("Zigzig demonstration, before:");
    t1.show();
    System.out.println("-------------------------------");
    System.out.println("After splaying on 'w':");
    t1.splay('w');
    t1.show();
    System.out.println("-------------------------------");
    System.out.println("-------------------------------");  
    
    // Zigzag demo
    t1 = make("54321");
    System.out.println("Zigzag demonstration, before:");
    t1.show();
    System.out.println("-------------------------------");
    System.out.println("After splaying on '4' and '1' ");
    t1.splay('4');
    t1.splay('1');
    t1.show();
    System.out.println("-------------------------------");
    System.out.println("-------------------------------");  

    // Zagzig demo
    t1 = make("987654321");
    System.out.println("Zagzig demonstration, before:");
    t1.show();
    System.out.println("-------------------------------");
    System.out.println("After splaying on '9':");
    t1.splay('9');
    t1.show();
    System.out.println("-------------------------------");
    System.out.println("-------------------------------");

    
   // OTHER TESTS

   // delete demo
   t1 = make("54321");
   System.out.println("Delete demonstration, before:");
   t1.show();
   System.out.println("-------------------------------");
   System.out.println("After deleting '1':");
   t1.splay('3');
   t1.delete('1');
   t1.show();
   System.out.println("-------------------------------");
   System.out.println("-------------------------------");

   // join demo
   // cannot test, could not get method working
   t1 = make("54321");
   System.out.println("Join demonstration, before:");
   t1.show();
   System.out.println("-------------------------------");
   System.out.println("After joining '1' and '2' :");
   // t1.join('1', '2');
   t1.show();
   System.out.println("-------------------------------");
   System.out.println("-------------------------------");
  }
}