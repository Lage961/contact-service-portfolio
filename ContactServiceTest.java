import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testContactService() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "Vitor",
                "Duque",
                "6035551234",
                "123 Main Street"
        );

        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
        service.updateFirstName("12345", "John");
        assertEquals("John", service.getContact("12345").getFirstName());
        service.updateLastName("12345", "Smith");
        assertEquals("Smith", service.getContact("12345").getLastName());
        service.updatePhone("12345", "6035555678");
        assertEquals("6035555678", service.getContact("12345").getPhone());
        service.updateAddress("12345", "456 Oak Street");
        assertEquals("456 Oak Street", service.getContact("12345").getAddress());


        
        // Delete
        service.deleteContact("12345");
        assertThrows(IllegalArgumentException.class, () ->
                service.getContact("12345"));
    }
}