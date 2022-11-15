package ex0817.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChatExam {
	Socket sk;
    public ClientChatExam() {
    	try{
    		sk =  new Socket("127.0.0.1",8888);
    		System.out.println("서버와 채팅을 시작합니다.....");
    		
    		//보내는 스레드
    		new SendThread(sk, "CLIENT").start();
    		
    		//받는 스레드 
    		new Thread(()->{
    			try(BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))){
    				while(true) {
    					String input = br.readLine();
    					if(input.equals("exit"))break;
    					
    					System.out.println(input);
    				}
    				
    				System.out.println("Client쪽 받는스레드 종료합니다....");
    				
    				
    			}catch (Exception e) {
    				System.out.println("ClientExamdml 받는 스레드 catch 블럭입니다....");
				}finally {
					System.exit(0);
				}
    			
    			
    		}).start();
    		
    	}catch(Exception e){
    		System.out.println("Client쪽 생성자 예외 catch 블럭입니다. ....");
    	}
    }
	public static void main(String[] args) {
		new ClientChatExam();

	}

}
