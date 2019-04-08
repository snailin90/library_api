package com.gbh.library.model;

import com.gbh.library.utility.OutputResponse;
import com.gbh.library.utility.Pagination;
import java.util.List;

/**
 *
 * @author Snailin Inoa
 */
public class GenericModel<T> extends OutputResponse {

    private List<T> list = null;
    private T singleObject = null;
    Pagination pagination;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getSingleObject() {
        return singleObject;
    }

    public void setSingleObject(T singleObject) {
        this.singleObject = singleObject;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
