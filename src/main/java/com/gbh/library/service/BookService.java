package com.gbh.library.service;

import com.gbh.library.entity.Book;
import com.gbh.library.entity.BookPage;
import com.gbh.library.model.BookModel;
import com.gbh.library.model.BookPageModel;
import com.gbh.library.model.GenericModel;
import com.gbh.library.repository.BookRepository;
import com.gbh.library.utility.Constant;
import com.gbh.library.utility.Pagination;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author sinoa
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    public GenericModel getAllBooks(Pageable pageable) {
        LOGGER.info("getAllBooks() :: START");
        LOGGER.info("pageable :: " + pageable);
        GenericModel<BookModel> genericModel = new GenericModel<>();

        try {
            Page<Book> bookList = bookRepository.findAll(pageable);
            if (bookList != null) {
                List<BookModel> booksModelList = this.convertBookListToBookModelList(bookList.getContent());
                genericModel.setList(booksModelList);
                Pagination pagination = new Pagination();
                pagination.setActualPageNumber(bookList.getNumber());
                pagination.setActualSize(bookList.getSize());
                pagination.setFirst(bookList.isFirst());
                pagination.setLast(bookList.isLast());
                pagination.setNumberOfElements(bookList.getNumberOfElements());
                pagination.setSort(bookList.getSort());
                pagination.setTotalElements(bookList.getTotalElements());
                pagination.setTotalPages(bookList.getTotalPages());
                genericModel.setPagination(pagination);
            }
            genericModel.setCode(Constant.SUCCESS_CODE);
            genericModel.setMessage(Constant.SUCCESS_MSG);
        } catch (Exception ex) {
            genericModel.setCode(Constant.ERROR_CODE);
            genericModel.setMessage("Error Found : " + ex);

        }
        LOGGER.info("getAllBooks() :: END");
        return genericModel;

    }

    public GenericModel getById(Long id) {
        LOGGER.info("getById() :: START");
        LOGGER.info("id :: " + id);
        GenericModel<BookModel> genericModel = new GenericModel<>();
        try {
            Book book = bookRepository.findById(id).get();
            if (book != null && book.getId() > 0) {
                BookModel bookModel = this.convertBookToBookModel(book);
                genericModel.setCode(Constant.SUCCESS_CODE);
                genericModel.setMessage(Constant.SUCCESS_MSG);
                genericModel.setSingleObject(bookModel);
            } else {
                genericModel.setCode(Constant.ERROR_CODE_NOT_FOUND);
                genericModel.setMessage("book with ID : " + id + " was not found");
            }
        } catch (NoSuchElementException ex) {
            genericModel.setCode(Constant.ERROR_CODE_NOT_FOUND);
            genericModel.setMessage("book with ID : " + id + " was not found");
        } catch (Exception ex) {
            genericModel.setCode(Constant.ERROR_CODE);
            genericModel.setMessage("Error Found : " + ex);

        }
        LOGGER.info("getById() :: END");
        return genericModel;

    }

    private BookModel convertBookToBookModel(Book book) {
        BookModel bookModel = new BookModel();
        bookModel.setAuthor(book.getAuthor());
        bookModel.setCreatedAt(book.getCreatedAt());
        bookModel.setDescription(book.getDescription());
        bookModel.setTitle(book.getTitle());
        bookModel.setIssueDate(book.getIssueDate());
        bookModel.setId(book.getId());
        bookModel.setTotalPages(book.getTotalPages());
        bookModel.setUpdatedAt(book.getUpdatedAt());
        Collection<BookPageModel> bookPageModelList = new ArrayList();
        for (BookPage bookPage : book.getBookPageCollection()) {
            BookPageModel bookPageModel = new BookPageModel();
            bookPageModel.setContent(bookPage.getContent());
            if (bookPage.getBookPagePK() != null) {
                bookPageModel.setIdBook(bookPage.getBookPagePK().getIdBook());
                bookPageModel.setPageNumber(bookPage.getBookPagePK().getPageNumber());
            }
            bookPageModelList.add(bookPageModel);
        }
        bookModel.setBookPageCollection(bookPageModelList);
        return bookModel;
    }

    private List<BookModel> convertBookListToBookModelList(List<Book> bookList) {
        List<BookModel> booksModelList = new ArrayList<>();
        for (Book book : bookList) {
            BookModel bookModel = this.convertBookToBookModel(book);
            booksModelList.add(bookModel);
        }
        return booksModelList;
    }

}
