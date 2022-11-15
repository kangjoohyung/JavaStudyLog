package ex0817.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatExam {
	Socket sk ;
     public ServerChatExam() {
    	 try(ServerSocket server = new ServerSocket(8888)){
    		 System.out.println("클라이언트 접속을 기다립니다.....");
    		  sk = server.accept();//
    		 System.out.println(sk.getInetAddress()+"님과 채팅을 시작합니다.^^");
    		 
    		 //읽기스레드
    		 new ServerReciveThread().start();
    		 
    		 //보내는 스레드 
    		 new SendThread(sk, "SERVER").start();
    		 
    		 
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
	public static void main(String[] args) {
		new ServerChatExam();

	}
	//////////////////////////////////////////////////////
	/**
	 *  클라이언트가 보내오는 데이터를 읽어서 모니터에 출력하는 스레드 
	 *  
	 * */
	class ServerReciveThread extends Thread{
		 @Override
		public void run() {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))){
				while(true) {
				  String input = br.readLine();
				  if(input.equals("exit"))break;
				  
				  System.out.println(input);//super.getName()+"가 보낸 내용 : " + inputData
				}
				
				System.out.println("서버 받는 스레드 종료합니다.^^");
				
			}catch (Exception e) {
				//e.printStackTrace();
				System.out.println("ServerReciveThread catch 발생 했습니다.......");
			}finally {
				System.exit(0);
			}
		}
	}
	

}//클래스끝











