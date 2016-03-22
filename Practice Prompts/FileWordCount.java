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
            
            fileIn = new Scanner(file);/*.useDelimiter("");/*The delimiter is either
                                                                   whitespace or a comma*/
                                                                 
            /*fileIn.useDelimiter("[^A-Za-z0-9\\s]+"); /*This classifies anything that is not
                                                      a letter, number or whitspace as a 
                                                      delimiter*/
            fileIn.useDelimiter("[.!?]+");
            
            int Wcount = 0;
            int Ccount = 0;
            
            System.out.println("Text read from document:");
            while (fileIn.hasNext())//Will loop if the scanner has more things it can read in
            {
                String text = fileIn.next(); //Read in the text
                Wcount++;                    //Add one to the total word count
                Ccount += text.length();     //Add the text length to the total char count
                System.out.print("\n"+text);
            }
            System.out.println("\nWords: "+Wcount);
            System.out.println("Chars: "+Ccount);
            
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File named: "+filePath+", does not exist or cannot be found");
        }
    }
}