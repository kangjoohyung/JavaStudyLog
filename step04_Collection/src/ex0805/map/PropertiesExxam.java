package ex0805.map;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExxam {
	Properties pro = new Properties();//Map�� ����(key, value �� ��� String�̴�) 
	
    public PropertiesExxam() {
    	//�߰�
    	pro.setProperty("id", "jang");
    	pro.setProperty("age", "20");
    	pro.setProperty("name", "������");
    	
    	System.out.println("pro : " + pro);
    	
    	//������ for����
    	for(String key : pro.stringPropertyNames()) {
    		String value = pro.getProperty(key);
    		System.out.println(key +" = " + value);
    	}
    }
    /**
     * �ܺ� ~.properties���� �о���� ���
     *  1) IO�� �̿��ϴ� ���
     *  2) ResourcesBundle �̿��ϴ� ���
     * */
    
    //1) IO�� �̿��ϴ� ���
    public void test01() {
    	pro.clear();//����.
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
    
    //2) ResourcesBundle �̿��ϴ� ���
    public void test02() {
    	System.out.println("---test02 �޼ҵ� �Դϴ�. -----");
    	//������ �������� classes������ �������� ��θ� ��´�.
    	//~.properties������ �о���� ���� Ŭ�����̴�. 
    	//�׷��� ��θ� �����Ҷ� Ȯ���ڴ� �����Ѵ�. 
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
