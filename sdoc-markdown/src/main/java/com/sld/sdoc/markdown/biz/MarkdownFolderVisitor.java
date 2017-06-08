package com.sld.sdoc.markdown.biz;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

/**
 * Created by diwu.sld on 2017/4/20.
 */
public class MarkdownFolderVisitor implements FileVisitor<Path> {
    private final MarkdownFolderProvider folderProvider;

    public MarkdownFolderVisitor(MarkdownFolderProvider folderProvider){
        this.folderProvider =  folderProvider;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException
    {
        Objects.requireNonNull(file);
        Objects.requireNonNull(attrs);
        folderProvider.contentToWrite(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
            throws IOException
    {
        Objects.requireNonNull(dir);
        Objects.requireNonNull(attrs);
        if (!this.folderProvider.isFolderIngnore(dir.getFileName().toString())){

        }
        return FileVisitResult.CONTINUE;
    }


    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        Objects.requireNonNull(file);
        throw exc;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        Objects.requireNonNull(dir);
        if (exc != null)
            throw exc;
        return FileVisitResult.CONTINUE;
    }



}
