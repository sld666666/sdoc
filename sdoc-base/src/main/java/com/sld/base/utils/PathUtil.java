package com.sld.base.utils;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Created by diwu.sld on 2017/5/10.
 */
public final class PathUtil {
    private PathUtil(){}

    public static  String getAbsolutePath(Class<?> clz, String name){
        URL url = clz.getClass().getResource("/"+name);
        try {
            return Paths.get(url.toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            return "";
        }

    }
}
