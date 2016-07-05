package com.kobe.net.tcp.chatdemo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端：发送数据+接收数据
 * 写出数据：输出流
 * 写入数据：输入流
 * 
 * 
 * 输入流与输出流在同一个线程内应该独立出来
 * @author ko
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建客户端
		Socket client =new Socket("localhost", 9999);
		//控制台输入
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						System.in));
		
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		DataInputStream dis = new DataInputStream(client.getInputStream());
		while (true) {
			String info = br.readLine();
			//写出数据+输出流
			dos.writeUTF(info);
			dos.flush();
			//输入流
			String msg = dis.readUTF();
			System.out.println(msg);
		}
	}

}
