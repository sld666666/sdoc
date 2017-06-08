package com.sld;

import com.sld.base.Result;
import com.sld.base.utils.PathUtil;
import com.sld.sdoc.markdown.service.IContentProvider;
import com.sld.sdoc.markdown.service.IMarkdownService;
import com.sld.sdoc.markdown.service.IgnoreContex;
import com.sld.sdoc.markdown.service.impl.LocalFileContentProvider;
import com.sld.sdoc.markdown.service.impl.PegDownMarkdownService;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * PegDownMarkdownService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/10/2017</pre>
 */
public class PegDownMarkdownServiceTest extends TestCase {

    IMarkdownService markdownService = new PegDownMarkdownService();
    IContentProvider contentProvider = new LocalFileContentProvider();

    public PegDownMarkdownServiceTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: convertToHtml(@NotNull IContentProvider contentProvider, @NotNull String sourcePath,
     * @NotNull String targetPath)
     */
    public void testConvertToHtmlForContentProviderSourcePathTargetPath() throws Exception {
//TODO: Test goes here...
        Result result = markdownService.convertToHtml(this.contentProvider
                , PathUtil.getAbsolutePath(PegDownMarkdownServiceTest.class, "example/markdown")
                , PathUtil.getAbsolutePath(PegDownMarkdownServiceTest.class, "example/html")
                , new IgnoreContex(""));

        assertTrue (result.isSuccess());
    }

    /**
     * Method: convertToHtml(@NotNull IContentProvider contentProvide, @NotNull String filePath)
     */
    public void testConvertToHtmlForContentProvideFilePath() throws Exception {
//TODO: Test goes here...

        Result<String> result = markdownService.convertToHtml(this.contentProvider,
                PathUtil.getAbsolutePath(PegDownMarkdownServiceTest.class,
                        "example/markdown/example01.md"),
                        new IgnoreContex(""));

        assertTrue(result.isSuccess());
        assertTrue(result.getModel().contains("test"));
    }


    public static Test suite() {
        return new TestSuite(PegDownMarkdownServiceTest.class);
    }
} 
