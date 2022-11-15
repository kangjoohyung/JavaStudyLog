package ex0817.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatExam {
	Socket sk ;
     public ServerChatExam() {
    	 try(ServerSocket server = new ServerSocket(8888)){
    		 System.out.println("Ŭ���̾�Ʈ ������ ��ٸ��ϴ�.....");
    		  sk = server.accept();//
    		 System.out.println(sk.getInetAddress()+"�԰� ä���� �����մϴ�.^^");
    		 
    		 //�б⽺����
    		 new ServerReciveThread().start();
    		 
    		 //������ ������ 
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
	 *  Ŭ���̾�Ʈ�� �������� �����͸� �о ����Ϳ� ����ϴ� ������ 
	 *  
	 * */
	class ServerReciveThread extends Thread{
		 @Override
		public void run() {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))){
				while(true) {
				  String input = br.readLine();
				  if(input.equals("exit"))break;
				  
				  System.out.println(input);//super.getName()+"�� ���� ���� : " + inputData
				}
				
				System.out.println("���� �޴� ������ �����մϴ�.^^");
				
			}catch (Exception e) {
				//e.printStackTrace();
				System.out.println("ServerReciveThread catch �߻� �߽��ϴ�.......");
			}finally {
				System.exit(0);
			}
		}
	}
	

}//Ŭ������











