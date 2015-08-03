package com.github.binitabharati.wget4j.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

import junit.framework.TestCase;

public class URLConnectionReader extends TestCase {
	
	//@Test
	/**
	 * 
	 * @throws Exception
	 * Gets the same data that is obtained when we do a View->Page source.
	 * Eg you can reconstruct a html file using URLConnection. 
	 * (Of course you can not follow links in html like wget does, 
	 * but plain html can be obtained) 
	 * 
	 * 
	 */
	/*public void testReadUrlToString() throws Exception
	{
		URL exampleUrl = new URL("http://www.example.com");
        URLConnection yc = exampleUrl.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(//InputStreamRaeder converts byte stream into char stream
                                yc.getInputStream()));//inputStream is a byte stream.
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println("Printing line - "+inputLine);//each line is one line in the View->Page Source
        in.close();
		
	}*/
	
	@Test
	/**
	 * http://stackoverflow.com/questions/3221979/reading-binary-file-from-urlconnection
	 * tar url taken from - http://www.cyberciti.biz/tips/linux-wget-your-ultimate-command-line-downloader.html
	 * @throws Exception
	 */
	public void testReadTarFileFromUrl() throws Exception
	{
		URL exUrl = new URL("http://localhost:8080/eclipse-java-mars-R-win32-x86_64.tar");
		URLConnection uc = exUrl.openConnection();
		InputStream inputStream = uc.getInputStream();//in bytes
		
		byte[] buffer = new byte[4096];
		int n = - 1;//EOF reached

		OutputStream output = new FileOutputStream(new File("eclipse-java-mars-R-win32-x86_64.tar"));
		while ( (n = inputStream.read(buffer)) != -1)
		{
		    if (n > 0)
		    {
		        output.write(buffer, 0, n);
		    }
		}
		output.close();
       
	}

}
