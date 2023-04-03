import java.util.Scanner;

public class main {
    
    public static void main(String[]args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the QU Parking Economy!");

        System.out.print("Please enter QU ID: ");
        String ID = in.nextLine();
        Student student = new Student(ID);

 // loops until valid QU ID is entered (Brian = 123456, Phill = 654321,Aamnah = 567890)
        while(student.getFile()==null)
        {
            System.out.println();
            System.out.println("QU ID does not exist! Please Try again.");
            System.out.print("Please enter QU ID: ");
            ID = in.nextLine();
            student = new Student(ID);
        }
 // initalize student   
        student.setStudent();

        System.out.println();
        System.out.println(student);
    }
}
