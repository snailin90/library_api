package com.gbh.library.repository;

import com.gbh.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sinoa
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
