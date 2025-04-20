
import java.util.Scanner;

public class login{

    static void showloginmenu(){
        System.out.println("1.Admin");
        System.out.println("2.User");
    }


    static void adminMainMenu() {
        System.out.println("1.Add Parking Slots");
        System.out.println("2.Remove Parking Slots");
        System.out.println("3. View Available Slots");
        System.out.println("4. Book a Slot");
        System.out.println("5. Cancel a Booking");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");

    }

    static void userMainMenu() {
        System.out.println("1. View Available Slots");
        System.out.println("2. Book a Slot");
        System.out.println("3. Cancel a Booking");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");

    }

    public static void main(String[]args){

        Scanner scn=new Scanner(System.in);

        showloginmenu();
        int logmenu=scn.nextInt();


        if(logmenu==1){

            adminMainMenu();


        }
        else {
            userMainMenu();
        }


    }
}
