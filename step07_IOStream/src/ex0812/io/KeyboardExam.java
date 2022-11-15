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
    	//byte단위 읽기를 문자단위 읽기로 변환이 필요하다. 
    	/*InputStreamReader isr = new InputStreamReader(System.in);
    	int i = isr.read();//한문자 읽기
    	System.out.println(i +"  = " + (char)i);*/
    	
    	//////////////////////////////////////////////
    	//문자단위 읽기를 Buffered이용
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







