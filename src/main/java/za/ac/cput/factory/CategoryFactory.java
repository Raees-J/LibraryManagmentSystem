package za.ac.cput.factory;

/**
 * Category.java
 * Category model class
 * Author: Aristide Izabkora (220345821)
 * Date: 25 March 2025
 */

import za.ac.cput.domain.Category;

public class CategoryFactory {
    public static Category createUser(String cateId, String cateName, String cateDescription) {
        return new Category.Builder()
                .setCateId(cateId)
                .setCateName(cateName)
                .setCateDescription(cateDescription)
                .build();
    }
}//end
