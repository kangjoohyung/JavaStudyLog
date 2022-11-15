package ex0805.map.exam;

import java.util.Map;

public class EndView {
   /**
    * ��ü�˻�
    * */
	public static void printAll(Map<String, Person> map) {
		System.out.println("*****Person or Student List ********");
		
		System.out.println("�ο��� : " + map.size()+"�� ");
		
		for(String key : map.keySet()) {
			Person p = map.get(key);
			System.out.println(key +" : " + p); //p.toString();
		}
		
		System.out.println();
	}
	
	/**
	 * key�� �ش��ϴ� ���� �˻�
	 * [ Person�ΰ��� �̸��� ���
	 *     Student�ΰ��� �̸��� ���� ��� ]
	 * */
	public static void printSearch(Person person) {
		
		System.out.println("�̸� : " + person.getName());
		
		if(person instanceof Student) {
			Student st = (Student)person;
			System.out.println("���� : " + st.getSum());
		}
		System.out.println();
	}
	
	/**
	 * �������� �޽��� ���
	 * */
	public static void printMessage(String message) {
		System.out.println(message+"\n");
	}
}







