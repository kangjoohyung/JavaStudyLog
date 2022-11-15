package ex0805.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam  extends HashMap<Integer, String>{
    public MapExam() {
    	//�߰�
    	super.put(10, "������");
    	super.put(50, "�̳���");
    	super.put(30, "��ȿ��");
    	super.put(40, "�嵿��");
    	super.put(20, "��ҿ�");
    	super.put(60, "�̹ο�");
    	
    	super.put(30,"�����");//key�� ������ value�� ����
    	
    	System.out.println("����� ���� : " + super.size());
    	System.out.println(this);
    	
    	System.out.println("==Map�� �ִ� ���� ��ȸ �غ��� ======");
    	
    	//Map�� �ִ� ��� key�� ������ �����´�.
    	Set<Integer> set = super.keySet();
    	
    	Iterator<Integer> it = set.iterator();
    	while(it.hasNext()) {
    		Integer key = it.next();
    		String value = super.get(key);
    		System.out.println(key+" = " + value);
    	}
    	
    	System.out.println("\n----������ for�� �����غ��� ----");
    	for(Integer key : super.keySet() ) {
    		String value = super.get(key);
    		System.out.println(key+" = " + value);
    	}
    	
    	System.out.println("\n==Map.Entry<K, V> ����ϱ� ================");
    	
    	Set<Map.Entry<Integer, String>>  s = super.entrySet();
    	Iterator<Map.Entry<Integer, String>> ita = s.iterator();
    	while(ita.hasNext()) {
    		Map.Entry<Integer, String> e = ita.next();
    		System.out.println(e.getKey() +"�� " + e.getValue());
    	}
    	
    	System.out.println("\n==Map.Entry<K, V> ������ for  ================");
    	for(Map.Entry<Integer, String> me : super.entrySet()) {
    		System.out.println(me.getKey() +"�� " + me.getValue());
    	}
    }
	public static void main(String[] args) {
		new MapExam();

	}

}





