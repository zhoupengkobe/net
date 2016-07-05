package com.kobe.net.tcp.chatdemo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * 写出数据：输出流
 * 写入数据：输入流
 * @author ko
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		//创建服务器  + 监听器
		ServerSocket server = new ServerSocket(9999);
		while (true) {
			Socket client = server.accept();
			
			//写出数据
			//输入流
			DataInputStream dis = new DataInputStream(client.getInputStream());
			//写出数据+输出流
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			
			while (true) {
				String msg = dis.readUTF();
				System.out.println(msg);
				dos.writeUTF("服务器--->"+msg);
				dos.flush();
			}
		}
		
		
	}

}
