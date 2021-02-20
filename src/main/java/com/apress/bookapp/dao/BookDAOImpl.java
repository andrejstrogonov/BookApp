package com.apress.bookapp.dao;
import com.apress.bookapp.model.Author;
import com.apress.bookapp.model.Book;
import com.apress.bookapp.model.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class BookDAOImpl implements BookDAO {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException var1) {
        }
    }

    public BookDAOImpl() { }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "lF0e%9ziXTnqm@tp");
    }
    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException var3) {
            }

        }
    }
    public List<Book> findAllBooks() {
        List<Book> result = new ArrayList();
        List<Author> authorList = new ArrayList();
        String sql = "select * from book inner join author on book.id = author.book_id";
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("id"));
                book.setBookTitle(resultSet.getString("book_title"));
                book.setCategoryId(resultSet.getLong("category_id"));
                author.setBookId(resultSet.getLong("book_Id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                authorList.add(author);
                book.setAuthors(authorList);
                result.add(book);
            }
        } catch (SQLException var12) {
            var12.printStackTrace();
        } finally {
            this.closeConnection(connection);
        }
        return result;
    }
    public List<Book> searchBooksByKeyword(String keyWord) {
        List<Book> result = new ArrayList();
        List<Author> authorList = new ArrayList();
        String sql = "select * from book inner join author on book.id = author.book_id where book_title like '%" + keyWord.trim() + "%'" + " or first_name like '%" + keyWord.trim() + "%'" + " or last_name like '%" + keyWord.trim() + "%'";
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("id"));
                book.setBookTitle(resultSet.getString("book_title"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setBookId(resultSet.getLong("book_id"));
                authorList.add(author);
                book.setAuthors(authorList);
                result.add(book);
            }
        } catch (SQLException var13) {
            var13.printStackTrace();
        } finally {
            this.closeConnection(connection);
        }
        return result;
    }

    public List<Category> findAllCategories() {
        List<Category> result = new ArrayList();
        String sql = "select * from category";
        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setCategoryDescription(resultSet.getString("category_description"));
                result.add(category);
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        } finally {
            this.closeConnection(connection);
        }

        return result;
    }

    public void insert(Book book) {
        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into Book (book_title) values (?)", 1);
            statement.setString(1, book.getBookTitle());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                book.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException var8) {
            var8.printStackTrace();
        } finally {
            this.closeConnection(connection);
        }

    }

    public void update(Book book) {
    }

    public void delete(Long bookId) {
        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from book where id=?");
            statement.setLong(1, bookId);
            statement.execute();
        } catch (SQLException var7) {
            var7.printStackTrace();
        } finally {
            this.closeConnection(connection);
        }

    }
}

