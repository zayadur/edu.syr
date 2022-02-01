/*******************
  * ECS-102, HW3
  * Library.java
  * By Zayadur Khan
  * ****************/

import java.util.Scanner;

public class Library
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    String name;
    String libraryName;
    int books;
    int movedBooks;
    //String title;
    
    System.out.println("Welcome to the library manager software!");
    System.out.print("Please enter your name: ");
    name = input.nextLine();
    System.out.print("What is the name of your library? : ");
    libraryName = input.nextLine();
    System.out.print("How many books are there in " + libraryName + "? : ");
    books = input.nextInt();
    System.out.print("How many books have already been relocated? : ");
    movedBooks = input.nextInt();
    input.nextLine(); //refreshes input instance
    System.out.print("What is the title of the last book you moved? : ");
    String title = input.nextLine();
    
    System.out.print("Librarian " + name + ". With the relocation of " + title + 
                     " \nto the " + title.charAt(0) + " section of the library, you have moved " + movedBooks +
                     " \nbooks! Congratulations, only " + (books - movedBooks) + " books left to move!");
  }
}