package ex0805.map.exam;

import java.util.Map;

public class MapStudentController {
	private static MapStudentService service = new MapStudentService();
	
  /**
   * ��ü�˻�
   * */
	public static void selectAll() {
		try {
			
			Map<String, Person> map =service.selectAll();
			EndView.printAll(map);
			
		}catch (RuntimeException e) {
			EndView.printMessage( e.getMessage() );
		}
	}
	
   /**
    * key ���� ã��
    * */
	public static void searchById(String key) {
		try {
			Person person = service.searchByKey(key);
			EndView.printSearch(person);
			
		}catch (RuntimeException e) {
			EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * ���
	 * */
	public static void insert(Person person) {
		try {
			service.insert(person);
			EndView.printMessage("��ϵǾ����ϴ�.");
		}catch (RuntimeException  e) {
		  EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * ����
	 * */
	public static void delete(String key) {
		try {
			service.delete(key);
			EndView.printMessage("���� �Ǿ����ϴ�.");
		}catch (RuntimeException  e) {
		  EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * ����
	 * */
	public static void update(Person person) {
		try {
			service.update(person);
			EndView.printMessage("�����Ǿ����ϴ�.");
		}catch (RuntimeException  e) {
		  EndView.printMessage(e.getMessage());
		}
	}
	
	
}
