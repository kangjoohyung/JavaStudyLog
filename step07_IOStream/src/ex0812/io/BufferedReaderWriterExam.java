package ex0812.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderWriterExam {
    public BufferedReaderWriterExam() {
    	//문자단위로 파일 읽기 - Buffered 이용
    	try(BufferedReader br = new BufferedReader(new FileReader("src/ex0811/io/read.txt")) ;
    		BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0812/io/write.txt"))){
    		/*while(true) {
    		   int i = br.read();
    		   if(i==-1)break;
    		   System.out.println(i+"  = " + (char)i );
    		}*/
    		///////////////////////////////////
    		//한줄읽기
    		String data=null;
    		while((data=br.readLine()) != null) {
        		System.out.println(data);
        		bw.write(data);
        		bw.newLine();
    		}
    		
    		///////////////////////////////////////
    		//문자단위로 파일저장
    		/*bw.write(65);//A
    		
    		bw.write(13);
    		bw.write(10);
    		
    		bw.write("배고프다.");
    		bw.write("점심메뉴는?\n");
    		bw.write("글쎄요??");
    		
    		bw.newLine();//개행
    		bw.write("맛있는거 먹고 싶어요.");*/
   
    		bw.flush();
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	public static void main(String[] args) {
		new BufferedReaderWriterExam();

	}

}
