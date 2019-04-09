package com.gbh.library.model;

import com.gbh.library.entity.BookPage;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author sinoa
 */
public class BookModel {

    private Long id;
    private String title;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private String author;
    private int totalPages;
    private Date issueDate;
    private Collection<BookPageModel> bookPageCollection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Collection<BookPageModel> getBookPageCollection() {
        return bookPageCollection;
    }

    public void setBookPageCollection(Collection<BookPageModel> bookPageCollection) {
        this.bookPageCollection = bookPageCollection;
    }

}
