package com.github.binitabharati.wget4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

import junit.framework.TestCase;

public class URLConnectionReader extends TestCase {
	
	@Test
	/**
	 * 
	 * @throws Exception
	 * Gets the same data that is obtained when we do a View->Page source.
	 */
	public void testReadUrlToString() throws Exception
	{
		URL yahoo = new URL("http://www.example.com");
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println("Printing line - "+inputLine);//each line is one line in the View->Page Source
        in.close();
		
	}

}
