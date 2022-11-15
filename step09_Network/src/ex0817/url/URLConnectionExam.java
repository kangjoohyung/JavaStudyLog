package ex0817.url;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class URLConnectionExam {
    public URLConnectionExam() {
    	try {
    	  /* URL url = new URL("https://www.naver.com/");
    	   
    	   BufferedReader br = 
    			   new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
    	   
    	   BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0817/url/naver.html"));
    	   String data=null;
    	   while((data=br.readLine()) !=null) {
    		   System.out.println(data);
    		   bw.write(data);
    		   bw.flush();
    	   }
    	
    	   System.out.println("**완료***");*/
    		
    		//////////////////////////////////////////////////
    		URL url = new URL("http://192.168.0.20/Util/epp351.exe");
    		BufferedInputStream bis = new BufferedInputStream(url.openStream());
    		
    		BufferedOutputStream bos = 
    				new BufferedOutputStream(new FileOutputStream("src/ex0817/url/epp351.exe"));
    		 int i=0;
    		 while((i=bis.read()) != -1) {
    			 bos.write(i);
    			 bos.flush();
    		 }
    		 
    		 bos.close();
    		 
    		 System.out.println("저장완료되었습니다.");
    		
    	   
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		new URLConnectionExam();

	}

}
