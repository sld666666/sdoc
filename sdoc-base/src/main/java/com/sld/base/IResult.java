package com.sld.base;

import java.io.Serializable;

/**
 * Created by diwu.sld on 2017/4/12.
 */
public interface IResult{

    boolean isSuccess();
    String getErrorMsg();
}
