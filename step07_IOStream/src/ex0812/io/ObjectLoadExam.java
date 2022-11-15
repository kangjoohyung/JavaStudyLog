package ex0812.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectLoadExam {
    public ObjectLoadExam() {
    	//���Ͽ� ����� ��ü�� �����ͼ� Ȯ���ϱ� - ObjectInputStream
    	try(ObjectInputStream ois = new ObjectInputStream(
    			new FileInputStream("src/ex0812/io/objSave.txt"))){
    		
    		Student st1 = (Student)ois.readObject();
    		Student st2 = (Student)ois.readObject();
    		
    		List<Student> list = (List<Student>)ois.readObject();
    		
    		System.out.println(st1);
    		System.out.println(st2);
    		System.out.println(list);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	public static void main(String[] args) {
		new ObjectLoadExam();

	}

}
