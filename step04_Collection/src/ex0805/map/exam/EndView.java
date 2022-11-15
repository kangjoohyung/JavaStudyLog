package ex0805.map.exam;

import java.util.Map;

public class EndView {
   /**
    * 전체검색
    * */
	public static void printAll(Map<String, Person> map) {
		System.out.println("*****Person or Student List ********");
		
		System.out.println("인원수 : " + map.size()+"명 ");
		
		for(String key : map.keySet()) {
			Person p = map.get(key);
			System.out.println(key +" : " + p); //p.toString();
		}
		
		System.out.println();
	}
	
	/**
	 * key에 해당하는 정보 검색
	 * [ Person인경우는 이름만 출력
	 *     Student인경우는 이름과 총점 출력 ]
	 * */
	public static void printSearch(Person person) {
		
		System.out.println("이름 : " + person.getName());
		
		if(person instanceof Student) {
			Student st = (Student)person;
			System.out.println("총점 : " + st.getSum());
		}
		System.out.println();
	}
	
	/**
	 * 성공여부 메시지 출력
	 * */
	public static void printMessage(String message) {
		System.out.println(message+"\n");
	}
}







