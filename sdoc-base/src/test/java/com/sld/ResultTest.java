package com.sld;

import com.sld.base.Result;
import com.sld.base.ResultBuilder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import lombok.Data;

/**
 * Unit test for simple App.
 */
public class ResultTest
    extends TestCase
{
    @Data
    private class Person{
        private String name;
        private int age;
    }
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ResultTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ResultTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void test_build()
    {
        Person person = new Person();
        person.setName("sld");
        person.setAge(100);
        Result<Person> result = ResultBuilder.newResult()
                .setModel(person)
                .setIsSuccess(true)
                .build();
        assertNotNull(result);
        assertTrue( result.isSuccess() );
        Person tmp = result.getModel();
        assertEquals(tmp.getName(), person.getName());
    }

    public void test_buildError()
    {
        Result result = ResultBuilder.newResult()
                .setIsSuccess(false)
                .buildError();
        assertFalse( result.isSuccess() );
    }

    public void test_buildSuccess()
    {
        Result result = ResultBuilder.newResult()
                .buildSuccess();

        assertTrue( result.isSuccess() );
    }
}
