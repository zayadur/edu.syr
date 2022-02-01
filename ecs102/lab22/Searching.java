//Searching
public class Searching{
  
  public static int binarySearch(Comparable[] list,
                                        Comparable target)
  {
    int min=0, max=list.length-1, mid=0, i=0;
    boolean found = false;
    
    while (!found && min <= max)
    {
      if (list[i].compareTo(mid) < 0)
      {
        max = i - 1;
      }
      else
      {
        min = i + 1;
      }
      i = (min+max) / 2;
    }
    
    if (found)
      return mid;
    else
      return -1;
    
  } // end binarySearch
} //end Searching
