package ex0812.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderWriterExam {
    public BufferedReaderWriterExam() {
    	//���ڴ����� ���� �б� - Buffered �̿�
    	try(BufferedReader br = new BufferedReader(new FileReader("src/ex0811/io/read.txt")) ;
    		BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0812/io/write.txt"))){
    		/*while(true) {
    		   int i = br.read();
    		   if(i==-1)break;
    		   System.out.println(i+"  = " + (char)i );
    		}*/
    		///////////////////////////////////
    		//�����б�
    		String data=null;
    		while((data=br.readLine()) != null) {
        		System.out.println(data);
        		bw.write(data);
        		bw.newLine();
    		}
    		
    		///////////////////////////////////////
    		//���ڴ����� ��������
    		/*bw.write(65);//A
    		
    		bw.write(13);
    		bw.write(10);
    		
    		bw.write("�������.");
    		bw.write("���ɸ޴���?\n");
    		bw.write("�۽��??");
    		
    		bw.newLine();//����
    		bw.write("���ִ°� �԰� �;��.");*/
   
    		bw.flush();
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	public static void main(String[] args) {
		new BufferedReaderWriterExam();

	}

}
