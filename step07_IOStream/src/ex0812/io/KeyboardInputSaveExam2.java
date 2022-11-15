package ex0812.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;



public class KeyboardInputSaveExam2 {
    public KeyboardInputSaveExam2() {
    	//Ű���� �Է��� ��� �޴´�(exit�ܾ ����������....)
    	//�Է��� ������ ȭ�鿡 ��� �ϰ� ���Ͽ� �����Ѵ�. 
    	
    	try(BufferedWriter bw = new BufferedWriter(
    				new FileWriter("src/ex0812/io/save.txt"))){
    		
    		Scanner sc = new Scanner(System.in);
    		
    		while(true) {
    			System.out.print("�Է� > ");
    			String data = sc.nextLine();
    			if(data.equals("exit"))break;
    			System.out.println(data);
    			
    			bw.write(data);
    			bw.newLine();
    			bw.flush();
    		}
    		System.out.println("���α׷� ����~~~~! �������� Ȯ���ϼ���.");
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    }
	public static void main(String[] args) {
		new KeyboardInputSaveExam2();

	}

}
