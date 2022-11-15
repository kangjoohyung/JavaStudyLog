package kosta.exam.view;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import kosta.exam.model.dto.Board;

/**
 * 요청결광에 대한 화면 출력
 */
public class SuccessView {
	/**
	 * 전체 출력
	 */
	public static void printBoard(Map<String, Map<String, Board>> allMap) {
		/*for(String key : allMap.keySet()) {
			System.out.println(key + " Board의 모든 게시물 LIST --------------");
			
			Map<String, Board> kindMap  = allMap.get(key);*/
			/*for(String k : kindMap.keySet()) {
				Board board =  kindMap.get(k);
				System.out.println("key = " + k + "[ "+board  +" ] ");
			}*/
			
			//내림차순으로 출력하기 
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
				System.out.println(key + " Board의 모든 게시물 LIST --------------");
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
				 
			}//while문
		}//if문끝
			
	    
	}//메소드끝
	/**
	 * 게시판유형에 해당하는 게시물 출력
	 */
	public static void printboardByKind(String kind, Map<String, Board> kindMap) {
		System.out.println(kind+"유형 게시판 검색 결과 ------------------");
		if(kindMap instanceof TreeMap) {
			 TreeMap<String, Board>  kindTreeMap = (TreeMap<String, Board>) kindMap;
			 Iterator<String> itr = kindTreeMap.descendingKeySet().iterator();
			 while(itr.hasNext()) {
				 String k = itr.next();
				 Board board = kindTreeMap.get(k);
				 System.out.println( "key = " + k + "[ "+ board  +" ] " );
			 }
			 
			 System.out.println();
			 
		 }//if문끝
		
	}//메소드 끝
	
	
	/**
	 * 게시판유형에서 글번호에 해당하는 게시물 출력하기
	 */
	public static void printBoardByNo(Board board) {
	   System.out.println(board);
		
	}
	/**
	 * 등록, 수정, 삭제인경우에 성공메시지 출력
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
}