import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private final ContactManager contactManager = new ContactManager();
    private final FileHandler fileHandler = new FileHandler();
    private final String fileName = "contacts.txt";

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.handleUserInput();
    }

    public void showMenu() {
        System.out.println("\n=== Contact Management System ===");
        System.out.println("1. Add Contact");
        System.out.println("2. Delete Contact");
        System.out.println("3. Update Contact");
        System.out.println("4. Search Contacts");
        System.out.println("5. List All Contacts");
        System.out.println("6. Save Contacts");
        System.out.println("7. Load Contacts");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    public void handleUserInput() {
        boolean running = true;

        while (running) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addContact();
                case "2" -> deleteContact();
                case "3" -> updateContact();
                case "4" -> searchContact();
                case "5" -> listAllContacts();
                case "6" -> saveContacts();
                case "7" -> loadContacts();
                case "8" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addContact() {
        System.out.print("Enter contact ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter address: ");
        String address = scanner.nextLine().trim();

        Contact contact = new Contact(id, name, phone, email, address);
        contactManager.addContact(contact);
        System.out.println("Contact added successfully!");
    }

    private void deleteContact() {
        System.out.print("Enter contact ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        contactManager.deleteContact(id);
        System.out.println("Contact deleted!");
    }

    private void updateContact() {
        System.out.print("Enter contact ID to update: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter new name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter new phone number: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter new address: ");
        String address = scanner.nextLine().trim();

        Contact updatedContact = new Contact(id, name, phone, email, address);
        contactManager.updateContact(updatedContact);
        System.out.println("Contact updated!");
    }

    private void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().trim();

        List<Contact> results = contactManager.searchContact(name);

        if (results.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Found " + results.size() + " contact(s):");
            for (Contact contact : results) {
                displayContact(contact);
            }
        }
    }

    private void listAllContacts() {
        List<Contact> contacts = contactManager.getAllContacts();

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("All contacts:");
            for (Contact contact : contacts) {
                displayContact(contact);
            }
        }
    }

    private void saveContacts() {
        List<Contact> contacts = contactManager.getAllContacts();
        fileHandler.saveContacts(fileName, contacts);
        System.out.println("Contacts saved to " + fileName);
    }

    private void loadContacts() {
        List<Contact> contacts = fileHandler.loadContacts(fileName);
        // Clear current contacts and add loaded ones
        for (Contact contact : contacts) {
            contactManager.addContact(contact);
        }
        System.out.println("Contacts loaded from " + fileName);
    }

    private void displayContact(Contact contact) {
        System.out.println("ID: " + contact.getContactId() +
                ", Name: " + contact.getName() +
                ", Phone: " + contact.getPhoneNumber() +
                ", Email: " + contact.getEmail() +
                ", Address: " + contact.getAddress());
    }
}
