// *****************************************************
// Encode.java
//
// This program encodes a word by shifting the letters
// a given number of spaces to the right on the alphabet
//
// Zayadur Khan, ECS-102, Lab 5
// *****************************************************

import java.util.*;

public class Encode
{
  public static void main (String[] args)
  {
    String alphabet;
    String twiceAlphabet;
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    twiceAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //System.out.println(twiceAlphabet); //twiceAlphabet test
    
    Random generator = new Random();
    int shift;
    shift = generator.nextInt(26) + 1;
    //System.out.println(shift); //shift test
    
    String word;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a 4 letter word: ");
    word = input.nextLine();
    word = word.toUpperCase();
    System.out.println(word + " shifted " + shift + " spaces: "); //word test
    
    char before = word.charAt(0);
    //System.out.println(before); //before test
    
    int index = twiceAlphabet.indexOf(before);
    //System.out.println(index); //index text
    
    int firstIndex = index + shift;
    int endIndex = index + shift + 1;
    String after = twiceAlphabet.substring(firstIndex, endIndex);
    System.out.println("FIRST LETTER: " + after); //after test
    
    //SECOND LETTER
    before = word.charAt(1);
    //System.out.println(before); //before test
    
    index = twiceAlphabet.indexOf(before);
    //System.out.println(index); //index text
    
    firstIndex = index + shift;
    endIndex = index + shift + 1;
    after = twiceAlphabet.substring(firstIndex, endIndex);
    System.out.println("SECOND LETTER: " + after); //after test
    
    //THIRD LETTER
    before = word.charAt(2);
    //System.out.println(before); //before test
    
    index = twiceAlphabet.indexOf(before);
    //System.out.println(index); //index text
    
    firstIndex = index + shift;
    endIndex = index + shift + 1;
    after = twiceAlphabet.substring(firstIndex, endIndex);
    System.out.println("THIRD LETTER: " + after); //after test
    
    //FOURTH LETTER
    before = word.charAt(3);
    //System.out.println(before); //before test
    
    index = twiceAlphabet.indexOf(before);
    //System.out.println(index); //index text
    
    firstIndex = index + shift;
    endIndex = index + shift + 1;
    after = twiceAlphabet.substring(firstIndex, endIndex);
    System.out.println("FOURTH LETTER: " + after); //after test
    
    /* Output:
     > run Encode
     Enter a 4 letter word:  lazy
     LAZY shifted 15 spaces: 
     FIRST LETTER: A
     SECOND LETTER: P
     THIRD LETTER: O
     FOURTH LETTER: N
     > */
  }
}