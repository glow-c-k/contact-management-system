import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public void saveContacts(String fileName, List<Contact> contacts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Contact contact : contacts) {
                writer.println(contact.getContactId() + "," +
                        contact.getName() + "," +
                        contact.getPhoneNumber() + "," +
                        contact.getEmail() + "," +
                        contact.getAddress());
            }
        } catch (IOException e) {
            System.err.println("Error saving contacts: " + e.getMessage());
        }
    }

    public List<Contact> loadContacts(String fileName) {
        List<Contact> contacts = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            return contacts;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    Contact contact = new Contact(id, parts[1], parts[2], parts[3], parts[4]);
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading contacts: " + e.getMessage());
        }

        return contacts;
    }
}
