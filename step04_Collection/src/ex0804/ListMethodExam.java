package ex0804;

import java.util.ArrayList;
import java.util.List;

public class ListMethodExam {
	private List<String> list = new ArrayList<String>(5);
	
	public ListMethodExam(String [] args) {
		//������ �߰� 
		//list.add("test");
		for(String name : args) {
			 if(!list.contains(name)) {	
			    list.add(name); //���� �߰� 
			  // list.add(0, name);// 0������ �߰� 
				
			   //list.set(0, name);
			 }
		}
		
		System.out.println( list );
	}
	
	public void printList() {
		System.out.println("---List �׸� ����ϱ�("+list.size()+ ") �� ---------");
		for(int i=0; i < list.size() ; i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		//�׸� �����ϱ� 
		//String re = list.remove(3);
		//System.out.println("re = " + re ); //���ŵ� ��ü 
		
		boolean b = list.remove("����");
		System.out.println("��� : " + b);
		
		

		
		System.out.println("---���� �� --------------");
		System.out.println(list);
		
	}
	

	public static void main(String[] args) {
		 new ListMethodExam(args).printList();

	}

}
