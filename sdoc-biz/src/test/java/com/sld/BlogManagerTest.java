package com.sld;

import com.sld.base.Result;
import com.sld.biz.BlogManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import javax.annotation.Resource;

/**
 * BlogManager Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 18, 2017</pre>
 */
public class BlogManagerTest extends BizBaseTest {
    @Resource
    private BlogManager blogManager;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: refresh()
     */
    @Test
    public void testRefresh() throws Exception {
//TODO: Test goes here...
        Result<String> result = blogManager.refresh();
        Assert.assertTrue(result.isSuccess());
    }


} 
