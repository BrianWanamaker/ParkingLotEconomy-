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
            case 1: 
                System.out.println("Reservations"); 
                break;
            //Displays the users funds
            case 2: 
                System.out.println("Funds: " + Student.getMoney());
                break;
            case 3: 
                System.out.println("New Reservation");
                break;
            //Logs user out and closes the application
            case 4: 
                System.out.println("You Have Been Logged Out!");
                System.exit(0);
                break;
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
}
