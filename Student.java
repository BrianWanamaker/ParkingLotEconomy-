import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student {

    private String ID;
    private String name;
    private static String money;   
    private Scanner reader;
    private static File file;
    
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

    //Adds a reservation to the users file
    public static void addReservation(String spaceLetter) {
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Space: " + spaceLetter + " is Reserved.");
            bufferedWriter.newLine();
            bufferedWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
    } 

    //Displays users reservations
    public static void showReservations() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            boolean reservations = false;
            while (line != null) {
                if(reservations == true) {
                    System.out.println(line);
                }
                if(line.equals("Reservations:")) {
                    reservations = true;
                }
                line = reader.readLine();
            }
            reader.close();
        }
        catch (Exception e) { 
            e.printStackTrace();
        }
    }

}
