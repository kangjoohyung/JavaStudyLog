package ex0818.multiChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerChatGUIExam {
	Socket sk;
	String userIp;
	List<ClientSocketThread> list=new ArrayList<ServerChatGUIExam.ClientSocketThread>();
	
	public ServerChatGUIExam() {
		try(ServerSocket server=new ServerSocket(8000)){
			while(true) {
				System.out.println("CLIENT 접속 대기중입니다");
				sk=server.accept();
				userIp=sk.getInetAddress().toString();
				System.out.println(userIp+"님 접속 되셨습니다");
				
				//접속된 클라이언트를 Thread로 만들어서 저장소(List)에 저장한다
				ClientSocketThread th=new ClientSocketThread();
				list.add(th);
				
				th.start();
				
				System.out.println("[접속 인원수]"+list.size()+"명");
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ServerChatGUIExam();
	}
	/**
	 * List에 저장된 ClientSocketThread를 꺼내서 모든 USER에게 메세지를 전송하는 기능
	 *
	 */
	public void sendMessage(String message) {
		for(ClientSocketThread th:list) {
			th.pw.println(message);			
		}
	}
//////////////////////////////////////
	class ClientSocketThread extends Thread{
		PrintWriter pw;
		BufferedReader br;
		String nicName;
		
		@Override
		public void run() {
			try {
				//읽기
				br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
				
				//쓰기
				pw=new PrintWriter(sk.getOutputStream(), true);
				
				//대화명 읽기
				nicName=br.readLine();
				
				//모든 User에서 "~님 입장하셨습니다" 메세지 전송한다
				sendMessage(nicName+"님이 입장하셨습니다");
				
				String inputData=null;
				while((inputData=br.readLine())!=null) {
					//접속된 모든 클라이언트에게 데이터를 전송한다
					sendMessage("["+nicName+"]"+inputData);
				}
			}catch(Exception e) {
				e.printStackTrace();
				//현재 스레드에 해당하는 클라이언트의 Socket이 닫힌 상태이기 때문에 예외 발생
				//list에서 제거
				list.remove(this);
				
				//남아있는 모든 USER에게 알린다.
				sendMessage("["+nicName+"]"+"님이 퇴장하셨습니다");
				
				//서버창에도 알린다.
				System.out.println("["+nicName+"]"+"님이 퇴장하셨습니다|현재 접속인원"+list.size());
			}
		}
	}
}//클래스 끝
