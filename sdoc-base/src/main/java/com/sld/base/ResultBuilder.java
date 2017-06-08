package com.sld.base;

import lombok.NonNull;
import lombok.Setter;

/**
 * Created by diwu.sld on 2017/4/12.
 */
public class ResultBuilder<T> {

    private T model;

    @Setter
    private boolean isSuccess;

    @Setter
    private String errorMsg;

    public  static ResultBuilder newResult(){
        return  new ResultBuilder();
    }

    public Result build(){
        return  new Result(this.model, this.isSuccess, this.errorMsg);
    }

    public  Result buildError(){
        return  new Result(null, false, this.errorMsg);
    }

    public  Result buildSuccess(){
        return  new Result(this.model, true);
    }

    public ResultBuilder setModel(T model){
        this.model = model;
        return  this;
    }

    public  ResultBuilder setIsSuccess(boolean isSuccess){
        this.isSuccess = isSuccess;
        return  this;
    }

    public  ResultBuilder setErrorMsg(String errorMsg){
        this.errorMsg = errorMsg;
        return  this;
    }


}
