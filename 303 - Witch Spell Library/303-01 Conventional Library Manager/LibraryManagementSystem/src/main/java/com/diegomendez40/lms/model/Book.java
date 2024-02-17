package com.diegomendez40.lms.model;

import java.util.HashSet;
import java.util.Set;

public class Book {
    private final String ISBN;
    private String title;
    private String author;
    private boolean isAvailable;
    private Set<String> tags;

    // Constructor, getters y setters


    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.tags = new HashSet<>();
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                ", tags=" + tags +
                '}';
    }
}
