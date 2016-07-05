package com.kobe.net.tcp.chatdemo02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * �������� �߳�
 * @author ko
 *
 */
public class Send implements Runnable{
	//����̨������
	private BufferedReader console;
	//�ܵ������
	private DataOutputStream dos;
	//�����̵߳ı�ʶ
	private boolean isRunning = true;
	public Send() {
		console = new BufferedReader(
				new InputStreamReader(
						System.in));
	}
	
	public Send(Socket client) {
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
	}
	
	//1.�ӿ���̨�������ݣ�
	private String getMsgFromConsole(){
		try {
			return  console.readLine();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 1.�ӿ���̨�������ݣ�
	 * 2.�������ݣ�
	 */
	public void send(){
		String msg = getMsgFromConsole();
		try {
			if (null != msg && !msg.equals("")) {
				dos.writeUTF(msg);
				dos.flush();//ǿ��ˢ��
			} 
		} catch (Exception e) {
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
	}
	
	
	@Override
	public void run() {
		while (isRunning) {
			send();
		}
	}

}
