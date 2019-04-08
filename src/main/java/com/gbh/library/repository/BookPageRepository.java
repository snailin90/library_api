package com.gbh.library.repository;

import com.gbh.library.entity.BookPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sinoa
 */

@Repository
public interface BookPageRepository extends JpaRepository<BookPage, Long> {

    public BookPage findByIdBookAndPageNumber(Long idBook, Integer pageNumber);
}
