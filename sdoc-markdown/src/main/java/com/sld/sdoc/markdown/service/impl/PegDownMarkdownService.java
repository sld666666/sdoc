package com.sld.sdoc.markdown.service.impl;

import com.sld.base.Result;
import com.sld.sdoc.markdown.biz.MarkdownFolderProvider;
import com.sld.sdoc.markdown.biz.MarkdownFolderVisitor;
import com.sld.sdoc.markdown.service.IContentProvider;
import com.sld.sdoc.markdown.service.IMarkdownService;


import javax.validation.constraints.NotNull;
import com.sld.base.ResultBuilder;
import com.sld.sdoc.markdown.service.IgnoreContex;

import org.pegdown.PegDownProcessor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by diwu.sld on 2017/4/20.
 */

@Service("pegDownMarkdownService")
public class PegDownMarkdownService implements IMarkdownService {
    private PegDownProcessor pegDownProcessor = new PegDownProcessor();

    @Override
    public Result convertToHtml(@NotNull IContentProvider contentProvider,
                                @NotNull String sourcePath,
                                @NotNull String targetPath
                                ,@NotNull IgnoreContex ignoreContex) {
        Path path = Paths.get(sourcePath);
        try {
            Files.walkFileTree(path, new MarkdownFolderVisitor(
                    new MarkdownFolderProvider(Paths.get(sourcePath),
                            Paths.get(targetPath),
                            ignoreContex,
                            contentProvider)));
        } catch (IOException e) {
            return ResultBuilder.newResult().setErrorMsg(e.getMessage()).buildError();
        }
        return ResultBuilder.newResult().buildSuccess();
    }

    @Override
    public Result<String> convertToHtml(@NotNull IContentProvider contentProvide,
                                        @NotNull String filePath
                                        ,@NotNull IgnoreContex ignoreContex) {

        String content = new String (contentProvide.readContent(filePath));
        String rtn = this.pegDownProcessor.markdownToHtml(content);
        return ResultBuilder.newResult().setModel(rtn).buildSuccess();

    }
}
