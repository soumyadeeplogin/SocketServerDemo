//package roy.com.socketserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {
	private static ServerSocket server;
	private static int port = 9876;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		server = new ServerSocket(port);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("Waiting for the client request");
			Socket socket = server.accept();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			System.out.println("From Client: " + message);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(br.readLine());
			ois.close();
	        oos.close();
	        socket.close();
	        if(message.equalsIgnoreCase("EXIT")) 
	        	break;
		}
		br.close();
		System.out.println("Shutting down Socket server!!");
        server.close();
	}
}
