package com.kobe.net.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 获取资源：源代码
 * @author ko
 *
 */
public class URLDemo02 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");//主页  默认资源
		
//		//获取资源网络流
//		InputStream is = url.openStream();
//		byte[] flush = new byte[1024];
//		int len = 0;
//		while (-1!=(len=is.read(flush))) {
//			System.out.println(new String(flush,0,len));
//		}
//		is.close();
		
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(url.openStream(), "utf-8"));
		
		BufferedWriter bw = 
				new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream("baidu.html"),"utf-8"));
		
		
		String msg = null;
		while ((msg=br.readLine())!=null) {
//			System.out.println(msg);
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
