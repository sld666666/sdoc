package com.sld.sdoc.markdown.biz;

import com.sld.base.Result;
import com.sld.base.ResultBuilder;
import com.sld.sdoc.markdown.service.IContentProvider;
import com.sld.sdoc.markdown.service.IgnoreContex;
import com.sld.sdoc.markdown.utils.ConvertIgnoreUtil;

import org.pegdown.PegDownProcessor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.constraints.NotNull;

/**
 * Created by diwu.sld on 2017/4/20.
 */
public  final class MarkdownFolderProvider {
    private PegDownProcessor pegDownProcessor = new PegDownProcessor();
    private final Path souceRoot;
    private final Path targetPath;
    private final IContentProvider contentProvider;
    private final  IgnoreContex ignoreContex;


    public MarkdownFolderProvider(Path souceRoot,
                                  Path tagetPath,
                                  IgnoreContex ignoreContex,
                                  IContentProvider contentProvider) {
        this.souceRoot = souceRoot;
        this.targetPath = tagetPath;
        this.contentProvider =contentProvider;
        this.ignoreContex = ignoreContex;
    }

    public boolean contentToWrite(Path sourceFile){
        String content = new String (this.contentProvider.readContent(sourceFile));
        String rtn = this.pegDownProcessor.markdownToHtml(content);
        try {
            Files.write(getTargetFilePath(sourceFile), rtn.getBytes());
        } catch (IOException e) {
            return  false;
        }
        return  true;
    }

    public boolean createFolder(Path dir){
        return  false;
    }

    public Result<String> convertToHtml( @NotNull String markdownContent){
        String rtn = this.pegDownProcessor.markdownToHtml(markdownContent);
        return ResultBuilder.newResult().setModel(rtn).buildSuccess();
    }

    public  boolean isFolderIngnore(String folderName){
        return ConvertIgnoreUtil.isIngoreFolder(this.ignoreContex.getIgnoreFolder(), folderName);
    }

    private Path getTargetFilePath(Path soucePath){
        String targetFileName = soucePath.getFileName().toString().replace(".md", ".html");
        return this.targetPath.resolve(targetFileName);
    }

}
