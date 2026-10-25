import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact(
                "12345",
                "Vitor",
                "Duque",
                "6035551234",
                "123 Main Street"
        );

        assertEquals("12345", contact.getContactId());
        assertEquals("Vitor", contact.getFirstName());
        assertEquals("Duque", contact.getLastName());
        assertEquals("6035551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testContactUpdates() {
        Contact contact = new Contact(
                "12345",
                "Vitor",
                "Duque",
                "6035551234",
                "123 Main Street"
        );

        contact.setFirstName("John");
        contact.setLastName("Smith");
        contact.setPhone("6035555678");
        contact.setAddress("456 Oak Street");

        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("6035555678", contact.getPhone());
        assertEquals("456 Oak Street", contact.getAddress());
    }

    @Test
    void testInvalidContact() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "ThisNameIsTooLong", "Duque",
                        "6035551234", "123 Main Street"));

        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Vitor", "Duque",
                        "123", "123 Main Street"));
    }
}