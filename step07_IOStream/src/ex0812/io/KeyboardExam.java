package ex0812.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KeyboardExam {
    public KeyboardExam() throws IOException {
    	/*InputStream is = System.in;
    	int i = is.read();
    	System.out.println(i +"  = " + (char)i);*/
    	
    	////////////////////////////////////////////////////////
    	//byte���� �б⸦ ���ڴ��� �б�� ��ȯ�� �ʿ��ϴ�. 
    	/*InputStreamReader isr = new InputStreamReader(System.in);
    	int i = isr.read();//�ѹ��� �б�
    	System.out.println(i +"  = " + (char)i);*/
    	
    	//////////////////////////////////////////////
    	//���ڴ��� �б⸦ Buffered�̿�
    	/*BufferedReader br = 
    			new BufferedReader(new InputStreamReader(System.in));
    	String data = br.readLine();
    	System.out.println(data);*/
    	
    	/////////////////////////////////////////////
    	Scanner sc = new Scanner(System.in);
    	String data = sc.nextLine();
    	System.out.println(data);
    	
    }
	public static void main(String[] args) throws IOException {
		 new KeyboardExam();

	}

}







