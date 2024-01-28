package util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    // Read an integer from the user
    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine(); // Consume the invalid input
        }
        int userInput = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return userInput;
    }

    // Read a double from the user
    public static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid double.");
            scanner.nextLine(); // Consume the invalid input
        }
        double userInput = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        return userInput;
    }

    // Read a string from the user
    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}

