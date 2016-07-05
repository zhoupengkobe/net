package com.kobe.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * 客户端
 * 1.创建客户端+端口
 * 2.准备数据  double -->字节数组  字节数组输出流
 * 3.打包
 * 4.发生
 * 5.释放
 * @author ko
 *
 */
public class Client {

	public static void main(String[] args) throws IOException {
		//1.创建客户端+端口
		DatagramSocket client = new DatagramSocket(6666);
		//2.准备数据
		double num = 89.12;
		byte[] data = conver(num);
		//3.打包（发送的地点以及端口）
		DatagramPacket packet = new DatagramPacket(
				data, data.length,new InetSocketAddress("localhost",8888));
		//4.发生
		client.send(packet);
		//5.释放
		client.close();
	}
	
	/**
	 * 字节数组   数据源  +Data 输出流
	 * @throws IOException 
	 */
	
	public static byte[] conver(double num) throws IOException{
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();
		
		//获取数据
		data = bos.toByteArray();
		dos.close();
		return data;
	}

}
