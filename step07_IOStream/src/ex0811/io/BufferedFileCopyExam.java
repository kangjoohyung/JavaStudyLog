package ex0811.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class BufferedFileCopyExam {
    public BufferedFileCopyExam(String readFile, String writeFile) {
    	BufferedInputStream bis=null;
    	BufferedOutputStream bos =null;
    	
    	try {
    		bis = new BufferedInputStream(new FileInputStream(readFile));
    		bos = new BufferedOutputStream(new FileOutputStream(writeFile));
    		
    		while(true) {
	    		int i = bis.read();
	    		if(i==-1)break;
	    		bos.write(i);
    		}
    		System.out.println("복사되었습니다.^^");
    		
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bis!=null)bis.close();
				if(bos!=null)bos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    }
	public static void main(String[] args) {
		String readFile = JOptionPane.showInputDialog("읽을 파일명은?");
		String writeFile = JOptionPane.showInputDialog("저장할 파일명은?");
		
		long start = System.nanoTime();
		
		new BufferedFileCopyExam(readFile, writeFile);
		
		long end =System.nanoTime();
		
		System.out.println("(Buffered 사용함)총 ns : " + (end-start) );

	}

}











