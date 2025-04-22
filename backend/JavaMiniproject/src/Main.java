import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static HashMap<String, String[]> parkingSlots = new HashMap<>();

    static void welcome() {
        System.out.println("\n \uD83D\uDE97 Welcome University Parking System project \uD83C\uDFEB \n");
        System.out.println("\n" +
                           "   ____  _    _  _____ _      \n" +
                           "  / __ \\| |  | |/ ____| |     \n" +
                           " | |  | | |  | | (___ | |     \n" +
                           " | |  | | |  | |\\___ \\| |     \n" +
                           " | |__| | |__| |____) | |____ \n" +
                           "  \\____/ \\____/|_____/|______|\n" +
                           "                              \n" +
                           "                              \n");
    }

    static void showLoginMenu() {
        System.out.println();
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("0. Exit");
        System.out.print("Enter choice :- ");
    }

    static void adminMainMenu() {
        System.out.println();
        System.out.println("1. Add Parking Slots");
        System.out.println("2. Remove Parking Slots");
        System.out.println("3. View Available Slots");
        System.out.println("4. Book a Slot");
        System.out.println("5. Cancel a Booking");
        System.out.println("0. Main menu");
        System.out.print("Enter choice :- ");
    }

    static void userMainMenu() {
        System.out.println();
        System.out.println("1. View Available Slots");
        System.out.println("2. Book a Slot");
        System.out.println("3. Cancel a Booking");
        System.out.println("0. Main menu");
        System.out.print("Enter choice :- ");
    }

    static void welcomeForAdmin() {
        System.out.println("\nWelcome Admin!\n");
    }

    static void welcomeForUser() {
        System.out.println("\nWelcome User\n");
    }

    static void viewavailableslot(){
        long availableCount = parkingSlots.values().stream()
                .filter(details -> "Available".equals(details[0]))
                .count();
        if (availableCount == 0) {
            System.out.println("No available slots.");
        } else {
            System.out.println("Available Parking Slots:");
            parkingSlots.forEach((id, details) -> {
                if ("Available".equals(details[0])) {
                    System.out.println("Slot ID: " + id + ", Faculty: " + details[1]);
                }
            });
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                welcome();
                showLoginMenu();
                int logMenu = scn.nextInt();

                switch (logMenu) {
                    case 1: // Admin
                        boolean adminExit = false;
                        welcomeForAdmin();
                        while (!adminExit) {
                            try {
                                adminMainMenu();
                                int adminChoice = scn.nextInt();

                                switch (adminChoice) {
                                    case 1: // Add Parking Slots
                                        System.out.print("Enter Slot ID: ");
                                        String slotID = scn.next();

                                        System.out.print("Enter Associated Faculty: ");
                                        String faculty = scn.next();

                                        if (!parkingSlots.containsKey(slotID)) {
                                            parkingSlots.put(slotID, new String[]{"Available", faculty});
                                            System.out.println("Slot added successfully!.");
                                        } else {
                                            System.out.println("Slot ID is already registered.");
                                        }
                                        break;

                                    case 2: // Remove Parking Slots
                                        System.out.print("Please enter the SlotID to remove: ");
                                        String removeSlotID = scn.next();

                                        if (parkingSlots.containsKey(removeSlotID)) {
                                            parkingSlots.remove(removeSlotID);
                                            System.out.println("Slot removed successfully!.");
                                        } else {
                                            System.out.println("Slot is not available right now.");
                                        }
                                        break;

                                    case 3: // View Available Slots

                                        viewavailableslot();

                                        break;

                                    case 4: // Book a Slot
                                        System.out.print("Enter Slot ID to book: ");
                                        String bookSlotID = scn.next();
                                        if (parkingSlots.containsKey(bookSlotID) && parkingSlots.get(bookSlotID)[0].equals("Available")) {
                                            parkingSlots.get(bookSlotID)[0] = "Booked";
                                            System.out.println("Slot booked successfully.");
                                        } else {
                                            System.out.println("Slot ID not found or currently filled.");
                                        }
                                        break;

                                    case 5: // Cancel Booking
                                        System.out.print("Enter Slot ID to cancel booking: ");
                                        String cancelSlotID = scn.next();
                                        if (parkingSlots.containsKey(cancelSlotID) && parkingSlots.get(cancelSlotID)[0].equals("Booked")) {
                                            parkingSlots.get(cancelSlotID)[0] = "Available";
                                            System.out.println("Booking canceled successfully.");
                                        } else {
                                            System.out.println("Slot ID not available or not booked.");
                                        }
                                        break;

                                    case 0:
                                        adminExit = true;
                                        break;

                                    default:
                                        System.out.println("Invalid choice. Try again.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a number.");
                                scn.nextLine(); // Clear invalid input
                            } catch (Exception e) {
                                System.out.println("An error occurred: " + e.getMessage());
                                scn.nextLine();
                            }
                        }
                        break;

                    case 2: // User
                        boolean userExit = false;
                        welcomeForUser();
                        while (!userExit) {
                            try {
                                userMainMenu();
                                int userChoice = scn.nextInt();

                                switch (userChoice) {
                                    case 1: // View Available Slots

                                        viewavailableslot();

                                        break;

                                    case 2: // Book a Slot
                                        System.out.print("Enter Slot ID to book: ");
                                        String bookSlotID = scn.next();
                                        if (parkingSlots.containsKey(bookSlotID) && parkingSlots.get(bookSlotID)[0].equals("Available")) {
                                            parkingSlots.get(bookSlotID)[0] = "Booked";
                                            System.out.println("Slot booked successfully.");
                                        } else {
                                            System.out.println("Slot ID not found or already booked.");
                                        }
                                        break;

                                    case 3: //Cancel booking
                                        System.out.print("Enter Slot ID to cancel booking: ");
                                        String cancelSlotID = scn.next();
                                        if (parkingSlots.containsKey(cancelSlotID) && parkingSlots.get(cancelSlotID)[0].equals("Booked")) {
                                            parkingSlots.get(cancelSlotID)[0] = "Available";
                                            System.out.println("Booking canceled successfully.");
                                        } else {
                                            System.out.println("Slot ID not found or not booked.");
                                        }
                                        break;

                                    case 0:
                                        userExit = true;
                                        break;

                                    default:
                                        System.out.println("Invalid choice. Try again.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a number.");
                                scn.nextLine();
                            } catch (Exception e) {
                                System.out.println("An error occurred: " + e.getMessage());
                                scn.nextLine();
                            }
                        }
                        break;

                    case 0:
                        exit = true;
                        System.out.println("Exiting the system. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scn.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scn.nextLine();
            }
        }

        scn.close();
    }
}










