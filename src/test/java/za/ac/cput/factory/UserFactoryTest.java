/*
UserFactoryTest.java
User model class
Author: Raees Johaadien (230558135)
Date: 14 March 2025
*/
package za.ac.cput.factory;
import org.junit.jupiter.api.*;
import za.ac.cput.domain.User;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserFactoryTest {
    private static User u1 = userFactory.createUser("230558135","Raees","58 Bellmore Avenue");

    private static User u2 = userFactory.createUser("220447149", "boeta", "123 goege drive", "0836379078");

    private static User u3 = userFactory.createUser("217693950", "","","");

    @Test
    @Order(1)
    public void testCreateUser() {
        assertNotNull(u1);
        System.out.println(u1.toString());
    }

    @Test
    @Order(2)
    public void testCreateUserWithAllAttributes() {
        assertNotNull(u2);
        System.out.println(u2.toString());
    }

    @Test
    @Order(3)
    public void testCreateUserThatFails() {
        assertNotNull(u3);
        System.out.println(u3.toString());
    }


}
