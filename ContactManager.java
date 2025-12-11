import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(int id) {
        contacts.removeIf(contact -> contact.getContactId() == id);
    }

    public void updateContact(Contact updatedContact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId() == updatedContact.getContactId()) {
                contacts.set(i, updatedContact);
                break;
            }
        }
    }

    public List<Contact> searchContact(String name) {
        List<Contact> results = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(contact);
            }
        }
        return results;
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }
}