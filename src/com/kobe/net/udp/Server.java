package com.kobe.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.lang.management.BufferPoolMXBean;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务端
 * 1.创建服务端+端口
 * 2.准备接受容器
 * 3.封装成包
 * 4.接收数据
 * 5.分析数据   字节数组--->double 字节数组输入流
 * 6.释放
 * @author ko
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		//1.创建服务端+端口
		DatagramSocket server = new DatagramSocket(8888);
		//2.准备接受容器
		byte[] container = new byte[1024];
		//3.封装成包
		DatagramPacket packet = new DatagramPacket(container, container.length);
		//4.接受数据
		server.receive(packet);
		//5.分析数据
		double data = convert(packet.getData());
		System.out.println(data);
		//6.释放
		server.close();
	}
	
	/**
	 * 字节数组+Data  输入流
	 * @throws IOException 
	 */
	
	public static double convert(byte[] data) throws IOException{
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		double num = dis.readDouble();
		dis.close();
		return num;
		
	}
	
}
