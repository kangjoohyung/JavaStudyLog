package ex0811.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputOutputExam {
    public FileInputOutputExam() {
    	FileInputStream fis=null;
    	FileOutputStream fos=null;
    	try {
    	 //������ byte������ �б�
    	  fis = new FileInputStream("src/ex0811/io/read.txt");
    	  /*while(true) {
    	    int i = fis.read(); //1byte�б� 
    	    if(i==-1)break;
    	    System.out.println(i +" , " + (char)i );
    	  }*/
    	  //////////////////////////////
    	  /*int i=0;
    	  while((i=fis.read()) != -1) {
    		  System.out.println(i +" , " + (char)i );
    	  }*/
    	  
    	  //////////////////////////////////////////
    	  int len = fis.available();//������ �ִ� byte���� 
    	  System.out.println("len = " + len);
    	  
    	  byte b [] = new byte [len];
    	  fis.read(b); //�ѹ��� b�� ũ�⸸ŭ �о�´�.
    	  
    	  //byte�迭��  -> ���ڿ��� ��ȯ 
    	  String data = new String(b);
    	  
    	  System.out.println( data);
    	  /////////////////////////////////////////
    	  //���Ͽ� byte������ ����(����) 
    	  fos = new FileOutputStream("src/ex0811/io/write.txt", true);
    	  fos.write(65);
    	  fos.write(97);
    	  
    	  fos.write(13);
    	  fos.write(10);
    	  
    	  String s = "���õ� ���� �߾��^^ - Good Job!";
    	  //String�� --> byte�迭�� ��ȯ!!!
    	  fos.write(s.getBytes());
    	  
    	  fos.flush();//����ض�.
    	  
    	
    	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			  if(fis!=null)fis.close();
			  if(fos!=null)fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
	public static void main(String[] args) {
		new FileInputOutputExam();

	}

}
