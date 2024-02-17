package com.diegomendez40.lms.model;

import java.util.HashMap;

public class User {

    String id;
    String name;
    HashMap<String, Book> loanedBooks;

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

    public HashMap<String, Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(HashMap<String, Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

}
