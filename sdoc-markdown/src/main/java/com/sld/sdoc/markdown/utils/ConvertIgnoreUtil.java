package com.sld.sdoc.markdown.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by diwu.sld on 2017/5/18.
 */
public final class ConvertIgnoreUtil {

    private ConvertIgnoreUtil(){

    }

    public static boolean isIngoreFolder(String ingore, String folderName){
        Pattern patter = Pattern.compile(ingore);
        Matcher matcher = patter.matcher(folderName);
        return  matcher.find();

    }
}
