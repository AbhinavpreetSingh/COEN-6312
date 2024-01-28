package service;

import model.Customer;
import model.Item;
import model.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InventoryService {

    private List<Customer> customers;
    private List<Item> inventory;
    private List<Transaction> transactions;
    private int nextItemId = 1; // Used to generate unique item IDs

    public InventoryService() {
        this.inventory = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Method to add a new item to the inventory
    public void addItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter initial quantity: ");
        int quantity = scanner.nextInt();

        // Create a new item and add it to the inventory
        Item newItem = new Item(nextItemId++, name, price, quantity);
        inventory.add(newItem);

        // Record the transaction
        transactions.add(new Transaction(newItem.getId(), quantity));

        System.out.println("Item added successfully!");
    }

    // Method to remove an item from the inventory
    public void removeItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the item to remove: ");
        int itemId = scanner.nextInt();

        // Find the item with the given ID
        Item itemToRemove = findItemById(itemId);

        if (itemToRemove != null) {
            inventory.remove(itemToRemove);
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item not found.");
        }
    }

    // Method to update the details of an existing item
    public void updateItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the item to update: ");
        int itemId = scanner.nextInt();

        // Find the item with the given ID
        Item itemToUpdate = findItemById(itemId);

        if (itemToUpdate != null) {
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();

            // Update the quantity of the item
            itemToUpdate.setQuantity(newQuantity);

            // Record the transaction
            transactions.add(new Transaction(itemToUpdate.getId(), newQuantity));

            System.out.println("Item updated successfully!");
        } else {
            System.out.println("Item not found.");
        }
    }

    // *************************************************************
    public void sellItems() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        Customer customer = findCustomerByName(customerName);
        if (customer == null) {
            customer = new Customer();
            customer.setId(customers.size() + 1); // Simple ID generation
            customer.setName(customerName);
            customer.setItem(new Item[0]);
            customers.add(customer);
        }

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        Item item = findItemByName(name);
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        if (item.getQuantity() < quantity) {
            System.out.println("Not enough quantity available.");
            return;
        }

        // Update inventory
        item.setQuantity(item.getQuantity() - quantity);

        // Record the transaction
        transactions.add(new Transaction(item.getId(), quantity));

        // Update customer's items
        addItemToCustomer(customer, item, quantity);

        System.out.println("Items sold successfully!");
    }

    private Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    private Item findItemByName(String name) {
        for (Item item : inventory) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    private void addItemToCustomer(Customer customer, Item item, int quantity) {
        // Assuming Customer's item field is a list of items (not an array as in your initial design)
        List<Item> customerItems = new ArrayList<>(Arrays.asList(customer.getItem()));
        Item soldItem = new Item(item.getId(), item.getName(), item.getPrice(), quantity);
        customerItems.add(soldItem);
        customer.setItem(customerItems.toArray(new Item[0]));
    }

    public void displayCustomers() {
        System.out.println("Customer List:");

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    // *************************************************************

    // Method to display the current inventory
    public void displayInventory() {
        System.out.println("Current Inventory:");

        if (inventory.isEmpty()) {
            System.out.println("No items in the inventory.");
        } else {
            for (Item item : inventory) {
                System.out.println(item);
            }
        }
    }

    // Method to display all transactions
    public void displayTransactions() {
        System.out.println("Transaction History:");

        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }



    // Helper method to find an item by ID
    private Item findItemById(int itemId) {
        for (Item item : inventory) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        return null; // Item not found
    }
}
