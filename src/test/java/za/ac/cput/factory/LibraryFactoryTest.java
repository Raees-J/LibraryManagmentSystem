package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Library;

import static org.junit.jupiter.api.Assertions.*;

class LibraryFactoryTest {

    @Test
    void testCreateLibrary() {
        Library library = LibraryFactory.createLibrary("City Library", "Downtown");

        assertNotNull(library);
        assertEquals("City Library", library.getName());
        assertEquals("Downtown", library.getLocation());
    }
}
