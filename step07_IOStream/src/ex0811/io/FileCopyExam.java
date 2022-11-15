package ex0811.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class FileCopyExam {
    public FileCopyExam(String readFile, String writeFile) {
    	FileInputStream fis =null;
    	FileOutputStream fos =null;
    	try {
    		fis = new FileInputStream(readFile);
    		fos = new FileOutputStream(writeFile);
    		while(true) {
	    		int i = fis.read();
	    		if(i==-1)break;
	    		fos.write(i);
    		}
    		System.out.println("복사되었습니다.^^");
    		
    		
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
		String readFile = JOptionPane.showInputDialog("읽을 파일명은?");
		String writeFile = JOptionPane.showInputDialog("저장할 파일명은?");
		
		long start = System.nanoTime();
		
		new FileCopyExam(readFile, writeFile);
		
		long end = System.nanoTime();
		System.out.println("(Buffered 이용안함 )총 ns : " + (end-start) );

	}

}









