package lab2;

/*Name: Rajagopal Tejas R
Group: SSP6
IP Address: 172.21.147.145
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class Rfc865UdpClient {

		 public static void main(String[] argv) throws UnknownHostException, SocketException {
		 //
		 // 1. Open UDP socket
		 //
		 System.out.println("Client is running...");
		 
		 DatagramSocket socket = new DatagramSocket();
		 InetAddress address = InetAddress.getByName("swlab2-c.scse.ntu.edu.sg");

		 try {
		 //
		 // 2. Send UDP request to server
		 //
		 String msg = new String("Tejas Rajagopal, SSP6, 172.21.147.145");
		 byte[] buf = msg.getBytes();
		 DatagramPacket request = new DatagramPacket(buf,buf.length,address,17);
		 socket.send(request);
		 //
		 // 3. Receive UDP reply from server
		 //
		 DatagramPacket reply = new DatagramPacket(buf,buf.length);
		 socket.receive(reply);
		 String received = new String(reply.getData(),0,reply.getLength());
		 System.out.println(received);
		 } catch (IOException e) {}
		 
		 System.out.println("Closing socket...");
		 socket.close();
		 }
		

}
