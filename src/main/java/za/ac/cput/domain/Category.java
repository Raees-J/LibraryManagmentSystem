package za.ac.cput.domain;

/**
 * Category.java
 * Category model class
 * Author: Aristide Izabkora (220345821)
 * Date: 25 March 2025
 */

public class Category {

    private String cateId;
    private String cateName;
    private String cateDescription;

    //Constructor
    private Category(Builder build) {
        this.cateId = build.cateId;
        this.cateName = build.cateName;
        this.cateDescription = build.cateDescription;
    }

    //Getters
    public String getCateId(){
        return cateId;
    }

    public String getCateName(){
        return cateName;
    }

    public String getCateDescription(){
        return cateDescription;
    }


    //toString
    @Override
    public String toString() {
        return "Category{" +
                "Category Id='" + cateId + '\'' +
                ", Category name='" + cateName + '\'' +
                ",Category description='" + cateDescription + '\'' +
                '}';
    }

    public static class Builder {

        private String cateId;
        private String cateName;
        private String cateDescription;

        public Builder setCateId(String cateId) {
            this.cateId = cateId;
            return this;
        }

        public Builder setCateName(String cateName) {
            this.cateName = cateName;
            return this;
        }

        public Builder setCateDescription(String cateDescription) {
            this.cateDescription = cateDescription;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}//end
