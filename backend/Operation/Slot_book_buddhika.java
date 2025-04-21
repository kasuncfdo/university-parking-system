
    System.out.print("Enter Slot ID to book: ");
    String bookSlotID = scn.nextLine().trim();

    if (bookSlotID.isEmpty()) {
        System.out.print("Please enter a valid Slot ID: ");
        bookSlotID = scn.nextLine().trim();
    }

    File inputFile = new File(Slotfile);
    File tempFile = new File("TempSlotBooking.txt");

    boolean slotFound = false;
    boolean successfullyBooked = false;
    boolean alreadyBooked = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String[] parts = currentLine.split(",", 4);

            if (parts.length < 4) {
                writer.println(currentLine);
                continue;
            }

            String idFromFile = parts[0];
            String statusFromFile = parts[3];

            if (idFromFile.equalsIgnoreCase(bookSlotID)) {
                slotFound = true;
                if ("Available".equalsIgnoreCase(statusFromFile)) {
                    String updatedLine = parts[0] + "," + parts[1] + "," + parts[2] + ",Booked";
                    writer.println(updatedLine);
                    successfullyBooked = true;
                } else {
                    writer.println(currentLine);
                    alreadyBooked = true;
                }
            } else {
                writer.println(currentLine);
            }
        }
    } catch (FileNotFoundException e) {
        System.err.println("Input slot file not found: " + Slotfile);
        break;
    } catch (IOException e) {
        System.err.println("Error while processing slot file: " + e.getMessage());
        if (tempFile.exists()) {
            tempFile.delete();
        }
        break;
    }

    if (inputFile.exists()) {
        if (!inputFile.delete()) {
            System.err.println("Error while deleting original file");
             if (tempFile.exists()) {
                tempFile.delete();
            }
        } else {
            if (!tempFile.renameTo(inputFile)) {
                System.err.println("Error while renaming temporary file.");
                System.err.println("Please check for " + tempFile.getName() );
            } else {
                 if (successfullyBooked) {
                    System.out.println("Slot '" + bookSlotID + "' booked successfully.");
                 } else if (alreadyBooked) {
                    System.out.println("Info: Slot '" + bookSlotID + "' was already booked.");
                 } else if (slotFound) {
                 } else {
                    System.out.println("Error: Slot ID '" + bookSlotID + "' not found in the file.");
                 }
            }
        }
    } else if (slotFound || successfullyBooked || alreadyBooked) {
         System.err.println("Error: Original file missing");
         if (tempFile.exists()) {
             System.err.println("Processed data might be in " + tempFile.getName());
         }
    } else {
         if (!slotFound && inputFile.exists()) { 
             System.out.println("Error: Slot ID '" + bookSlotID + "' not found in the file.");
         }
         if (tempFile.exists()) {
             tempFile.delete();
         }
    }

    break;
