package com.Rd.Chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

//Thread ==Worker
public class ServerWorker extends Thread{
	 private Socket clientSocket;
	 private InputStream in;
	 private OutputStream out;
	 private Server server;
	 public ServerWorker(Socket clientSocket,Server server) throws IOException {
		 this.server=server;
		 this.clientSocket=clientSocket;
		 in=clientSocket.getInputStream();
		 out=clientSocket.getOutputStream();
		 System.out.println("New Client comes ");
		 // TODO Auto-generated constructor stub
	}

	public void run() {
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String line;
		try {
		while(true) {
			
				line=br.readLine();// \n
				System.out.println("Line Read .... "+line);
				if(line.equalsIgnoreCase("quit")) {
					break;
				}
				//out.write(line.getBytes());
				for( ServerWorker serverWorker : server.workers) {
					line=line+"\n";
					serverWorker.out.write(line.getBytes());
				}
			
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
			if(br!=null) {
				br.close();
			}
			if(in!=null) {
				in.close();
			}
			if(out!=null) {
				out.close();
			}
			if(clientSocket!=null) {
				clientSocket.close();
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
//public class ServerWorker implements Runnable {
//public class ServerWorker extends Thread{
//	public void run() {
//	for(int i=1;i<=5;i++) {
//		System.out.println("RUN I is "+i+" "+Thread.currentThread());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	}
//	public static void main(String[] args) {
//		///ServerWorker job=new ServerWorker();
//		ServerWorker worker=new ServerWorker();
//		worker.start();
//		//Assign the  job to a Thrad/Worker
//		Thread worker=new Thread(job,"Worker1");
//	worker.start();
//	
//		for(int j=1;j<=5;j++) {
//			System.out.println("Main "+j +" "+Thread.currentThread());
//		}
//	}
//}
