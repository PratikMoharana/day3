import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void editContact(String firstName, String lastName, Contact newContactDetails) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                contact.setFirstName(newContactDetails.getFirstName());
                contact.setFirstName(newContactDetails.getFirstName());
                contact.setAddress(newContactDetails.getAddress());
                contact.setCity(newContactDetails.getCity());
                contact.setState(newContactDetails.getState());
                contact.setZip(newContactDetails.getZip());
                contact.setPhoneNumber(newContactDetails.getPhoneNumber());
                contact.setEmail(newContactDetails.getEmail());
                break;
            }
        }
    }

    public void deleteContact(String firstName, String lastName) {
        contacts.removeIf(contact -> contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName));
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
