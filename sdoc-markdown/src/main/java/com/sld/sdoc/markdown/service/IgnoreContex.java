package com.sld.sdoc.markdown.service;

import lombok.Data;

/**
 * Created by diwu.sld on 2017/5/18.
 */

@Data
public class IgnoreContex {
    private final String ignoreFolder;

    public IgnoreContex(String ignoreFolder) {
        this.ignoreFolder = ignoreFolder;
    }


}
