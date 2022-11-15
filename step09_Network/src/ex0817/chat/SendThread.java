package ex0817.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Ű���� �Է��� �޾Ƽ� ������� �޽����� �����ϴ� thread 
 * */
public class SendThread extends Thread {
	Socket sk;
	public SendThread(Socket sk , String name) {
		super(name);//thread�̸�����
		this.sk=sk;
	}

	 @Override
	public void run() {
		//Ű���� �Է� �ޱ� 
		 Scanner sc = new Scanner(System.in);
		 
		 try( PrintWriter pw = new PrintWriter(sk.getOutputStream() , true) ){
		   while(true) {
		     String inputData = sc.nextLine(); //Ű���� �Է� �ޱ� 
		     if(inputData.equals("exit")) {
		    	 pw.println(inputData);//exit �ܾ ������.
		    	 break;
		     }else {
		        pw.println(super.getName()+"�� ���� ���� : " + inputData);//��������� ����
		     }
		   } 
		   
		   System.out.println(super.getName()+"�� ������ �����尡 �����մϴ�. ");
		 }catch (Exception e) {
			
			 System.out.println(super.getName()+"�� SendThread ���ܰ� �߻��߽��ϴ�. ");
		}
		 
	}//run�޼ҵ峡
}//Ŭ������






