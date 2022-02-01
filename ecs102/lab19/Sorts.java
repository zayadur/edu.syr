import java.io.*;
import java.util.*;

// Sorts
public class Sorts
{
  public static void main(String[] arg) throws IOException
  {
//    /* create a list to experiment on */
//    char[] list={'b','z','g','w','v','h','i','k','d','e'};
//    
//    /* print the unsorted array */
//    for (int i=0; i<list.length; i++)
//      System.out.print(list[i]+"  ");
//    System.out.println();
//    
//    // sort the array using one of the sorts 
//    select_sort(list);
    
//    //bubblesort the letters of your name here.
//    char[] name = {'z', 'a', 'y', 'a', 'd', 'u', 'r'};
//    char temp;
//    boolean flag = true;
//    while(flag)
//    {
//      flag = false;
//      for(int i = 0; i < name.length-1; i++)
//      {
//        if(name[i] < name[i+1])
//        {
//          temp = name[i];
//          name[i] = name[i+1];
//          name[i+1] = temp;
//          flag = true;
//        }
//      }
//    }

//    /* print the sorted array */
//    for (int i=0; i<list.length; i++)
//      System.out.print(list[i]+"  ");
//    System.out.println();
    
//    /* print the sorted array of your name*/
//    for (int i=0; i<name.length; i++)
//      System.out.print(name[i]+"  ");
//    System.out.println();
//    
//    /* shuffle and print here */
//    select_sort(name);
//    
//    shuffle(list);
    
//Part II
//    char[] list={'a', 'b', 'c', 'd', 'e', 'f', 'g'};
//    
//    shuffle(list);
//    for (int i = 0; i < list.length; i++)
//    {
//      System.out.print(list[i] + " ");
//    }
//    System.out.println();
//  }

//Part III a
    
    Scanner file = new Scanner(new File("sortdata.txt")); //also used in part III c
    int i = 0;
    while (file.hasNext())
    {
      String listChar[] = new String[6];
      int listInt[] = new int[6];
      double listDouble[] = new double[6];
      
      listChar[i] = file.next();
      listInt[i] = file.nextInt();
      listDouble[i] = file.nextDouble();
//      
//      for (i = 0; i < listChar.length; i++)
//      {
//        System.out.print(listDouble[i]);
//        System.out.print("\t" + listInt[i]);
//        System.out.println("\t" + listChar[i]);
//      }
      //parallel_sort(listDouble, listInt, listChar);
    }
  }
  
//*********< bubblesort >***********
// sort the array list into increasing order 
  public static void bubblesort(char[] list)
  {
    int startIndex; // subscript of first 
    //element of unsorted array
    int i;  // index of first element in 
    // pair being compared 
    
    //for unsorted subarray, start with whole array, through
    //last case of two elements left
    for (startIndex = 0;startIndex<=list.length-2; startIndex++)
    {
      //for each pair of unsorted array
      for (i=list.length-2; i>startIndex; i--)
        if (list[i]>list[i+1])  //if out of order
        //swap these two elements
      { 
        char temp;
        temp = list[i];
        list[i]=list[i+1];
        list[i+1]=temp;
      } // end swap
      // end for i
    }  // end for startIndex
  }  //end bubblesort
  
//*********< select_sort >************
// sort the array list into increasing order 
  public static void select_sort (char[ ] list)// list to be sorted 
  {
    int min;   //index of smallest element of sublist
    char temp; //for swapping
    for (int startIndex=0; startIndex < list.length; startIndex++)
    {
      min=startIndex;
      
      for (int i=startIndex+1; i<list.length; i++)
        if (list[i]<list[min])
        min=i;
      
      //swap the values
      temp=list[min];
      list[min]=list[startIndex];
      list[startIndex]=temp;
    }//end for startIndex  
  } // end select_sort
  
  public static void shuffle(char[ ] list)
  {
    
    Random rnd = new Random();
    for (int i = list.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      char a = list[index];
      list[index] = list[i];
      list[i] = a;
    }
  }
  
  //*********< parallel_sort >************
  public static void parallel_sort(double[] listDouble, int[] listInt, char[] listChar) 
  { 
    int min;   //index of smallest element of sublist 
    char temp; //for swapping 
    for (int startIndex=0; startIndex < listChar.length; startIndex++)  
    { 
      min=startIndex; 
      
      for (int i=startIndex+1; i<listChar.length; i++) 
        if (listChar[i]<listChar[min]) 
        min=i; 
      //end of select_sort for character 
      
      int minInt;   //index of smallest element of sublist 
      int tempInt; //for swapping 
      for (int indexInt=0; indexInt < listInt.length; indexInt++) 
      { 
        min=startIndex; 
        
        for (int i=startIndex+1; i<listInt.length; i++) 
          if (listInt[i]<listInt[min]) 
          min=i; 
        
        //swap the values 
        tempInt=listInt[min]; 
        listInt[min]=listInt[startIndex]; 
        listInt[startIndex]=tempInt; 
        
        //end of select_sort for int    
        
        int minDouble;   //index of smallest element of sublist 
        double tempDouble; //for swapping 
        for (int indexDouble=0; indexDouble < listDouble.length; indexDouble++) 
        { 
          min=startIndex; 
          
          for (int i=startIndex+1; i<listDouble.length; i++) 
            if (listDouble[i]<listDouble[min]) 
            min=i; 
          
          //swap the values 
          tempDouble=listDouble[min]; 
          listDouble[min]=listDouble[startIndex]; 
          listDouble[startIndex]=tempDouble; 
        } 
      } 
    } 
  }
  
} //end class Sorts

/* OUTPUT of shuffle
> run Sorts
a e d g b c f  
> */

/* OUTPUT of part III
> run Sorts
9.25 33 A
1.123 92 V
2.4 100 H
10.45 98 B
-2.2 98 K
0.0 0 null
> */

/* OUTPUT of parallel_sort
> run Sorts
A 33 -2.2  
B 92 1.123  
H 98 2.4  
K 98 9.25  
V 100 10.45 

-2.2 33 A  
1.123 92 B  
2.4 98 H  
9.25 98 K  
10.45 100 V  
> */