import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Student {

    private String ID;
    private String name;
    private static String money;   
    private Scanner reader;
    private File file;
    
    public Student(String ID)
    {
        this.ID = ID;
        setFile();
    }
    
    //initalize file depending on which student  
    public void setFile()
    {
  //hard coded IDs

        //Brian       
        if(ID.equals("123456"))
        {
            file = new File("Brian.txt");
        }
        //Aamnah     
        else if(ID.equals("567890"))
        {
            file = new File("Aamnah.txt");
        }
        //Phill     
        else if(ID.equals("654321"))
        {
            file = new File("Phill.txt");
        }
        else
        {
            file = null;
        }
    }

    //initalize student
    public void setStudent()
    {
        try 
        {
            reader = new Scanner(file);
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        //set variables from file
        if(ID.equals(reader.nextLine()))
         {
            name = reader.nextLine();
            money = reader.nextLine();
         }     
    }

    public String getName() 
    {
        return name;
    }
    public static String getMoney() 
    {
        return money;
    }   
    public File getFile() 
    {
        return file;
    }
    public String toString()
    {
        return ID + "\n" + name + "\n" + "Balance: " + money;
    }
}
