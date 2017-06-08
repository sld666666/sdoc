package com.sld.biz;

import com.sld.base.Result;
import com.sld.base.ResultBuilder;
import com.sld.sdoc.markdown.service.IMarkdownService;
import com.sld.sdoc.markdown.service.IgnoreContex;
import com.sld.sdoc.markdown.service.impl.LocalFileContentProvider;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by diwu.sld on 2017/5/15.
 */
@Service("blogManager")
public class BlogManager {
    @Resource
    ApplicationConstant applicationConstant;

    @Resource
    private GitHubManager gitHubManager;

    @Resource
    private IMarkdownService  pageDownMarkdownService;

    public  Result<String> refresh(){
        //1. 取配置
        //2. git pull
        boolean rtn = gitHubManager.gitPull(applicationConstant.BLOG_LOCAL_PATH);
        //3. md convert to html

        Result<String> result = pageDownMarkdownService.convertToHtml(new LocalFileContentProvider(),
                applicationConstant.BLOG_LOCAL_PATH,
                applicationConstant.BLOG_LOCAL_TARGET_PATH,
                new IgnoreContex(applicationConstant.BLOG_LOCAL_TARGET_PATH));

        //4. 目录，标题等

        return ResultBuilder.newResult().buildSuccess();
    }
}
