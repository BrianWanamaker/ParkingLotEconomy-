import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class main {
    
    public static void main(String[]args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the QU Parking Economy!");

        System.out.print("Please enter QU ID: ");
        String ID = in.nextLine();
        Student student = new Student(ID);

        //loops until valid QU ID is entered (Brian = 123456, Phill = 654321,Aamnah = 567890)
        while(student.getFile()==null)
        {
            System.out.println();
            System.out.println("QU ID does not exist! Please Try again.");
            System.out.print("Please enter QU ID: ");
            ID = in.nextLine();
            student = new Student(ID);
        }
        //initalize student   
        student.setStudent();

        //boolean var to loop back to login
        boolean rerun = true;

        while(rerun == true)        
        {
            //Display menu and select an option 
            displayMenu();
            int input = in.nextInt();
            
            //If the input is not an option return an error and request a new response
            while(input < 1 || input > 4) {
                System.out.println("\nInput Error. Enter a Valid Integer!");
                displayMenu();
                input = in.nextInt();
            }

            //Show choice
            switch (input) { 
                //Show the users reservations
                case 1: 
                    System.out.println("Reservations:"); 
                    Student.showReservations(); 
                    break;
                //Displays the users funds
                case 2: 
                    System.out.println("Funds: " + Student.getMoney());
                    break;
                case 3: 
                    System.out.println("New Reservation"); 
                    makeReservation(student);
                    break;
                //Logs user out and closes the application
                case 4: 
                    System.out.println("You Have Been Logged Out!");
                    System.exit(0);
                    rerun = false;
                    break;
            }
        }

        //Close Scanner Object
        in.close();
    } 

    //Display the menu options
    public static void displayMenu() {
        System.out.println("\nPlease Select a Menu Option:");
        System.out.println("1. Show Reservations");
        System.out.println("2. Show Funds");
        System.out.println("3. Make Reservations");
        System.out.println("4. Log Out\n"); 
    } 

    //Makes a reservation
    public static void makeReservation(Student student) {
        System.out.println("Please Select a Space by Entering its Letter");
        File spaces = new File("ParkingLotEconomy-/Spaces.txt"); 
        //Display all of the spaces
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ParkingLotEconomy-/Spaces.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (Exception e) { 
            e.printStackTrace();
        }

        //Take space selection and add it to the users reservation
        Scanner input = new Scanner(System.in);
        int cost = 0; 
        int funds = Integer.parseInt(student.getMoney());
        String space = input.nextLine();
        space = space.toUpperCase(); 
        System.out.println(space);
        //Set the cost depending on the space selected
        if(space.equals("A") || space.equals("B") || space.equals("C") || space.equals("D") || space.equals("E")) {
            cost = 10;
        } 
        else if (space.equals("F") || space.equals("G") || space.equals("H") || space.equals("I") || space.equals("J")) {
            cost = 5;
        } 
        else if (space.equals("K") || space.equals("L") || space.equals("M") || space.equals("N") || space.equals("O")) {
            cost = 1;
        } 
        else if (space.equals("P") || space.equals("Q") || space.equals("R") || space.equals("S") || space.equals("T")) {
            cost = -1;
        }
        else if (space.equals("U") || space.equals("V") || space.equals("W") || space.equals("X") || space.equals("Y") || space.equals("Z")) {
            cost = -5;
        } 
        else {
            System.out.println("Invalid Selection");
            makeReservation(student);
        }
        //If the user does not have enough money make them make anouther selection 
        if(funds < cost) {
            System.out.println("Insuffient Funds");
            makeReservation(student);
        } 
        //Otherwise add the reservation and decrease the users money
        else {
            Student.addReservation(space);
            Student.setMoney(funds-cost);
        } 
    }
}
