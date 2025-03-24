/*ILibraryRepository.java
Library Repository Interface
Author: Anwill Jacobs(219423202)
Date: 24 March 2025
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Library;
import java.util.Set;

public interface ILibraryRepository {
    Library create(Library library);
    Library read(String name);
    Library update(Library library);
    boolean delete(String name);
    Set<Library> getAll();
}

