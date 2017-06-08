package com.sld.base;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by diwu.sld on 2017/4/12.
 */
public final class Result<T>  implements Serializable, IResult{

    private T model;

    private boolean isSuccess;

    private String errorMsg;

    public Result(T model, boolean isSuccess) {
        this.model = model;
        this.isSuccess = isSuccess;
    }

    public Result(T model, boolean isSuccess, String errorMsg){
        this.model = model;
        this.isSuccess = isSuccess;
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean isSuccess() {
        return this.isSuccess;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }

    public T getModel(){
        return  this.model;
    }
}
