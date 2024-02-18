package com.diegomendez40.lms.manager;

import com.diegomendez40.lms.model.Book;
import com.diegomendez40.lms.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LibraryManager {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, User> users = new HashMap<>();
    private Map<String, User> loanedBooks;

    public LibraryManager() {
        this.books = new HashMap<String, Book>();
        this.users = new HashMap<String, User>();
        this.loanedBooks = new HashMap<String, User>();
    }

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public List<Book> searchBooksByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public boolean lendBook(String ISBN, String userId) {
        Book book = books.get(ISBN);
        User user = users.get(userId);
        if (book != null && user != null && book.isAvailable()) {
            book.setAvailable(false);
            user.getBorrowedBooks().put(book.getISBN(), book);
            loanedBooks.put(ISBN, user);
            return true;
        }
        return false;
    }

    public boolean returnBook(String ISBN) {
        Book book = books.get(ISBN);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            loanedBooks.get(ISBN).returnBook(ISBN);
            return true;
        }
        return false;
    }

    public boolean containsBook(String ISBN) {
        return books.containsKey(ISBN);
    }
}