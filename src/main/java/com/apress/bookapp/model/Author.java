package com.apress.bookapp.model;


public class Author {
    private Long id;
    private Long bookId;
    private String firstName;
    private String lastName;

    public Author() {}
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getBookId() {
        return this.bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String toString() {
        return "Author - Id: " + this.id + ", Book id: " + this.bookId + ", First Name: " + this.firstName + ", Last Name: " + this.lastName;
    }
}
