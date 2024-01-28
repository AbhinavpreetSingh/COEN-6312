import service.InventoryService;
import util.InputUtil;

import java.util.Scanner;

public class InventoryManagementSystem {

    public static void mainMenu() {
        InventoryService inventoryService = new InventoryService();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            // Display menu options
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Inventory");
            System.out.println("4. Update Item");
            System.out.println("5. Display Transactions");
            System.out.println("6. Sell Items");
            System.out.println("7. Display Buyers");
            System.out.println("8. Exit");

            // Get user choice using InputUtil
            choice = InputUtil.readInt("Enter your choice: ");

            // Perform actions based on user choice
            switch (choice) {
                case 1:
                    // Add Item
                    inventoryService.addItem();
                    break;
                case 2:
                    // Remove Item
                    inventoryService.removeItem();
                    break;
                case 3:
                    // Display Inventory
                    inventoryService.displayInventory();
                    break;
                case 4:
                    // Update Item
                    inventoryService.updateItem();
                    break;
                case 5:
                    // Display Transactions
                    inventoryService.displayTransactions();
                    break;
                case 6:
                    inventoryService.sellItems();
                    break;
                case 7:
                    inventoryService.displayCustomers();
                    break;
                case 8:
                    System.out.println("Exiting the Inventory Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 8);

        scanner.close();
    }

    public static void main(String[] args) {
        // Call the mainMenu method to start the inventory management system
        mainMenu();
    }
}
