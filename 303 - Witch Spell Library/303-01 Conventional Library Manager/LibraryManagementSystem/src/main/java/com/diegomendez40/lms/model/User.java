package com.diegomendez40.lms.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class User {

    String id;
    String name;
    Map<String, Book> borrowedBooks;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new HashMap<String, Book>();
    }

    public User(String id, String name, HashMap<String, Book> borrowedBooks) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = borrowedBooks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Map<String, Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void returnBook(String isbn) {
        Book returned = borrowedBooks.remove(isbn);
    }
}
