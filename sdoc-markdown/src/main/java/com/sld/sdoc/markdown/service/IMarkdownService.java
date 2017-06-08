package com.sld.sdoc.markdown.service;

import com.sld.base.Result;
/**
 * Created by diwu.sld on 2017/4/12.
 */
public interface IMarkdownService {

    /**
     * 把目标文件下的所有markdown 都转换为html文件
     * @param sourcePath
     * @param targetPath
     * @return
     */

    Result convertToHtml(IContentProvider contentProvide
                        , String sourcePath
                        , String targetPath
                        , IgnoreContex ignoreContex);

    /**
     *把单个文件转换为html
     * @param filePath
     * @return
     */
    Result<String> convertToHtml(IContentProvider contentProvide
                                , String filePath
                                , IgnoreContex ignoreContex);
}
