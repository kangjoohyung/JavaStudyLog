package ex0817.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChatExam {
	Socket sk;
    public ClientChatExam() {
    	try{
    		sk =  new Socket("127.0.0.1",8888);
    		System.out.println("������ ä���� �����մϴ�.....");
    		
    		//������ ������
    		new SendThread(sk, "CLIENT").start();
    		
    		//�޴� ������ 
    		new Thread(()->{
    			try(BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))){
    				while(true) {
    					String input = br.readLine();
    					if(input.equals("exit"))break;
    					
    					System.out.println(input);
    				}
    				
    				System.out.println("Client�� �޴½����� �����մϴ�....");
    				
    				
    			}catch (Exception e) {
    				System.out.println("ClientExamdml �޴� ������ catch ���Դϴ�....");
				}finally {
					System.exit(0);
				}
    			
    			
    		}).start();
    		
    	}catch(Exception e){
    		System.out.println("Client�� ������ ���� catch ���Դϴ�. ....");
    	}
    }
	public static void main(String[] args) {
		new ClientChatExam();

	}

}
