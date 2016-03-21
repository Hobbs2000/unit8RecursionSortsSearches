import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileWordCount
{
    public static Scanner userIn = new Scanner(System.in);
    public static Scanner fileIn;
    
    public static void main(String[] args)
    {
        System.out.print("Enter the name of the text file: ");
        String filePath = userIn.next();
        
        try
        {
            File file = new File(filePath+".txt");
            fileIn = new Scanner(file);
            
            int count = 0;
            
            System.out.println("Text read from document:");
            while (fileIn.hasNext())
            {
                count++;
                System.out.print(fileIn.next()+" ");
            }
            System.out.println("\nThere are "+count+" words in that document");
            
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File named: "+filePath+", does not exist or cannot be found");
        }
        finally
        {
            fileIn.close();
        }
    }
}