package com.gbh.library.controlller;

import com.gbh.library.format.FormatTypeEnum;
import com.gbh.library.model.GenericModel;
import com.gbh.library.service.BookPageService;
import com.gbh.library.service.BookService;
import com.gbh.library.utility.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public GenericModel getAllBooks(@PageableDefault(size = 10, page = 0, sort = {"title"}, direction = Sort.Direction.DESC) Pageable pageable) {
        GenericModel genericModel = bookService.getAllBooks(pageable);
        return genericModel;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericModel getBookByID(@PathVariable(value = "id", required = true) Long bookId) {
        GenericModel genericModel = bookService.getById(bookId);
        return genericModel;
    }

    @RequestMapping(value = "/{bookID}/page/{pageNumber}/{format}", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE, MediaType.TEXT_HTML_VALUE})
    public ResponseEntity getBookPageByIDAndPageNumber(@PathVariable(value = "bookID", required = true) Long bookId,
            @PathVariable(value = "pageNumber", required = true) Integer pageNumber, @PathVariable(value = "format", required = true) String format) {

        HttpHeaders headers = new HttpHeaders();
        String bodyFormatted = "";
        if (!FormatTypeEnum.isValidFormatType(format)) {
            bodyFormatted = "The Format Specified is not available.";
            headers.setContentType(MediaType.TEXT_PLAIN);
        } else {
            bodyFormatted = bookPageService.getBookPageByIdAndPageNumberFormatted(bookId, pageNumber, format);
        }

        return this.loadResponseEntityWithFormat(format, bodyFormatted, headers);

    }

    private ResponseEntity loadResponseEntityWithFormat(String format, String body, HttpHeaders headers) {

        if (format.equals(Constant.HTML_FORMAT)) {
            headers.setContentType(MediaType.TEXT_HTML);
        } else if (format.equals(Constant.TEXT_FORMAT)) {
            headers.setContentType(MediaType.TEXT_PLAIN);
        }

        ResponseEntity responseEntity = new ResponseEntity(body, headers, HttpStatus.OK);
        return responseEntity;
    }
}
