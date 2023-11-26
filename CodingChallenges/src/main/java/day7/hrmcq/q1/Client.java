package day7.hrmcq.q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
	
	public static void main(String[] args) {
		
	
	
		try (Socket socket = new Socket("localhost", 7000);
			     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

			    socket.getOutputStream().write("hello".getBytes(StandardCharsets.UTF_8));
			    String userInput = in.readLine();
			    System.out.println(userInput);

			} catch (IOException e) {
			    // Handle exception
			}



	}
}
