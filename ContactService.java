import java.util.Map;
import java.util.HashMap;

public class ContactService {

    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            return false; // Contact ID already exists
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    public boolean deleteContact(String contactId) {
        return contacts.remove(contactId) != null;
    }

    public boolean updateContactField(String contactId, String field, String newValue) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            return false; // Contact not found
        }

        switch (field) {
            case "firstName":
                contact.setFirstName(newValue);
                break;
            case "lastName":
                contact.setLastName(newValue);
                break;
            case "phone":
                contact.setPhone(newValue);
                break;
            case "address":
                contact.setAddress(newValue);
                break;
            default:
                return false; // Invalid field name
        }
        return true;
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
