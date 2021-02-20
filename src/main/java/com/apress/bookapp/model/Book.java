package com.apress.bookapp.model;
import com.apress.bookapp.model.Author;
import java.util.List;
public class Book {
    private Long id;
    private Long categoryId;
    private String bookTitle;
    private List<Author> authors;

    public Book() { }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCategoryId() {
        return this.categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public String getBookTitle() {
        return this.bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public List<Author> getAuthors() {
        return this.authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    public String toString() {
        return "Book - Id: " + this.id + ", Book Title: " + this.bookTitle;
    }
}
