package com.kobe.net.tcp.chatdemo04;

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
 * ��������
 * ���������������ͬһ���߳���Ӧ�ö�������
 * @author ko
 * 
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("����������");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		if (name.equals("")) {
			return;
		}
		//�����ͻ���
		Socket client =new Socket("localhost", 9999);
		//����̨������
		new Thread(new Send(client,name)).start();//һ��·��
		new Thread(new Receive(client)).start();//һ��·��
		}
	}


