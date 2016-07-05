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
 * �ͻ���
 * 1.�����ͻ���+�˿�
 * 2.׼������  double -->�ֽ�����  �ֽ����������
 * 3.���
 * 4.����
 * 5.�ͷ�
 * @author ko
 *
 */
public class Client {

	public static void main(String[] args) throws IOException {
		//1.�����ͻ���+�˿�
		DatagramSocket client = new DatagramSocket(6666);
		//2.׼������
		double num = 89.12;
		byte[] data = conver(num);
		//3.��������͵ĵص��Լ��˿ڣ�
		DatagramPacket packet = new DatagramPacket(
				data, data.length,new InetSocketAddress("localhost",8888));
		//4.����
		client.send(packet);
		//5.�ͷ�
		client.close();
	}
	
	/**
	 * �ֽ�����   ����Դ  +Data �����
	 * @throws IOException 
	 */
	
	public static byte[] conver(double num) throws IOException{
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();
		
		//��ȡ����
		data = bos.toByteArray();
		dos.close();
		return data;
	}

}
