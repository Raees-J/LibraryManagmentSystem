/*
UserRepositoryTest.java
User model class
Author: Raees Johaadien (230558135)
Date: 14 March 2025
*/
package za.ac.cput.repository;
import org.junit.jupiter.api.*;
import za.ac.cput.domain.User;
import za.ac.cput.factory.userFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

public class UserRepositoryTest {
    private static IUserRepository repository = UserRepository.getRepository();

    private  User user = userFactory.createUser("205327081", "Patrick","12 Goodwood", "021 567 4320");

    @Test
    void a_create(){
        User created = repository.create(user);
        assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void b_read(){
        User read = repository.read(user.getUserId());
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    void c_update(){
        User newUser = new User.Builder().copy(user).setContactNumber("0836549824")
                .build();
        User updated = repository.update(newUser);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    @Disabled
    void d_delete(){
        assertTrue(repository.delete(user.getUserId()));
        System.out.println("successfully deleted");
    }

    @Test
    void e_getAll(){
        System.out.println(repository.getAll());
    }

}
