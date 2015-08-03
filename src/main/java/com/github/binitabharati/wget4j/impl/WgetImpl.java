package com.github.binitabharati.wget4j.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import com.github.binitabharati.wget4j.Options;
import com.github.binitabharati.wget4j.Wget;

public class WgetImpl implements Wget{

	public void wget(String url, Options options) throws Exception {
		// TODO Auto-generated method stub
		
		URL urlObj = new URL(url);
		URLConnection uc = urlObj.openConnection();
		InputStream inputStream = uc.getInputStream();//in bytes
		
		byte[] buffer = new byte[4096];
		int n = - 1;//EOF reached

		File downloadFile = null;
		if(Options.DONWLOAD_FILE != null)
		{
			downloadFile = new File(Options.DONWLOAD_FILE);
		}
		else //extract file name from URL.
		{
			String[] urlSplit = url.split("/");
			downloadFile = new File(urlSplit[urlSplit.length - 1]);
		}
		OutputStream output = new FileOutputStream(downloadFile);
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
