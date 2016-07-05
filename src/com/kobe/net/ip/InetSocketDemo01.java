package com.kobe.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 封装端口：在InetAddress基础上+端口
 * 
 * @author ko
 *
 */
public class InetSocketDemo01 {

	public static void main(String[] args) {
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
		
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		
		InetAddress addr = address.getAddress();
		System.out.println(addr.getHostAddress());//返回：地址
		System.out.println(addr.getHostName());//输出计算机名

	}

}
