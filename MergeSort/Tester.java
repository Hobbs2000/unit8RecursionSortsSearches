import java.util.Arrays;

/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester
{
    
    
    public static void main(String[] args)
    {
        String[] spaces = new String[]{
            "Bob",
            null,
            "Jeff",
            "Jerry",
            null,
            null,
            "Dave"};
            
        System.out.println(Arrays.toString(spaces));
        
        String[] newSpaces = sort(spaces);
        System.out.println(Arrays.toString(newSpaces));
        
        
        
        int[] ints = new int[] {10, 8, 6, 5, 3, 4, 1, 2, 9, 7};
        
        ints = BubbleSort.bubbleSortIntArrayDescending(ints);
        System.out.println(Arrays.toString(ints));
        
        ints = BubbleSort.bubbleSortIntArrayAscending(ints);
        System.out.println(Arrays.toString(ints));
       
    }
    
    public static String[] sort(String[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int i2 = i;
            while ((array[i] == null) && (i2 < array.length))
            {
                if (array[i2] != null)
                {
                    array[i] = array[i2];
                    array[i2] = null;
                    break;
                }
                i2++;
            }
        }
        return array;
    }

}
