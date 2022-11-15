package ex0805.map.exam;

import java.util.Map;

public class MapStudentController {
	private static MapStudentService service = new MapStudentService();
	
  /**
   * 전체검색
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
    * key 정보 찾기
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
	 * 등록
	 * */
	public static void insert(Person person) {
		try {
			service.insert(person);
			EndView.printMessage("등록되었습니다.");
		}catch (RuntimeException  e) {
		  EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 삭제
	 * */
	public static void delete(String key) {
		try {
			service.delete(key);
			EndView.printMessage("삭제 되었습니다.");
		}catch (RuntimeException  e) {
		  EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 수정
	 * */
	public static void update(Person person) {
		try {
			service.update(person);
			EndView.printMessage("수정되었습니다.");
		}catch (RuntimeException  e) {
		  EndView.printMessage(e.getMessage());
		}
	}
	
	
}
