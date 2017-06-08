package com.sld.biz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by diwu.sld on 2017/5/16.
 */
@Service("applicationConstant")
public class ApplicationConstant {
    @Value("${blog.local.source.path}")
    public   String BLOG_LOCAL_PATH;

    @Value("${blog.local.target.path}")
    public String BLOG_LOCAL_TARGET_PATH;

    @Value("${blog.convert.folder.ignore}")
    public String BLOG_CONVERT_FOLDER_IGNORE;

}
