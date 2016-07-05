package com.kobe.net.tcp.chatdemo04;

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
	//����
	private String name;
	public Send() {
		console = new BufferedReader(
				new InputStreamReader(
						System.in));
	}
	
	public Send(Socket client,String name) {
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
			this.name=name;
			send(this.name);
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
	public void send(String msg){
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
			send(getMsgFromConsole());
		}
	}

}
