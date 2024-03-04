import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        String contactId = "ID1234";
        String firstName = "John";
        String lastName = "Doe";
        String phone = "1234567890";
        String address = "123 Main St";

        Contact contact = new Contact(contactId, firstName, lastName, phone, address);

        assertEquals(contactId, contact.getContactId());
        assertEquals(firstName, contact.getFirstName());
        assertEquals(lastName, contact.getLastName());
        assertEquals(phone, contact.getPhone());
        assertEquals(address, contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactId() {
        new Contact("ID1234567890", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstName() {
        new Contact("ID1234", "", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLastName() {
        new Contact("ID1234", "John", "", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhone() {
        new Contact("ID1234", "John", "Doe", "12345678", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddress() {
        new Contact("ID1234", "John", "Doe", "1234567890", "");
    }

    @Test
    public void testSettersAndGetters() {
        Contact contact = new Contact("ID1234", "John", "Doe", "1234567890", "123 Main St");

        String newFirstName = "Jane";
        String newLastName = "Smith";
        String newPhone = "9876543210";
        String newAddress = "456 Maple Ave";

        contact.setFirstName(newFirstName);
        contact.setLastName(newLastName);
        contact.setPhone(newPhone);
        contact.setAddress(newAddress);

        assertEquals(newFirstName, contact.getFirstName());
        assertEquals(newLastName, contact.getLastName());
        assertEquals(newPhone, contact.getPhone());
        assertEquals(newAddress, contact.getAddress());
    }

    // You can add further tests for other functionalities and edge cases
}

