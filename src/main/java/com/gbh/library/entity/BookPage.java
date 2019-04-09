package com.gbh.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sinoa
 */
@Entity
@Table(name = "book_page")
@JsonIgnoreProperties(value ="BookPagePK" )
public class BookPage implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected BookPagePK bookPagePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "content", length = 2147483647)
    private String content;
    @JoinColumn(name = "id_book", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book book;

    public BookPage() {
    }

    public BookPage(BookPagePK bookPagePK) {
        this.bookPagePK = bookPagePK;
    }

    public BookPage(BookPagePK bookPagePK, String content) {
        this.bookPagePK = bookPagePK;
        this.content = content;
    }

    public BookPage(int id, long idBook, int pageNumber) {
        this.bookPagePK = new BookPagePK(id, idBook, pageNumber);
    }

    public BookPagePK getBookPagePK() {
        return bookPagePK;
    }

    public void setBookPagePK(BookPagePK bookPagePK) {
        this.bookPagePK = bookPagePK;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookPagePK != null ? bookPagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookPage)) {
            return false;
        }
        BookPage other = (BookPage) object;
        if ((this.bookPagePK == null && other.bookPagePK != null) || (this.bookPagePK != null && !this.bookPagePK.equals(other.bookPagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbh.library.entity.BookPage[ bookPagePK=" + bookPagePK + " ]";
    }

}
