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
				System.out.println("CLIENT ���� ������Դϴ�");
				sk=server.accept();
				userIp=sk.getInetAddress().toString();
				System.out.println(userIp+"�� ���� �Ǽ̽��ϴ�");
				
				//���ӵ� Ŭ���̾�Ʈ�� Thread�� ���� �����(List)�� �����Ѵ�
				ClientSocketThread th=new ClientSocketThread();
				list.add(th);
				
				th.start();
				
				System.out.println("[���� �ο���]"+list.size()+"��");
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
	 * List�� ����� ClientSocketThread�� ������ ��� USER���� �޼����� �����ϴ� ���
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
				//�б�
				br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
				
				//����
				pw=new PrintWriter(sk.getOutputStream(), true);
				
				//��ȭ�� �б�
				nicName=br.readLine();
				
				//��� User���� "~�� �����ϼ̽��ϴ�" �޼��� �����Ѵ�
				sendMessage(nicName+"���� �����ϼ̽��ϴ�");
				
				String inputData=null;
				while((inputData=br.readLine())!=null) {
					//���ӵ� ��� Ŭ���̾�Ʈ���� �����͸� �����Ѵ�
					sendMessage("["+nicName+"]"+inputData);
				}
			}catch(Exception e) {
				e.printStackTrace();
				//���� �����忡 �ش��ϴ� Ŭ���̾�Ʈ�� Socket�� ���� �����̱� ������ ���� �߻�
				//list���� ����
				list.remove(this);
				
				//�����ִ� ��� USER���� �˸���.
				sendMessage("["+nicName+"]"+"���� �����ϼ̽��ϴ�");
				
				//����â���� �˸���.
				System.out.println("["+nicName+"]"+"���� �����ϼ̽��ϴ�|���� �����ο�"+list.size());
			}
		}
	}
}//Ŭ���� ��
