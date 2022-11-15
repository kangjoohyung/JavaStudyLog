package kosta.exam.view;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import kosta.exam.model.dto.Board;

/**
 * ��û�ᱤ�� ���� ȭ�� ���
 */
public class SuccessView {
	/**
	 * ��ü ���
	 */
	public static void printBoard(Map<String, Map<String, Board>> allMap) {
		/*for(String key : allMap.keySet()) {
			System.out.println(key + " Board�� ��� �Խù� LIST --------------");
			
			Map<String, Board> kindMap  = allMap.get(key);*/
			/*for(String k : kindMap.keySet()) {
				Board board =  kindMap.get(k);
				System.out.println("key = " + k + "[ "+board  +" ] ");
			}*/
			
			//������������ ����ϱ� 
			/*TreeMap tm = (TreeMap<String, Board>)kindMap;
			Iterator<String> it = tm.descendingKeySet().iterator();
			while(it.hasNext()) {
				String k = it.next();
				Board board = kindMap.get(k);
				System.out.println( "key = " + k + "[ "+ board  +" ] " );
			}
			
			System.out.println();
		}*/
			
		//////////////////////////////////////////////////////////////	
		if(allMap  instanceof  TreeMap) {
			TreeMap treeMap = (TreeMap<String, Map<String, Board>>)allMap;
			Iterator<String> it = treeMap.descendingKeySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				System.out.println(key + " Board�� ��� �Խù� LIST --------------");
				 Map<String, Board> kindMap = allMap.get(key);
				 
				 
				 if(kindMap instanceof TreeMap) {
					 TreeMap<String, Board>  kindTreeMap = (TreeMap<String, Board>) kindMap;
					 Iterator<String> itr = kindTreeMap.descendingKeySet().iterator();
					 while(itr.hasNext()) {
						 String k = itr.next();
						 Board board = kindTreeMap.get(k);
						 System.out.println( "key = " + k + "[ "+ board  +" ] " );
					 }
					 
					 System.out.println();
				 }
				 
			}//while��
		}//if����
			
	    
	}//�޼ҵ峡
	/**
	 * �Խ��������� �ش��ϴ� �Խù� ���
	 */
	public static void printboardByKind(String kind, Map<String, Board> kindMap) {
		System.out.println(kind+"���� �Խ��� �˻� ��� ------------------");
		if(kindMap instanceof TreeMap) {
			 TreeMap<String, Board>  kindTreeMap = (TreeMap<String, Board>) kindMap;
			 Iterator<String> itr = kindTreeMap.descendingKeySet().iterator();
			 while(itr.hasNext()) {
				 String k = itr.next();
				 Board board = kindTreeMap.get(k);
				 System.out.println( "key = " + k + "[ "+ board  +" ] " );
			 }
			 
			 System.out.println();
			 
		 }//if����
		
	}//�޼ҵ� ��
	
	
	/**
	 * �Խ����������� �۹�ȣ�� �ش��ϴ� �Խù� ����ϱ�
	 */
	public static void printBoardByNo(Board board) {
	   System.out.println(board);
		
	}
	/**
	 * ���, ����, �����ΰ�쿡 �����޽��� ���
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
}