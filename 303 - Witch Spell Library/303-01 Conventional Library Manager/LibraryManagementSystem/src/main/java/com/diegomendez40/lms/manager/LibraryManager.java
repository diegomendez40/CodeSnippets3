package com.diegomendez40.lms.manager;

import com.diegomendez40.lms.model.Book;
import com.diegomendez40.lms.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryManager {
    private HashMap<String, Book> books = new HashMap<>();
    private HashMap<String, User> users = new HashMap<>();

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
            user.getLoanedBooks().put(book.getISBN(), book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String ISBN) {
        Book book = books.get(ISBN);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            // Se asume que el usuario se actualiza adecuadamente
            return true;
        }
        return false;
    }
}