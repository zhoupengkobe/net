package com.kobe.net.tcp.scoket;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����������������������ͻ���
 * 1.����������  ָ���˿�  ServerSocket(int port)
 * 2.���տͻ�������
 * 3.��������+��������
 * @author ko
 *
 */
public class MultiServer {
	public static void main(String[] args) throws IOException {
		//1.����������  ָ���˿�  ServerSocket(int port)

		ServerSocket server = new ServerSocket(8888);
		//2.���տͻ�������
		while (true) {//��ѭ��  һ��accept()һ���ͻ���
			Socket socket = server.accept();
			System.out.println("һ���ͻ��˽�������");
			//3.��������
			String msg = "��ӭʹ��";
			//�����
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		}
		
		
		
		
	}
	

}
