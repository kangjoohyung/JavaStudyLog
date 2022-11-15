package ex0812.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaveExam {
    public ObjectSaveExam() {
    	//������ ��ü�� ����
    	Student st1 = new Student("����", 10, "����");
    	Student st2 = new Student("����", 12, "�뱸");
    	
    	List<Student> list = new ArrayList<Student>();
    	list.add(new Student("����", 20, "����"));
    	list.add(new Student("�ҹ�", 22, "���ֵ�"));
    	list.add(new Student("����", 21, "����"));
    	
    	//��ü�� ���Ͽ� �����ϰ� �ʹ�. - ObjectOutputStream
    	try(ObjectOutputStream oos = new ObjectOutputStream(
    			new FileOutputStream("src/ex0812/io/objSave.txt"))){
    		
    		oos.writeObject(st1);
    		oos.writeObject(st2);
    		
    		oos.writeObject(list);
    		
    		System.out.println("����Ϸ� - ���� Ȯ���غ���!");
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    }
	public static void main(String[] args) {
		new ObjectSaveExam();

	}

}









