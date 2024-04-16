package com.Rd.Chatapp.network;

import java.io.IOException;
//import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.Rd.Chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serverSoket;
	ArrayList<ServerWorker>workers=new ArrayList<>();
	public Server() throws IOException {
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSoket=new ServerSocket(PORT);
		System.out.println("Server start and waiting for the clients to join");
		handleClientRequest();
		
	}
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket=serverSoket.accept();
			ServerWorker serverworker =new ServerWorker(clientSocket,this);
			workers.add(serverworker);
			serverworker.start();
			}
	}
//	public Server() throws IOException {
//		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
//		serverSoket=new ServerSocket(PORT);
//		System.out.println("Server Started and waiting for client connectin ..");
//		Socket socket=serverSoket.accept();
//		System.out.println("Client join the Server ");
//		InputStream in=socket.getInputStream();
//		byte arr[]=in.readAllBytes();
//		String str=new String(arr);
//		System.out.println("Message received from the Client "+str);
//		in.close();
//		socket.close();
//	}
	public static void main(String[] args) throws IOException {
		Server server=new Server();
	}
}
