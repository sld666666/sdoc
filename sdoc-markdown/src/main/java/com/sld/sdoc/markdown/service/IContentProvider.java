package com.sld.sdoc.markdown.service;

import java.nio.file.Path;

/**
 * Created by diwu.sld on 2017/4/12.
 */
public interface IContentProvider {

    byte [] readContent(String filePath);

    byte [] readContent(Path filePath);
}
