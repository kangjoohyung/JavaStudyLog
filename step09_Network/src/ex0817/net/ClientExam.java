package ex0817.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {
    public ClientExam() {
    	try(Socket sk = new Socket("127.0.0.1", 8000)){ //127.0.0.1 = localhost : �ڽ�IP
    		 //�������� ������ ����
    	     PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
    		 pw.println("������ �����ϰ� �;��~~~");
    		 
    		 //������ �������� �����͸� �б�
    		 BufferedReader br  = 
    				 new BufferedReader(new InputStreamReader(sk.getInputStream()));
    		 
    		 String data = br.readLine();
    		 System.out.println("������ ������ ���� : " + data);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	public static void main(String[] args) {
		new ClientExam();

	}

}
