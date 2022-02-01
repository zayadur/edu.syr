/* pictureprocessor.java */
import java.io.*;
import java.util.*;

public class PictureProcessor 
{
  public static void main(String[] args) throws IOException
  {
    int numrows, numcols;  
    //the number of rows and columns in the
    //picture,  measured in pixels: 
    //"picture elements" 
    
    int r,      //row index
      c;      //column index
    int[][] raw=new int[350][250];  // 2-D array of raw picture data 
    char[][] pic=new char[350][250];// 2-D array of character picture 
    //In a 2-D array, the first index is the row,
    //and the second index is the column.
//INPUT    
//set up a scanner to read from the input file.
    Scanner fileIn = new Scanner ( new File("picture1.txt"));
    
//OUTPUT
    // Output File
    FileWriter fw = new FileWriter ("picture1out.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter fileOut = new PrintWriter (bw);
    
    //Read the number of rows and columns
    numcols=fileIn.nextInt();
    numrows=fileIn.nextInt();
    //We can still print to the console window
    System.out.println("number of rows " + numrows + 
                       "\nnumber of columns " + numcols);
    
//    To read in the picture data, we will read across the first row,
//    one column (number) at a time,
//    then across the second row,
//    and so on, for the correct number of rows.  
    for (r=0; r<numrows; r++)
    {
      for (c=0; c<numcols; c++)
        raw[r][c]=fileIn.nextInt();
    }
    
//     The picture is in gray scale, with 0 representing white
//     and 255 representing black.  
//     We will convert it to black and white, first evenly,
//     that is, anything below or equal to 255/2 will be 
//     white and anything above will be black.
//     The character ' ' (a space) will be white, and
//     the character 'M' will be black.
    
//    Here we are NOT printing the picture to a file,
//    just setting up the array with the picture.
    
    for (r=0; r<numrows; r++)
    {
      for (c=0; c<numcols; c++)
      {
        if (raw[r][c]>420/2) //threshold modified to 210
          pic[r][c]='M';
        else 
          pic[r][c]='.'; //changed character to '.' for definition
      }  // end for c 
    }  // end for r 
    
//       Print the picture, one row at a time,
//       going column to column,
//       printing to file characters, 
//       not separated by spaces,
//       but with a newline at the end of each row.
    
    for (r=0; r<numrows; r++)
    {
      for (c=0; c<numcols; c++)
      {
        fileOut.print(pic[r][c]);
        fileOut.print(pic[r][c]);
      }
      fileOut.println();
    }
    
    // Housekeeping.  Close the output file. 
    fileOut.close(); 
  }
}
