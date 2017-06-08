package com.sld;

import com.sld.sdoc.markdown.utils.ConvertIgnoreUtil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ConvertIgnoreUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 18, 2017</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/bean-biz.xml"})
//@TestPropertySource(locations="classpath:test.properties")
public class ConvertIgnoreUtilTest extends MarkdownBaseTest{

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isIngoreFolder(String ingore, String folderName)
     */
    @Test
    public void testIsIngoreFolder() throws Exception {
//TODO: Test goes here...
        boolean rtn = ConvertIgnoreUtil.isIngoreFolder("\\..*", ".index");
        Assert.assertTrue(rtn);

        rtn = ConvertIgnoreUtil.isIngoreFolder("\\..*", "index");
        Assert.assertFalse(rtn);
    }


} 
