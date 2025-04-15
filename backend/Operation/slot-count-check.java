import java.util.Scanner;
public class OUSL_Parking_System_Test_1 {
public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);


    System.out.println("-Welcome to the OUSL Parking System- "); // Welcome msg
    System.out.println(" Please Enter the Your ID Number... "); // Enter the code

    int Count = 10;


    int ID = scanner.nextInt();


    switch (ID) {
        case 1:
            System.out.println("Hi Dear Lecture, Your Parking Slot is ... "); // Parking Slot Identify
            System.out.println("Thank You, Have a Nice day ! ");
            int tot = Count - 0;

            System.out.println("\n");

            System.out.println("All Slot Count = 10  ");
            System.out.println("Now Available Slots = " + tot);
            break;


        case 2:
            System.out.println("Hi Dear Lecture Your Parking Slot is ... "); // Parking Slot Identify
            System.out.println("Thank You, Have a Nice day ! ");

            int tot1 = Count - 2;

            System.out.println("\n");

            System.out.println("All Slot Count = 10  ");
            System.out.println("Now Available Slots = " + tot1);
            break;
        case 3:
            System.out.println("Hi Dear Lecture Your Parking Slot is ... "); // Parking Slot Identify
            System.out.println("Thank You, Have a Nice day ! ");
            int tot2 = Count - 3;

            System.out.println("\n");

            System.out.println("All Slot Count = 10  ");
            System.out.println("Now Available Slots = " + tot2);
            break;
        case 4:
            System.out.println("Hi Dear Lecture Your Parking Slot is ... "); // Parking Slot Identify
            System.out.println("Thank You, Have a Nice day ! ");
            int tot3 = Count - 4;

            System.out.println("\n");

            System.out.println("All Slot Count = 10  ");
            System.out.println("Now Available Slots = " + tot3);
            break;
        case 5:
            System.out.println("Hi Dear Lecture Your Parking Slot is ... "); // Parking Slot Identify
            System.out.println("Thank You, Have a Nice day ! ");
            int tot4 = Count - 5;

            System.out.println("\n");

            System.out.println("All Slot Count = 10  ");
            System.out.println("Now Available Slots = " + tot4);
            break;
        case 6:
            System.out.println("Hi Dear Lecture \n Your Parking Slot is ... "); // Parking Slot Identify
            System.out.println("Thank You, Have a Nice day ! ");
            int tot5 = Count - 6;

            System.out.println("\n");

            System.out.println("All Slot Count = 10  ");
            System.out.println("Now Available Slots = " + tot5);
            break;
        case 7:
            System.out.println("Hi Dear Lecture  Your Parking Slot is ... "); // Parking Slot Identify
            System.out.println("Thank You, Have a Nice day ! ");
            int tot6 = Count - 7;

            System.out.println("\n");

            System.out.println("All Slot Count = 10  ");
            System.out.println("Now Available Slots = " + tot6);
            break;
        case 8:
            System.out.println("Hi Dear Lecture Your Parking Slot is ... "); // Parking Slot Identify
            System.out.println("Thank You, Have a Nice day ! ");
            int tot7 = Count - 8;

            System.out.println("\n");

            System.out.println("All Slot Count = 10  ");
            System.out.println("Now Available Slots = " + tot7);
            break;
        case 9:
            System.out.println("Hi Dear Lecture Your Parking Slot is ... "); // Parking Slot Identify
            System.out.println("Thank You, Have a Nice day ! ");
            int tot8 = Count - 9;

            System.out.println("\n");

            System.out.println("All Slot Count = 10  ");
            System.out.println("Now Available Slots = " + tot8);
            break;
        case 10:
            System.out.println("Hi Dear Lecture Your Parking Slot is ... "); // Parking Slot Identify
            System.out.println("Thank You, Have a Nice day ! ");

            System.out.println("\n");

            System.out.println("The last Slot available for you ");
            System.out.println("All Slots are Full ");

            break;
        default:
            System.out.println("Please Enter the valid ID "); // Parking Slot Identify
            System.out.println("Try Again ! ");
            break;
    }
}
}