
    import java.util.Scanner;
public class twst {



    public static void main(String[] args) {
        // Create a single Scanner instance for input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an integer (or 0 to exit): ");

            // Read an integer from the user using the same scanner
            int userInput = scanner.nextInt();

            // Check if the user wants to exit
            if (userInput == 0) {
                System.out.println("Exiting...");
                break; // Exit the loop
            }

            // Process the user input (you can perform any desired operations here)
            System.out.println("You entered: " + userInput);

            // Consume the newline character left in the input stream
            scanner.nextLine();
        }

        // Close the scanner when done to release resources
        scanner.close();
    }
}

