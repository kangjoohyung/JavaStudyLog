package ex0804;

import java.util.ArrayList;
import java.util.List;

public class ListMethodExam {
	private List<String> list = new ArrayList<String>(5);
	
	public ListMethodExam(String [] args) {
		//데이터 추가 
		//list.add("test");
		for(String name : args) {
			 if(!list.contains(name)) {	
			    list.add(name); //끝에 추가 
			  // list.add(0, name);// 0번지에 추가 
				
			   //list.set(0, name);
			 }
		}
		
		System.out.println( list );
	}
	
	public void printList() {
		System.out.println("---List 항목 출력하기("+list.size()+ ") 개 ---------");
		for(int i=0; i < list.size() ; i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		//항목 제거하기 
		//String re = list.remove(3);
		//System.out.println("re = " + re ); //제거된 객체 
		
		boolean b = list.remove("희정");
		System.out.println("결과 : " + b);
		
		

		
		System.out.println("---제거 후 --------------");
		System.out.println(list);
		
	}
	

	public static void main(String[] args) {
		 new ListMethodExam(args).printList();

	}

}
