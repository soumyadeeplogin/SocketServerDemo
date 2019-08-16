//package roy.com.socketserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SockerClientDemo {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
//        for(int i=0; i<5;i++){
//            //establish socket connection to server
//            socket = new Socket(host.getHostName(), 9876);
//            //write to socket using ObjectOutputStream
//            oos = new ObjectOutputStream(socket.getOutputStream());
//            System.out.println("Sending request to Socket Server");
//            if(i==4)oos.writeObject("exit");
//            else oos.writeObject(""+i);
//            //read the server response message
//            ois = new ObjectInputStream(socket.getInputStream());
//            String message = (String) ois.readObject();
//            System.out.println("Message: " + message);
//            //close resources
//            ois.close();
//            oos.close();
//            Thread.sleep(100);
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
        	String keyboard = br.readLine();
        	socket = new Socket(host.getHostName(), 9876);
        	oos = new ObjectOutputStream(socket.getOutputStream());
        	System.out.println("Sending request to Socket Server");
//        	oos.writeObject(keyboard);
        	ois = new ObjectInputStream(socket.getInputStream());
        	String message = (String) ois.readObject();
        	System.out.println("From Server: " + message);
        	ois.close();
        	oos.close();
        	socket.close();
        	if(message.equals("EXIT"))
        	{
        		
        		break;
        	}
        }
        br.close();
	}
}
