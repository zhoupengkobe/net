package com.kobe.net.tcp.scoket;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 必须先启动服务器再启动客户端
 * 1.创建服务器  指定端口  ServerSocket(int port)
 * 2.接收客户端连接
 * 3.发送数据+接收数据
 * @author ko
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		//1.创建服务器  指定端口  ServerSocket(int port)

		ServerSocket server = new ServerSocket(8888);
		//2.接收客户端连接
		Socket socket = server.accept();
		System.out.println("一个客户端建立连接");
		//3.发送数据
		String msg = "欢迎使用";
		//输出流
//		BufferedWriter bw = new BufferedWriter(
//				new OutputStreamWriter(
//						socket.getOutputStream()));
//		bw.write(msg);
//		bw.newLine();
//		bw.flush();
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		
		
		
		
	}
	

}
