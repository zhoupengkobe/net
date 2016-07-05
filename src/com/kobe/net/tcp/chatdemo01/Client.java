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
 * �����ͻ��ˣ���������+��������
 * д�����ݣ������
 * д�����ݣ�������
 * 
 * 
 * ���������������ͬһ���߳���Ӧ�ö�������
 * @author ko
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//�����ͻ���
		Socket client =new Socket("localhost", 9999);
		//����̨����
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						System.in));
		
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		DataInputStream dis = new DataInputStream(client.getInputStream());
		while (true) {
			String info = br.readLine();
			//д������+�����
			dos.writeUTF(info);
			dos.flush();
			//������
			String msg = dis.readUTF();
			System.out.println(msg);
		}
	}

}
