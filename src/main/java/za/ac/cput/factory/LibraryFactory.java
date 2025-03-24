package za.ac.cput.factory;

import za.ac.cput.domain.Library;

public class LibraryFactory {
    public static Library createLibrary(String name, String location) {
        return new Library.Builder()
                .setName(name)
                .setLocation(location)
                .build();
    }
}