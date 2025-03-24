/*LibraryRepositoryTest.java
Library Repository Test Class
Author: Anwill Jacobs(219423202)
Date: 24 March 2025
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Library;
import za.ac.cput.factory.LibraryFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

class LibraryRepositoryTest {
    private ILibraryRepository repository; // Use interface instead of concrete class
    private Library library;

    @BeforeEach
    void setUp() {
        repository = LibraryRepository.getRepository(); // Still using Singleton instance
        library = LibraryFactory.createLibrary("City Library", "Downtown");
        repository.create(library);
    }

    @Test
    void testCreate() {
        assertNotNull(repository.read("City Library"));
    }

    @Test
    void testRead() {
        Library readLibrary = repository.read("City Library");
        assertEquals(library.getName(), readLibrary.getName());
    }

    @Test
    void testUpdate() {
        Library updatedLibrary = LibraryFactory.createLibrary("City Library", "Uptown");
        repository.update(updatedLibrary);
        assertEquals("Uptown", repository.read("City Library").getLocation());
    }

    @Test
    void testDelete() {
        assertTrue(repository.delete("City Library"));
        assertNull(repository.read("City Library"));
    }

    @Test
    void testGetAll() {
        Set<Library> libraries = repository.getAll();
        assertFalse(libraries.isEmpty());
    }
}
