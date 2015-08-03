package com.github.binitabharati.wget4j.test;

import java.io.File;

import com.github.binitabharati.wget4j.Options;
import com.github.binitabharati.wget4j.impl.WgetImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws Exception 
     */
    public void testApp() throws Exception
    {
        //assertTrue( true );
    	WgetImpl wgetImpl = new WgetImpl();
    	
    	Options options = new Options();
    	//options.DONWLOAD_FILE = "C:\\work\\eclipseWS\\wget4j\\test.tar";
    	
    	wgetImpl.wget("http://localhost:8080/openss7-1.1.7.20131207.tar", options);
    }
}
