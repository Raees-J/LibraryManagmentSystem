package za.ac.cput.factory;

/**
 * Category.java
 * Category model class
 * Author: Aristide Izabkora (220345821)
 * Date: 25 March 2025
 */

import za.ac.cput.domain.Category;
import  org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryFactoryTest {
        @Test
        void testCreateCategory() {
            Category category = CategoryFactory.createUser("Novel", "To Kill A MockingBird","Chronicles the childhood of Scout and Jem Finch as their father Atticus defends a Black man falsely accused of rape");

            assertNotNull(category);
            assertEquals("Novel", category.getCateId());
            assertEquals("To Kill A MockingBird", category.getCateName());
            assertEquals("Chronicles the childhood of Scout and Jem Finch as their father Atticus defends a Black man falsely accused of rape", category.getCateDescription());
        }
 }//end


