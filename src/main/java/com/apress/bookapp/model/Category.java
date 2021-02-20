package com.apress.bookapp.model;

public class Category {
    private Long id;
    private String categoryDescription;

    public Category() { }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategoryDescription() {
        return this.categoryDescription;
    }
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
    public String toString() {
        return "Category - Id: " + this.id + ", Category Description: " + this.categoryDescription;
    }
}
