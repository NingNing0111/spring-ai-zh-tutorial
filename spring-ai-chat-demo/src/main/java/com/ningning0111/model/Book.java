package com.ningning0111.model;

/**
 * @Project: com.ningning0111.model
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/4/22 16:23
 * @Description:
 */
public class Book {
    private String author;
    private String bookName;
    private String publishedDate;
    private String description;
    public Book(){};

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Book(String author, String publishedDate, String description, String bookName) {
        this.author = author;
        this.publishedDate = publishedDate;
        this.description = description;
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
