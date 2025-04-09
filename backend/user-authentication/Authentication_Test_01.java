//AI Genarate කිව්වොත් කොටනවා සනික

import java.util.Scanner;
public class Test {
public static void main(String[] args) {
String Username = "user123";
String Password = "password123";

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter username: ");
    String username = scanner.nextLine();

    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    if (username.equals(Username) && password.equals(Password)) {
        System.out.println("Authentication successful ! Welcome.");
    } else {
        System.out.println("Authentication failed! Please check again.");
    }

    scanner.close();
}
}