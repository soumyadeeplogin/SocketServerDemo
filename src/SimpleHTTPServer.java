import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer {

	private static ServerSocket server;
	private static int port = 6161;

	public static void main(String[] args) throws IOException {
		try {
			server = new ServerSocket(port);
			while (true) {
				
				/*Socket clientSocket = server.accept();
				InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader reader = new BufferedReader(isr);
				String line = reader.readLine();
				while (!line.isEmpty()) {
					System.out.println(line);
					line = reader.readLine();
				}
				{
					Date today = new Date();
					String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
					clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
					break;
				}*/
				Socket clientSocket = server.accept();
				if(clientSocket.isConnected())
				{
					System.out.println("-----------Conncted-----------");
					InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
					BufferedReader reader = new BufferedReader(isr);
					String line = reader.readLine();
					while (!line.isEmpty()) {
						System.out.println(line);
						line = reader.readLine();
					}
					System.out.println("----------Responding------------");
					Date today = new Date();
					String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
					clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
					System.out.println("----------Breaking------------");
//					break;
				}
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			server.close();
		}

	}
}
