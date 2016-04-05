import java.util.Random;

/**
   This class contains utility methods for array manipulation.
*/  
public class ArrayUtil
{ 
   private static Random generator = new Random();
   
   //The entire alphabet in both lower and upper case
   private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTSTUVWXYZ";

   /**
      Creates an array filled with random values.
      @param length the length of the array
      @param n the number of possible random values
      @return an array filled with length numbers between
      0 and n - 1
   */
   public static int[] randomIntArray(int length, int n)
   {  
      int[] a = new int[length];      
      for (int i = 0; i < a.length; i++)
      {
         a[i] = generator.nextInt(n);
      }
      
      return a;
   }

   /**
      Swaps two entries of an array.
      @param a the array
      @param i the first position to swap
      @param j the second position to swap
   */
   public static void swap(int[] a, int i, int j)
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
   
   /**
    * Builds an array of size length, filled with random strings made using the randomString method
    */
   public static String[] randomStringArray(int length, int numChars)
   {
      String[] stringArray = new String[length];
      
      for (int i = 0; i < length; i++)
      {
          stringArray[i] = randomString(numChars);
      }
      
      return stringArray;
   }
   
   /**
    * Creates a random string using the ALPHABET and the length of each string
    */
   public static String randomString(int numChars)
   {
       String newStr = "";
       
       for (int i = 0; i < numChars; i++)
       {
           int nextIndex = (int)(Math.random()*ALPHABET.length()); 
           String nextChar = Character.toString(ALPHABET.charAt(nextIndex)); //Get the random char from the alphabet
           newStr += nextChar;
       }
       
       return newStr;
   }
}
      
