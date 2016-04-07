import java.util.Arrays;

public class BubbleSort
{
    public static int[] bubbleSortIntArrayDescending(int[] array)
    {
        while (BubbleSort.isSortedDescending(array) == false)
        {
            for (int i = 0; i < array.length - 1; i+=1)
            {
                if (array[i] < array[i + 1])
                {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
    
    public static int[] bubbleSortIntArrayAscending(int[] array)
    {
        while (BubbleSort.isSortedAscending(array) == false)
        {
            for (int i = 0; i < array.length - 1; i+=1)
            {
                if (array[i] > array[i + 1])
                {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
    
    
    public static boolean isSortedDescending(int[] array)

    {
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] < array[i + 1])
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isSortedAscending(int[] array)

    {
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] > array[i + 1])
            {
                return false;
            }
        }
        
        return true;
    }
    
}