package com.gbh.library.controlller;

import com.gbh.library.model.GenericModel;
import com.gbh.library.service.BookPageService;
import com.gbh.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sinoa
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookPageService bookPageService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericModel getAllBooks(@PageableDefault(size = 10, page = 0, sort = {"title"}, direction = Sort.Direction.ASC) Pageable pageable) {
        GenericModel genericModel = bookService.getAllBooks(pageable);
        return genericModel;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericModel getBookByID(@PathVariable(value = "id", required = true) Long bookId) {
        GenericModel genericModel = bookService.getById(bookId);
        return genericModel;
    }

    @RequestMapping(value = "/{bookID}/page/{pageNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericModel getBookPageByIDAndPageNumber(@PathVariable(value = "bookID", required = true) Long bookId,
            @PathVariable(value = "pageNumber", required = true) Integer pageNumber) {
        GenericModel genericModel = bookPageService.getBookPageByIdAndPageNumber(bookId, pageNumber);
        return genericModel;
    }
}
