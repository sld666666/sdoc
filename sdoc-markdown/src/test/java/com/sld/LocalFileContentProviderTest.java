package com.sld;

import com.sld.sdoc.markdown.service.IContentProvider;
import com.sld.sdoc.markdown.service.impl.LocalFileContentProvider;

import junit.framework.Test;
import junit.framework.TestSuite; 
import junit.framework.TestCase;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;


/** 
* LocalFileContentProvider Tester. 
* 
* @author <Authors name> 
* @since <pre>04/20/2017</pre> 
* @version 1.0 
*/ 
public class LocalFileContentProviderTest extends TestCase { 
public LocalFileContentProviderTest(String name) { 
super(name); 
} 

public void setUp() throws Exception { 
super.setUp(); 
} 

public void tearDown() throws Exception { 
super.tearDown(); 
} 

/** 
* 
* Method: readContent(String filePath) 
* 
*/ 
public void testReadContent() throws Exception {
    IContentProvider provider = new LocalFileContentProvider();
    byte [] rtn =  provider.readContent(getAbsolutePath("example/markdown/example01.md"));
    assertTrue(new String(rtn).contains("test"));
//TODO: Test goes here... 
} 

private String getAbsolutePath(String name){
    URL url = LocalFileContentProviderTest.class.getResource("/"+name);
    try {
        return Paths.get(url.toURI()).toFile().getAbsolutePath();
    } catch (URISyntaxException e) {
        return "";
    }

}


public static Test suite() { 
return new TestSuite(LocalFileContentProviderTest.class); 
} 
} 
