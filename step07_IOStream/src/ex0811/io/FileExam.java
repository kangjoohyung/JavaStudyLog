package ex0811.io;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileExam {
    public FileExam() throws IOException{
    	String fileName = JOptionPane.showInputDialog("파일이름은?");
    	System.out.println("fileName = " + fileName);
    	
    	File file = new File(fileName);
    	
    	if(file.exists()) {
    		System.out.println(fileName+"는 존재합니다.");
    		
    		if(file.isDirectory()) {//폴더라면 
    			System.out.println("***폴더 정보 *****");
    			String [] f = file.list();
    			for(String s : f) {
    				System.out.println(s);
    			}
    			
    		}else {
    			System.out.println("***파일 정보 *****");
    			System.out.println("읽기 기능 : "+file.canRead());
    			System.out.println("쓰기 기능 : "+file.canWrite());
    			System.out.println("파일이름 : "+file.getName());
    			System.out.println("절대경로 : "+file.getAbsolutePath());
    			System.out.println("파일크기 : "+file.length());
    			
    			//파일삭제
    			file.delete();
    			
    		}
    		
    		
    	}else {
    		System.out.println("없으니 만들께요~~");
    		file.createNewFile();//파일 생성
    		//file.mkdir();//폴더생성
    	}
    	
    	
    }
	public static void main(String[] args)throws IOException {
		new FileExam();

	}

}
