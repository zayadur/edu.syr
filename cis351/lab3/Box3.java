/************************************** \
|   Box3 class with timestamp() method  |
|   @ author                            |
|     Zayadur Khan                      |
|   @ version                           |
|     092216                            |
\***************************************/

import java.util.Date;

public class Box3 {
    public int value;
    
    public Box3()          { value = 0;    }
    public void set(int v) { value = v;    }
    public int get()       { return value; }
    
    public static Date timestamp() { 
      Date dt = new Date();
      int value = 1;
      if(value != 0) {
        dt = new Date();
        value = 0;
      }
      return dt;
      
    }
}
