package ex0812.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;



public class KeyboardInputSaveExam {
    public KeyboardInputSaveExam() {
    	//Ű���� �Է��� ��� �޴´�(exit�ܾ ����������....)
    	//�Է��� ������ ȭ�鿡 ��� �ϰ� ���Ͽ� �����Ѵ�. 
    	
    	try( BufferedReader  br = 
    			new BufferedReader(new InputStreamReader(System.in)) ;
    		BufferedWriter bw = new BufferedWriter(
    				new FileWriter("src/ex0812/io/save.txt"))){
    		
    		while(true) {
    			System.out.print("�Է� > ");
    			String data = br.readLine();
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
		new KeyboardInputSaveExam();

	}

}
