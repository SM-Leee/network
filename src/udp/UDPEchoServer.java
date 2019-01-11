package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	public static final int PORT = 6000;
	private static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		DatagramSocket socket = null;
		
		try {
			//1. socket 생성
			socket = new DatagramSocket(PORT);
			
			//2. 데이터 수신
			DatagramPacket receivePacket = 
					new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
			socket.receive(receivePacket);
			
			byte[] data = receivePacket.getData();
			int length = receivePacket.getLength();
			String message = new String(data, 0, length, "UTF-8");
			System.out.println("[server] received:" + message);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			if(socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}
		
	}

}
