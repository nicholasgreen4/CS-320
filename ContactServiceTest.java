import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {

    private ContactService contactService = new ContactService();

    @Test
    public void testAddContactSuccess() {
        Contact contact = new Contact("ID1234", "John", "Doe", "1234567890", "123 Main St");
        boolean added = contactService.addContact(contact);

        assertTrue(added);
        assertEquals(contact, contactService.getContact("ID1234"));
    }

    @Test
    public void testAddContactDuplicateId() {
        Contact contact1 = new Contact("ID1234", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("ID1234", "Jane", "Smith", "9876543210", "456 Maple Ave");

        contactService.addContact(contact1);
        boolean added = contactService.addContact(contact2);

        assertFalse(added);
        assertEquals(contact1, contactService.getContact("ID1234"));
    }

    @Test
    public void testDeleteContactSuccess() {
        Contact contact = new Contact("ID1234", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        boolean deleted = contactService.deleteContact("ID1234");

        assertTrue(deleted);
        assertNull(contactService.getContact("ID1234"));
    }

    @Test
    public void testDeleteContactNotFound() {
        boolean deleted = contactService.deleteContact("ID1234");

        assertFalse(deleted);
        assertNull(contactService.getContact("ID1234"));
    }

    @Test
    public void testUpdateContactFieldSuccess() {
        Contact contact = new Contact("ID1234", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContactField("ID1234", "firstName", "Jane");
        Contact updatedContact = contactService.getContact("ID1234");

        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName()); // Unchanged
        assertEquals("1234567890", updatedContact.getPhone()); // Unchanged
        assertEquals("123 Main St", updatedContact.getAddress()); // Unchanged

        // Test other fields and edge cases based on your implementation
    }

    @Test
    public void testUpdateContactFieldInvalidId() {
        boolean updated = contactService.updateContactField("ID1234", "firstName", "Jane");

        assertFalse(updated);
    }

    @Test
    public void testUpdateContactFieldInvalidField() {
        Contact contact = new Contact("ID1234", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        boolean updated = contactService.updateContactField("ID1234", "invalidField", "Jane");

        assertFalse(updated);
    }

    // You can add further tests for other functionalities and edge cases
}
