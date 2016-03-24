import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class NewBabyNames
{
    public static void main(String[] args)
    {
        //Get user input
        Scanner userIn =  new Scanner(System.in);
        System.out.println("Name of file: ");
        String path = userIn.next();
        
        int half = 0;
        int rank = 0;
        
        try
        {
            File file = new File(path+".txt");
            
            Scanner lineIn = new Scanner(file);
            
            //Get the number of ranks 
            lineIn.useDelimiter("\\n"); 
            int totalRankings = 0;
            while (lineIn.hasNext())
            {
                lineIn.next();
                totalRankings++;
            }
            half = totalRankings / 2; //Will only go through the top 50% of names
            
            //Reset the line scanner
            lineIn = new Scanner(file);
            lineIn.useDelimiter("\\n");
            
            while (lineIn.hasNext() && rank < half)
            {
                Scanner wordIn = new Scanner(lineIn.next()); //Make word scanner for the line
                while (wordIn.hasNext())
                {
                    rank = Integer.parseInt(wordIn.next());
                    String male = wordIn.next();
                    String maleAmount = wordIn.next();
                    String female = wordIn.next();
                    String femaleAmount = wordIn.next();
                    
                    System.out.println(rank+" "+male+" "+maleAmount+" "+female+" "+femaleAmount);
                }
            }
            
        }
        catch(FileNotFoundException e)
        {
            System.err.println("File could not be found or does not exist!");
        }
    }
}