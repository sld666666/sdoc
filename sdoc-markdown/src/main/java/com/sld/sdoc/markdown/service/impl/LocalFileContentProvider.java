package com.sld.sdoc.markdown.service.impl;

import com.sld.sdoc.markdown.service.IContentProvider;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.extern.java.Log;


/**
 * Created by diwu.sld on 2017/4/14.
 */
@Log
@Service("localFileContentProvider")
public class LocalFileContentProvider implements IContentProvider {

    @Override
    public byte[] readContent(String filePath) {

        try {
            return Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            //log.error(e);
            return new byte[0];
        }
    }

    @Override
    public byte[] readContent(Path filePath) {
        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            //log.error(e);
            return new byte[0];
        }
    }
}
