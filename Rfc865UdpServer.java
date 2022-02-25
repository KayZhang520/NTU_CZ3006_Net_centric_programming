package lab2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class Rfc865UdpServer {
	 public static void main(String[] argv) {
	 //
	 // 1. Open UDP socket at well-known port
	 //
	 System.out.println("Server is running...");
	 DatagramSocket socket=null;
	 byte[] buf = new byte[256];
	 try {
	 socket = new DatagramSocket(4445);
	 } catch (SocketException e) {}
	 while (true) {
	 try {
	 //
	 // 2. Listen for UDP request from client
	 //
	 DatagramPacket request = new DatagramPacket(buf,buf.length);
	 socket.receive(request);
	 
	 InetAddress address = request.getAddress();
	 int port = request.getPort();
	 
	 //
	 // 3. Send UDP reply to client
	 //
	 DatagramPacket reply = new DatagramPacket(buf,buf.length,address,port);
	 socket.send(reply);
	 } catch (IOException e) {}
	 }
	 }
	}