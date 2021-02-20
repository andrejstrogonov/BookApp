package com.apress.bookapp.controller;

import com.apress.bookapp.dao.BookDAO;
import com.apress.bookapp.dao.BookDAOImpl;
import com.apress.bookapp.model.Book;
import com.apress.bookapp.model.Category;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
    public Controller() {
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        BookDAO bookDao = new BookDAOImpl();
        List<Category> categoryList = bookDao.findAllCategories();
        ServletContext context = config.getServletContext();
        context.setAttribute("categoryList", categoryList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String base = "/jsp/";
        String url = base + "home.jsp";
        String action = request.getParameter("action");
        String category = request.getParameter("category");
        String keyWord = request.getParameter("keyWord");
        if (action != null) {
            switch(action.hashCode()) {
                case -906336856:
                    if (action.equals("search")) {
                        this.searchBooks(request, response, keyWord);
                        url = base + "searchResult.jsp";
                    }
                    break;
                case 50511102:
                    if (action.equals("category")) {
                        this.findAllBooks(request, response);
                        url = base + "category.jsp?category=" + category;
                    }
                    break;
                case 1771345289:
                    if (action.equals("allBooks")) {
                        this.findAllBooks(request, response);
                        url = base + "listOfBooks.jsp";
                    }
            }
        }

        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    private void findAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BookDAO bookDao = new BookDAOImpl();
            List<Book> bookList = bookDao.findAllBooks();
            request.setAttribute("bookList", bookList);
        } catch (Exception var5) {
            System.out.println(var5);
        }

    }
    private void searchBooks(HttpServletRequest request, HttpServletResponse response, String keyWord) throws ServletException, IOException {
        try {
            BookDAO bookDao = new BookDAOImpl();
            List<Book> bookList = bookDao.searchBooksByKeyword(keyWord);
            request.setAttribute("bookList", bookList);
        } catch (Exception var6) {
            System.out.println(var6);
        }

    }
}

