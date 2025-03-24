package za.ac.cput.repository;

import za.ac.cput.domain.Library;
import java.util.*;

public class LibraryRepository implements ILibraryRepository {
    private static LibraryRepository repository = null;
    private Map<String, Library> libraryMap;

    private LibraryRepository() {
        this.libraryMap = new HashMap<>();
    }

    public static LibraryRepository getRepository() {
        if (repository == null) {
            repository = new LibraryRepository();
        }
        return repository;
    }

    @Override
    public Library create(Library library) {
        libraryMap.put(library.getName(), library);
        return library;
    }

    @Override
    public Library read(String name) {
        return libraryMap.get(name);
    }

    @Override
    public Library update(Library library) {
        if (libraryMap.containsKey(library.getName())) {
            libraryMap.put(library.getName(), library);
            return library;
        }
        return null;
    }

    @Override
    public boolean delete(String name) {
        if (libraryMap.containsKey(name)) {
            libraryMap.remove(name);
            return true;
        }
        return false;
    }

    @Override
    public Set<Library> getAll() {
        return new HashSet<>(libraryMap.values());
    }
}


