package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		// 승인용 서버 소켓이 필요
		// 네트워크 프로그램은 외부 자원연결(예외처리)
		ServerSocket server = new ServerSocket(9200); // ip + port 
		System.out.println("승인용 서버 소켓 스타트");
		System.out.println("클라이언트의 요청을 기다리는중...");
		
		//승인이 떨어지면 통신용 소켓이 만들어짐 
		while(true) {
			Socket socket = server.accept(); //Socket
			 System.out.println("클라이언트와 통신가능한 통신용 소켓 만들어짐 ");
			 
			 
		}
		

	}

}
