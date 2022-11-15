package ex0805.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetExam extends HashSet<String>{
//public class SetExam extends TreeSet<String>{
    public SetExam(String [] args) {
    	//super(5);
    	//������ �߰� 
    	for(String name  : args) {
    	   boolean re = super.add(name);
    	   System.out.println(name +"�߰� ��� : " + re);
    	}
    	
    	System.out.println("�߰��� ���� : " + super.size() );
    	System.out.println( this );
    	///////////////////////////////////////////
    	System.out.println("------------------------");
    	/*Set�ȿ� ��Ҹ� �ϳ��� ������ */
    	Iterator<String> it = super.iterator();
    	while(it.hasNext()) {//��Ұ� �� �����Ѵٸ� 
    	   String s = it.next();//��Ҹ� ������.
    	   System.out.println(s);
    	}
    	
    	System.out.println("----������ for�� �����غ��� ----");
    	for(  String name : this ) {
    		System.out.println(name);
    	}
    	
    	System.out.println("----���� �غ��� -----");
    	boolean re = super.remove("ȿ��2");
    	
    	System.out.println("���� ��� : " + re);
    	System.out.println("���� �� : " + this);
    	
    }
	public static void main(String[] args) {
         new SetExam(args);		

	}

}








