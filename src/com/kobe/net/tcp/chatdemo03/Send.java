package com.kobe.net.tcp.chatdemo03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据 线程
 * @author ko
 *
 */
public class Send implements Runnable{
	//控制台输入流
	private BufferedReader console;
	//管道输出流
	private DataOutputStream dos;
	//控制线程的标识
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
	
	//1.从控制台接收数据；
	private String getMsgFromConsole(){
		try {
			return  console.readLine();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 1.从控制台接收数据；
	 * 2.发送数据；
	 */
	public void send(){
		String msg = getMsgFromConsole();
		try {
			if (null != msg && !msg.equals("")) {
				dos.writeUTF(msg);
				dos.flush();//强制刷新
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
