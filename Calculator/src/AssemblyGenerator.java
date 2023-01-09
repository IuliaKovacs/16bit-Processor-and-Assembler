import java.io.*;

public class AssemblyGenerator {
    public static void oneNumberOperation(String fileToModify, String destinationName, String oldString1, String newString1)
    {
        File fileToBeModified = new File(fileToModify);

        File destinationFile = new File(destinationName + ".asm");

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString1 with newString1 in the oldContent

            String newContent = oldContent.replaceAll(oldString1, newString1);

            //Rewriting the input text file with newContent

            writer = new FileWriter(destinationFile);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void twoNumberOperation(String fileToModify, String destinationName, String oldString1, String newString1, String oldString2, String newString2)
    {
        File fileToBeModified = new File(fileToModify);

        File destinationFile = new File(destinationName + ".asm");

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString1 with newString1 in the oldContent

            String newContent = oldContent.replaceAll(oldString1, newString1);

            newContent = newContent.replaceAll(oldString2, newString2);

            //Rewriting the input text file with newContent

            writer = new FileWriter(destinationFile);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args)
    {
        oneNumberOperation("src\\putere.txt", "newOneOperation","@A", "10");

        twoNumberOperation("src\\putere.txt", "newTwoOperation","@A", "10", "@B", "20");


        System.out.println("done");
    }
}
