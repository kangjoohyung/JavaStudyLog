package ex0805.map;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExxam {
	Properties pro = new Properties();//Map의 형태(key, value 도 모두 String이다) 
	
    public PropertiesExxam() {
    	//추가
    	pro.setProperty("id", "jang");
    	pro.setProperty("age", "20");
    	pro.setProperty("name", "장희정");
    	
    	System.out.println("pro : " + pro);
    	
    	//개선된 for형태
    	for(String key : pro.stringPropertyNames()) {
    		String value = pro.getProperty(key);
    		System.out.println(key +" = " + value);
    	}
    }
    /**
     * 외부 ~.properties파일 읽어오는 방법
     *  1) IO를 이용하는 방법
     *  2) ResourcesBundle 이용하는 방법
     * */
    
    //1) IO를 이용하는 방법
    public void test01() {
    	pro.clear();//비운다.
    	try {
    	  pro.load(new FileInputStream("src/ex0805/map/test.properties"));
    	  
    	  System.out.println(pro);
    	  
    	  for(String k : pro.stringPropertyNames()) {
    		  String value = pro.getProperty(k);
    		  System.out.println(k+" = " + value);
    	  }
    	  
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    //2) ResourcesBundle 이용하는 방법
    public void test02() {
    	System.out.println("---test02 메소드 입니다. -----");
    	//파일의 기준점이 classes폴더를 기준으로 경로를 잡는다.
    	//~.properties파일을 읽어오는 전용 클래스이다. 
    	//그래서 경로를 설정할때 확장자는 생략한다. 
    	ResourceBundle rb =
    			   ResourceBundle.getBundle("ex0805\\map\\test");//test.properties
    	
    	
    	for(String key : rb.keySet()) {
    		String value = rb.getString(key);
    		System.out.println(key+" = " + value);
    	}
    	
    }
	public static void main(String[] args) {
		PropertiesExxam pe = new PropertiesExxam();
		System.out.println("****************************");
		//pe.test01();
		pe.test02();

	}

}
