package ex0804.list;

import java.util.List;

/**
  ����� ��û�� �ش��ϴ� ����� ����Ϳ� ����ϴ� Ŭ���� 
*/
class EndView{
    /**
	   ���޵� List�� ���(��ü �˻� ���)
	*/
	public static void printAll(List<Student> list){
        System.out.println("***�л��� ���� ("+list.size()+")�� ******");
        //Student st = list.get(0);
        
        for(Student st : list) {
        	System.out.println(st);//st.toString()ȣ��ȴ�
        }
        System.out.println();
	}

	/**
	  �л���ȣ�� �ش��ϴ� �л� ���� ���
	*/
	public static void printSearchBySno(Student student){
		System.out.println(student.getSno()+"�� ������ �Ʒ��� �����ϴ�-------");  
		System.out.println(student);//student.toString()
		
		System.out.println();
	}
	/**
	  ���� ���ο� ���õ� �޽��� ���
	*/
	public static void printMessage(String message){
         System.out.println(message+"\n");
	}

}