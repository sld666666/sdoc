package com.sld;

import com.sld.scheduler.SchedulerManager;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * SchedulerManager Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/11/2017</pre>
 */
public class SchedulerManagerTest extends TestCase {
    public SchedulerManagerTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: getInstance()
     */
    public void testGetInstance() throws Exception {
//TODO: Test goes here...
        assertNotNull(SchedulerManager.getInstance());
    }

    /**
     * Method: test()
     */
    public void testTest() throws Exception {
//TODO: Test goes here...
        SchedulerManager.getInstance().test();
        Thread.sleep(10000);
    }


    public static Test suite() {
        return new TestSuite(SchedulerManagerTest.class);
    }
} 
