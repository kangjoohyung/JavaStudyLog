package ex0811.io;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileExam {
    public FileExam() throws IOException{
    	String fileName = JOptionPane.showInputDialog("�����̸���?");
    	System.out.println("fileName = " + fileName);
    	
    	File file = new File(fileName);
    	
    	if(file.exists()) {
    		System.out.println(fileName+"�� �����մϴ�.");
    		
    		if(file.isDirectory()) {//������� 
    			System.out.println("***���� ���� *****");
    			String [] f = file.list();
    			for(String s : f) {
    				System.out.println(s);
    			}
    			
    		}else {
    			System.out.println("***���� ���� *****");
    			System.out.println("�б� ��� : "+file.canRead());
    			System.out.println("���� ��� : "+file.canWrite());
    			System.out.println("�����̸� : "+file.getName());
    			System.out.println("������ : "+file.getAbsolutePath());
    			System.out.println("����ũ�� : "+file.length());
    			
    			//���ϻ���
    			file.delete();
    			
    		}
    		
    		
    	}else {
    		System.out.println("������ ���鲲��~~");
    		file.createNewFile();//���� ����
    		//file.mkdir();//��������
    	}
    	
    	
    }
	public static void main(String[] args)throws IOException {
		new FileExam();

	}

}
