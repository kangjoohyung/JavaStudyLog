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
    			System.out.println("Ŭ���̾�Ʈ ������ ������Դϴ�....^^");
    			Socket sk = server.accept();//Ŭ���̾�Ʈ ���� �����
    			
    			System.out.println(sk.getInetAddress()+"�� �����ϼ̽��ϴ�. ");
    			
    			//������ Ŭ���̾�Ʈ�� ���� ���۵� ������ �б�
    			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream())) ;
    			String data = br.readLine();
    			System.out.println("Ŭ���̾�Ʈ�� ������ ���� : " + data );
    			
    			//������ Ŭ���̾�Ʈ���� ������ �����ϱ�
    			PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
    			pw.println("������ �����ϽŰ� ȯ���մϴ�.~~~~");
    			
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
