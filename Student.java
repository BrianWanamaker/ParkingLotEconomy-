import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
            file = new File("ParkingLotEconomy-/Brian.txt");
        }
        //Aamnah     
        else if(ID.equals("567890"))
        {
            file = new File("ParkingLotEconomy-/Aamnah.txt");
        }
        //Phill     
        else if(ID.equals("654321"))
        {
            file = new File("ParkingLotEconomy-/Phill.txt");
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
    //Sets money on the users account 
    public static void setMoney(int balance) { 
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            PrintWriter writer = new PrintWriter("temp.txt", "UTF-8");
            while (line != null) {
                if(line.equals(money)) {
                    writer.println(balance);
                }
                else {
                    writer.println(line);
                }
                line = reader.readLine();
            }
            writer.close();
            reader.close();
        }
        catch (Exception e) { 
            e.printStackTrace();
        } 
        replaceFile();
        money = Integer.toString(balance);
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

    //Replace the users file with the temp file
    public static void replaceFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("temp.txt"));
            String line = reader.readLine();
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            while (line != null) {
                writer.println(line);
                line = reader.readLine();
            }
            writer.close();
            reader.close();
        }
        catch (Exception e) { 
            e.printStackTrace();
        }
    }

}
