package ex0817.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerExam {
    public ServerExam() {
    	try(ServerSocket server = new ServerSocket(8000)){
    		while(true) {
    			System.out.println("클라이언트 접속을 대기중입니다....^^");
    			Socket sk = server.accept();//클라이언트 접속 대기중
    			
    			System.out.println(sk.getInetAddress()+"님 접속하셨습니다. ");
    			
    			//접속한 클라이언트로 부터 전송된 데이터 읽기
    			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream())) ;
    			String data = br.readLine();
    			System.out.println("클라이언트가 보내온 내용 : " + data );
    			
    			//접속한 클라이언트에게 데이터 전송하기
    			PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
    			pw.println("서버에 접속하신걸 환영합니다.~~~~");
    			
    			sk.close();
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	public static void main(String[] args) {
		new ServerExam();

	}

}
