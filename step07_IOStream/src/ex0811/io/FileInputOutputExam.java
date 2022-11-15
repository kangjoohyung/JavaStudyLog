package ex0811.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputOutputExam {
    public FileInputOutputExam() {
    	FileInputStream fis=null;
    	FileOutputStream fos=null;
    	try {
    	 //파일을 byte단위로 읽기
    	  fis = new FileInputStream("src/ex0811/io/read.txt");
    	  /*while(true) {
    	    int i = fis.read(); //1byte읽기 
    	    if(i==-1)break;
    	    System.out.println(i +" , " + (char)i );
    	  }*/
    	  //////////////////////////////
    	  /*int i=0;
    	  while((i=fis.read()) != -1) {
    		  System.out.println(i +" , " + (char)i );
    	  }*/
    	  
    	  //////////////////////////////////////////
    	  int len = fis.available();//읽을수 있는 byte개수 
    	  System.out.println("len = " + len);
    	  
    	  byte b [] = new byte [len];
    	  fis.read(b); //한번에 b의 크기만큼 읽어온다.
    	  
    	  //byte배열을  -> 문자열로 변환 
    	  String data = new String(b);
    	  
    	  System.out.println( data);
    	  /////////////////////////////////////////
    	  //파일에 byte단위로 쓰기(저장) 
    	  fos = new FileOutputStream("src/ex0811/io/write.txt", true);
    	  fos.write(65);
    	  fos.write(97);
    	  
    	  fos.write(13);
    	  fos.write(10);
    	  
    	  String s = "오늘도 수고 했어요^^ - Good Job!";
    	  //String을 --> byte배열로 변환!!!
    	  fos.write(s.getBytes());
    	  
    	  fos.flush();//출력해라.
    	  
    	
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
