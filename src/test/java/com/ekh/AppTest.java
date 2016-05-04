package com.ekh;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.*;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("ukr.txt");
            java.io.OutputStreamWriter osw = new OutputStreamWriter( fos , "cp1125");
            String s = "[cp1125]->[Привіт  ЇЙЄЮЯ]";
            byte bytes[] = s.getBytes("cp1125");
            String s2 = new String(bytes, "cp1125");

            Assert.assertTrue( s.equals(s2));

            System.out.println(s2);
            osw.write(s);
            osw.flush();
            fos.close();
        } catch (UnsupportedEncodingException e) {
            Assert.fail(e.getMessage());
        }
        assertTrue(true);
    }
}
