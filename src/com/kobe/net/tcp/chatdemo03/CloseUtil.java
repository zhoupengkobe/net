package com.kobe.net.tcp.chatdemo03;

import java.io.Closeable;

/**
 * �ر����ķ���
 * @author ko
 *
 */
public class CloseUtil {

	public static void closeAll(Closeable... io){
		for (Closeable temp : io) {
			try {
				if (null != temp) {
					temp.close();
				} 
			} catch (Exception e) {
				
			}
		}
	}

}