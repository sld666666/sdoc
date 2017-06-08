package com.sld.web.control;

import com.sld.base.Result;
import com.sld.biz.BlogManager;
import com.sld.biz.GitHubManager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import lombok.extern.log4j.Log4j;

/**
 * Created by diwu.sld on 2017/5/15.
 */

@RestController
@Log4j
public class BlogController {
    @Resource
    private BlogManager blogManager;

    @RequestMapping(value = "/refresh_blog", method = RequestMethod.POST)
    public String refreseBlog(){

        Result<String> result = blogManager.refresh();
        return "";
    }
}
