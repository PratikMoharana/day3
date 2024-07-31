import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, AddressBook> addressBooks = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");

        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option: " +
                    "1. Add Address Book " +
                    "2. Select Address Book " +
                    "3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAddressBook();
                    break;
                case 2:
                    selectAddressBook();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAddressBook() {
        System.out.println("Enter address book name: ");
        String name = scanner.nextLine();
        addressBooks.put(name, new AddressBook());
    }

    private static void selectAddressBook() {
        System.out.println("Enter address book name: ");
        String name = scanner.nextLine();
        AddressBook addressBook = addressBooks.get(name);
        if (addressBook == null) {
            System.out.println("Address book not found.");
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option: \n1. Add Contact \n2. Edit Contact \n3. Delete Contact \n4. Display Contacts \n5. Back to Main Menu");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact(addressBook);
                    break;
                case 2:
                    editContact(addressBook);
                    break;
                case 3:
                    deleteContact(addressBook);
                    break;
                case 4:
                    displayContacts(addressBook);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact(AddressBook addressBook) {
        System.out.println("first name: ");
        String firstName = scanner.nextLine();
        System.out.println("last name: ");
        String lastName = scanner.nextLine();
        System.out.println("address: ");
        String address = scanner.nextLine();
        System.out.println("city: ");
        String city = scanner.nextLine();
        System.out.println("state: ");
        String state = scanner.nextLine();
        System.out.println("zip: ");
        String zip = scanner.nextLine();
        System.out.println("phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        addressBook.addContact(contact);
    }

    private static void editContact(AddressBook addressBook) {
        System.out.println("first name of the contact to edit: ");
        String firstName = scanner.nextLine();
        System.out.println("last name of the contact to edit: ");
        String lastName = scanner.nextLine();

        System.out.println("new address: ");
        String address = scanner.nextLine();
        System.out.println("new city: ");
        String city = scanner.nextLine();
        System.out.println("new state: ");
        String state = scanner.nextLine();
        System.out.println("new zip: ");
        String zip = scanner.nextLine();
        System.out.println("new phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("new email: ");
        String email = scanner.nextLine();

        Contact newContactDetails = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        addressBook.editContact(firstName, lastName, newContactDetails);
    }

    private static void deleteContact(AddressBook addressBook) {
        System.out.println("first name of the contact to delete: ");
        String firstName = scanner.nextLine();
        System.out.println("last name of the contact to delete: ");
        String lastName = scanner.nextLine();
        addressBook.deleteContact(firstName, lastName);
    }

    private static void displayContacts(AddressBook addressBook) {
        for (Contact contact : addressBook.getContacts()) {
            System.out.println(contact);
        }
    }
}
