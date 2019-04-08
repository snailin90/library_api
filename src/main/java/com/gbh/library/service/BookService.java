package com.gbh.library.service;

import com.gbh.library.entity.Book;
import com.gbh.library.model.GenericModel;
import com.gbh.library.repository.BookRepository;
import com.gbh.library.utility.Constant;
import com.gbh.library.utility.Pagination;
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
        GenericModel<Book> genericModel = new GenericModel<>();

        try {

            Page<Book> bookList = bookRepository.findAll(pageable);
            if (bookList != null) {
                genericModel.setList(bookList.getContent());
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
        GenericModel<Book> genericModel = new GenericModel<>();
        try {

            Book book = bookRepository.findById(id).get();

            if (book != null && book.getId() > 0) {

                genericModel.setCode(Constant.SUCCESS_CODE);
                genericModel.setMessage(Constant.SUCCESS_MSG);
                genericModel.setSingleObject(book);
            } else {
                genericModel.setCode(Constant.ERROR_CODE_NOT_FOUND);
                genericModel.setMessage("book with ID : " + id + " was not found");
            }

        } catch (Exception ex) {
            genericModel.setCode(Constant.ERROR_CODE);
            genericModel.setMessage("Error Found : " + ex);

        }
        LOGGER.info("getById() :: END");
        return genericModel;

    }

}
