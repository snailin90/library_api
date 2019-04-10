package com.gbh.library.service;

import com.gbh.library.entity.BookPage;
import com.gbh.library.entity.BookPagePK;
import com.gbh.library.format.FormatProcessor;
import com.gbh.library.model.GenericModel;
import com.gbh.library.repository.BookPageRepository;
import com.gbh.library.utility.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sinoa
 */
@Service
public class BookPageService {

    @Autowired
    private BookPageRepository bookPageRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(BookPageService.class);

    public GenericModel getBookPageByIdAndPageNumber(Long idBook, Integer pageNumber) {
        LOGGER.info("getBookPageByIdAndPageNumber() :: START");
        LOGGER.info("idBook :: " + idBook);
        LOGGER.info("pageNumber :: " + pageNumber);
        GenericModel<BookPage> genericModel = new GenericModel<>();
        try {

            BookPagePK bookPagePK = new BookPagePK();
            bookPagePK.setIdBook(idBook);
            bookPagePK.setPageNumber(pageNumber);
            BookPage bookPage = bookPageRepository.findByBookPagePK(bookPagePK);

            if (bookPage != null && bookPage.getBookPagePK() != null && bookPage.getBookPagePK().getIdBook() > 0) {

                genericModel.setCode(Constant.SUCCESS_CODE);
                genericModel.setMessage(Constant.SUCCESS_MSG);
                genericModel.setSingleObject(bookPage);
            } else {
                genericModel.setCode(Constant.ERROR_CODE_NOT_FOUND);
                genericModel.setMessage("Book Page with bookId : '" + idBook + "'" + "and Page Number : '" + pageNumber + "' was not found");
            }

        } catch (Exception ex) {
            genericModel.setCode(Constant.ERROR_CODE);
            genericModel.setMessage("Error Found : " + ex);

        }
        LOGGER.info("getBookPageByIdAndPageNumber() :: END");
        return genericModel;

    }

    public String getBookPageByIdAndPageNumberFormatted(Long idBook, Integer pageNumber, String format) {
        String result = "That Page is not available, please make sure the page exist.";
        try {
            GenericModel genericModel = this.getBookPageByIdAndPageNumber(idBook, pageNumber);

            if (genericModel != null && genericModel.getSingleObject() != null && ((BookPage) genericModel.getSingleObject()).getContent() != null) {
                result = ((BookPage) genericModel.getSingleObject()).getContent();
            }

            result = FormatProcessor.getInstance().format(format, result);
        } catch (Exception ex) {
            result = "Error Occured trying to Format the Response";
        }
        return result;
    }

}
