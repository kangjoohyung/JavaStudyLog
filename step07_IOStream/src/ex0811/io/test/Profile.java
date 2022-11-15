
package ex0811.io.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Profile {
	Scanner sc = new Scanner(System.in);
	
	public Profile() {
		while(true) {
			try {
				System.out.println("1. ������ ���� \t 2. ������ �ҷ����� \t3. ����");
				
				switch(sc.nextInt()) {
					case 1:
						this.saveProfile();
						break;
					case 2:
						this.loadProfile();
						break;
					case 3:
						System.exit(0);
					default: 
						System.out.println("1 �Ǵ� 2�� ���ڸ� �Է����ּ���.");
				}
				
			}catch (Exception e) {
				System.out.println(e.getMessage()+"\n");
			}
		}
	}
	
	
	public void saveProfile() throws IOException{ //IOExecption�� FileNotFoundException�� �θ� class
		System.out.print("�̸�> ");
		String name = sc.next();
		System.out.print("������> ");
		int weight = sc.nextInt();
		System.out.print("��й�ȣ> ");
		String pw = sc.next();
		
		BufferedOutputStream bos=null;
		try {
			File file = new  File("src/ex0811/io/test/"+ name +".txt");
			if(file.exists()) {
				throw new IOException("�̹� �����ϹǷ� �ٽ� �Է��ϼ���.");
			}
			
			 bos = new BufferedOutputStream(new FileOutputStream(file));
			 String data = weight + ":" + pw;
			 bos.write(data.getBytes());
			 
			System.out.println("������ ����Ϸ�1");
			
		}finally {
			if(bos!=null)bos.close();
		
		}
	}
	
	public void loadProfile() throws IOException{
		System.out.print("�̸�> ");
		String name = sc.next();
		
		File file = new File("src/ex0811/io/test/" + name + ".txt");
		
		if(!file.exists()) {
		   throw new IOException( name+"�� �ش��ϴ� ������ �����ϴ�.");	
		}
		
		BufferedInputStream bis = 
		 new BufferedInputStream(new FileInputStream(file));
		
		byte b [] = new byte [bis.available()];
		bis.read(b);
		
		String data = new String(b);
		String [] dataArr = data.split(":");

		System.out.println(name + "�� �����Դ� " + dataArr[0] + "kg �̰� ����� " + dataArr[1] + " �Դϴ�.");
		
	}
	
	public static void main(String[] args) {
			new Profile();
	}

}
