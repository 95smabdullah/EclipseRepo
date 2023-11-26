package day7.hrmcq.q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
	  public static void main(String[] args) {
	    int port = 7000;
	            try 
	        (
	             ServerSocket serverSocket = new ServerSocket(port);
	             Socket socket = serverSocket.accept();
	             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	             BufferedReader in = new BufferedReader(new 
	             InputStreamReader(socket.getInputStream()));
	        )
	       


	        {
	             String inputLine = in.readLine();
	             socket.getOutputStream().write(
	             inputLine.getBytes(StandardCharsets.UTF_8));
	               
	      }


	            catch (IOException e)


	        {
	             
	    }
	  }
	}