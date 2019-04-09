package com.gbh.library.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sinoa
 */
@Embeddable
public class BookPagePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_book")
    private long idBook;
    @Basic(optional = false)
    @NotNull
    @Column(name = "page_number")
    private int pageNumber;

    public BookPagePK() {
    }

    public BookPagePK(int id, long idBook, int pageNumber) {

        this.idBook = idBook;
        this.pageNumber = pageNumber;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;

        hash += (int) idBook;
        hash += (int) pageNumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookPagePK)) {
            return false;
        }
        BookPagePK other = (BookPagePK) object;

        if (this.idBook != other.idBook) {
            return false;
        }
        if (this.pageNumber != other.pageNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gbh.library.entity.BookPagePK[ idBook=" + idBook + ", pageNumber=" + pageNumber + " ]";
    }

}
