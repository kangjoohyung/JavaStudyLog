package kosta.exam.model.service;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import kosta.exam.model.dto.ArchiveBoard;
import kosta.exam.model.dto.Board;
import kosta.exam.model.dto.FreeBoard;
import kosta.exam.model.dto.PhotoBoard;
import kosta.exam.model.util.DuplicateException;
import kosta.exam.model.util.InexistentException;

public class BoardServiceImpl implements BoardService {
	private static BoardServiceImpl instance = new BoardServiceImpl(); 
	
	Map<String, Map<String, Board>> allBoardList  = new TreeMap<String, Map<String,Board>>();
	
	/**
	 * 게시판들의 초기데이터를 로딩!!!
	 * */
	private BoardServiceImpl() {
		
		//각 kind에 해당하는 Map 준비
		Map<String, Board> archiveMap = new TreeMap<String, Board>();
		Map<String, Board> photoMap =new TreeMap<String, Board>();
		Map<String, Board> freeMap =new TreeMap<String, Board>();
		
		
		
		//외부 ~.properties파일 로딩하기 
		ResourceBundle rb =
			ResourceBundle.getBundle("kosta/exam/model/service/archiveInfo");
		
		
		//key와 value를 분리한다.
		for(String key : rb.keySet()) {
			String value = rb.getString(key);//
		
			//value를 콤마를 기준으로 정보를 분리한다.  : split(구분자) 메소드 이용
			String v [] = value.split(",");
			
			//분리된 value를 하나의 Board객체로 만든다.
			Board board = new ArchiveBoard(Integer.parseInt(v[0]), v[1], v[2], 
					v[3], v[4], v[5],  Integer.parseInt(v[6]));
			
			//각 kind에 해당하는 Map에 추가한다.
			archiveMap.put(key, board);
		}
		
		// photoMap 데이터 로딩
		rb =
		  ResourceBundle.getBundle("kosta/exam/model/service/photoInfo");
		for(String key : rb.keySet()) {
			String value = rb.getString(key);
			String v [] = value.split(",");
			Board board = new PhotoBoard(Integer.parseInt(v[0]), v[1], 
					v[2], v[3], v[4], v[5]);
			
			photoMap.put(key, board);
		}
		
		rb =
		  ResourceBundle.getBundle("kosta/exam/model/service/freeInfo");
		for(String key : rb.keySet()) {
			String value = rb.getString(key);
			String v [] = value.split(",");
			Board board = new FreeBoard(Integer.parseInt(v[0]), v[1], 
					v[2], v[3], v[4], Integer.parseInt(v[5]));
			
			freeMap.put(key, board);
		}
		
		
		allBoardList.put("archive", archiveMap);
		allBoardList.put("photo", photoMap);
		allBoardList.put("free", freeMap);
		
       // System.out.println(allBoardList);
		
	}//생성자끝
	
	/*public static void main(String[] args) {
		System.out.println("시작하기 ------------------");
		BoardServiceImpl.getInstance();
	}*/
	
	
	
	public static BoardServiceImpl getInstance() {
		return instance;
	}

	@Override
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException {
		if(allBoardList==null || allBoardList.isEmpty()) {
			throw new InexistentException("저장된 게시물의 정보가 없습니다.");
		}
		
		return allBoardList;
	}
	

	// 게시판 유형에 따른 검색.
	@Override
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException {
		Map<String, Board> kindMap = allBoardList.get(kind);
		if(kindMap==null) 
			throw new InexistentException(kind+"유형의 게시판이 없습니다.");
		else if(kindMap.isEmpty())
			throw new InexistentException(kind+"유형의 게시판에 게시물이 없습니다.");
		
		return kindMap;
	}

	
	
	@Override
	public Board getBoardByNo(String kind, int no) throws InexistentException {
		Map<String, Board> findMap = this.getBoardByKind(kind);
		
		Board board = findMap.get(Integer.toString(no));
		if(board==null)
		throw new InexistentException(kind+"유형의 게시판에 "+no+"에 해당하는 게시물이 없습니다.");
		
		 return board;
	}
	
	

	@Override
	public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
		//kind 유무 체크
		Map<String, Board> kindMap = this.getBoardByKind(kind);
		
		//kindMap이 있으니 글번호 중복체크하자.
	    if(this.duplicateByNo(kind, board.getNo())) { 
	    	//중복이다.
	    	throw new DuplicateException(kind+"유형의 게시판에 " + board.getNo()+"번호 글은 이미 존재합니다.");
	    }
	    
	     kindMap.put( Integer.toString(board.getNo()) , board);
		
	}
	

	@Override
	public boolean duplicateByNo(String kind, int no) {
		if( allBoardList.get(kind).get(Integer.toString(no)) !=null) { //있다.
			return true;
		}else {
			return false;
		}
	}
	

	@Override
	public void deleteBoard(String kind, int no) throws InexistentException {
		 this.getBoardByNo(kind, no); //kind와 no의 존재를체크한다.
		
		allBoardList.get(kind).remove( Integer.toString(no) );
	}
	
	
	@Override
	public void updateBoard(Board board, String kind) throws InexistentException {
		//kind에 해당하는 Map을 찾고 그 안에 board.getNo()에 해당하는 키가 있는지 찾는다. 
		Board savedBoard = this.getBoardByNo(kind, board.getNo()); //수정하려는 객체리턴한다.
		
		if(board instanceof ArchiveBoard && savedBoard instanceof ArchiveBoard) {
		    ArchiveBoard castingBoard = (ArchiveBoard)board;
		    ArchiveBoard castingSavedBoard = (ArchiveBoard)savedBoard;
		    
		    castingSavedBoard.setSubject(castingBoard.getSubject());
		    castingSavedBoard.setContent(castingBoard.getContent());
		    castingSavedBoard.setWriter(castingBoard.getWriter());
		    
		    castingSavedBoard.setFileName(castingBoard.getFileName());
		    castingSavedBoard.setFileSize(castingBoard.getFileSize());
		    
			
		}else if(board instanceof PhotoBoard && savedBoard instanceof PhotoBoard) {
			PhotoBoard castingBoard = (PhotoBoard)board;
			PhotoBoard castingSavedBoard = (PhotoBoard)savedBoard;
			
			castingSavedBoard.setContent(castingBoard.getContent());
			castingSavedBoard.setWriter(castingBoard.getWriter());
			castingSavedBoard.setSubject(castingBoard.getSubject());
			
			castingSavedBoard.setImgName(castingBoard.getImgName());
			
		}else {
			throw new InexistentException("타입 오류로 수정 할 수 없습니다.");
		}
		
		
	}
}








