//Sorting.java
public class Sorting
{
  //Sort an array of integers using selection sort
  public static void intSort(int[] list)
  {
    int min;  //index of smallest element
    int temp;  //for swapping
    
    for (int index=0; index<list.length-1; index++)
    {
      min = index;
      for (int j=index+1; j<list.length; j++)
        if (list[j]<list[min])
          min = j;
      
      //swap the values
      temp = list[min];
      list[min] = list[index];
      list[index] = temp;
    } // end for index
  } // end intSort
  

  //sort an array of any class implementing Comparable
  public static void ComparableSort(Comparable[] list)
  {
    int min;  //index of smallest element
    Comparable temp;  //for swapping
    
    for (int index=0; index<list.length-1; index++)
    {
      min = index;
      for (int j=index+1; j<list.length; j++)
      if (list[j].compareTo(list[min]) < 0)
          min = j;
      
      //swap the values
      temp = list[min];
      list[min] = list[index];
      list[index] = temp;
    } // end for index
  } // end ComparableSort
  
} //end Sorting class
