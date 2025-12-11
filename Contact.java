public class Contact {
    private final int contactId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public Contact(int contactId, String name, String phoneNumber, String email, String address) {
        this.contactId = contactId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public int getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}