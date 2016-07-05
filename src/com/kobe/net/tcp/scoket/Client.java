package com.kobe.net.tcp.scoket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1.�����ͻ��� ����ָ��������+�˿�  ��ʱ��������
 * 2.��������
 * @author ko
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.�����ͻ��� ����ָ��������+�˿�  ��ʱ��������
		Socket client = new Socket("localhost", 8888);
		//2.��������
//		BufferedReader br = new BufferedReader(
//				new InputStreamReader(client.getInputStream()));
//		
//		String echo = br.readLine();
//		System.out.println(echo);
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String echo = dis.readUTF();
		System.out.println(echo);
	}
	
}
