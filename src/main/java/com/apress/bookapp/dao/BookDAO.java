package com.apress.bookapp.dao;
import com.apress.bookapp.model.Book;
import com.apress.bookapp.model.Category;
import java.util.List;
public interface BookDAO {
    List<Book> findAllBooks();
    List<Book> searchBooksByKeyword(String var1);
    List<Category> findAllCategories();
    void insert(Book var1);
    void update(Book var1);
    void delete(Long var1);
}
