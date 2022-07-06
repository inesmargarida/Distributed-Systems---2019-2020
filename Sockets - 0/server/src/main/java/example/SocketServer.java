package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;


public class SocketServer {
    
    public static void main( String[] args ) throws IOException {
        // Check arguments
        if (args.length < 1) {
            System.err.println("Argument(s) missing!");
            System.err.printf("Usage: java %s port%n", SocketServer.class.getName());
            return;
        }

        // Convert port from String to int
        final int port = Integer.parseInt(args[0]);

        // Create server socket
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.printf("Server accepting connections on port %d %n", port);

        // wait for and then accept client connection
        // a socket is created to handle the created connection
        Socket clientSocket = serverSocket.accept();
        final String clientAddress = clientSocket.getInetAddress().getHostAddress();
        final int clientPort = clientSocket.getPort();
        System.out.printf("Connected to client %s on port %d %n", clientAddress, clientPort);

        // Create buffered stream to receive data from client, one line at a time
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Receive data until client closes the connection
        String response;
        String Res;

        // Read a line of text.
        // A line ends with a line feed ('\n').
        response = in.readLine();
        System.out.printf("Received message with content: '%s'%n", response);
        //fullRes = response;


        //Separates response by parts
        String delims=" ";
        String[] components = response.split(delims, 3);
        int ASomar = Integer.parseInt(components[1]);
        ASomar++;
        Res = Integer.toString(ASomar);

        // Create stream to send data to client
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        // Send text to client as bytes
        out.writeBytes(Res);
        out.writeBytes("\n");
        System.out.println("Sent text: " + Res);

        // Close connection to current client
        clientSocket.close();
        System.out.println("Closed connection with client");

        // Close server socket
        serverSocket.close();
        System.out.println("Closed server socket");
    }
}
