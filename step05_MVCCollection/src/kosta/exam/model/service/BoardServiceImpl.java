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
	 * �Խ��ǵ��� �ʱⵥ���͸� �ε�!!!
	 * */
	private BoardServiceImpl() {
		
		//�� kind�� �ش��ϴ� Map �غ�
		Map<String, Board> archiveMap = new TreeMap<String, Board>();
		Map<String, Board> photoMap =new TreeMap<String, Board>();
		Map<String, Board> freeMap =new TreeMap<String, Board>();
		
		
		
		//�ܺ� ~.properties���� �ε��ϱ� 
		ResourceBundle rb =
			ResourceBundle.getBundle("kosta/exam/model/service/archiveInfo");
		
		
		//key�� value�� �и��Ѵ�.
		for(String key : rb.keySet()) {
			String value = rb.getString(key);//
		
			//value�� �޸��� �������� ������ �и��Ѵ�.  : split(������) �޼ҵ� �̿�
			String v [] = value.split(",");
			
			//�и��� value�� �ϳ��� Board��ü�� �����.
			Board board = new ArchiveBoard(Integer.parseInt(v[0]), v[1], v[2], 
					v[3], v[4], v[5],  Integer.parseInt(v[6]));
			
			//�� kind�� �ش��ϴ� Map�� �߰��Ѵ�.
			archiveMap.put(key, board);
		}
		
		// photoMap ������ �ε�
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
		
	}//�����ڳ�
	
	/*public static void main(String[] args) {
		System.out.println("�����ϱ� ------------------");
		BoardServiceImpl.getInstance();
	}*/
	
	
	
	public static BoardServiceImpl getInstance() {
		return instance;
	}

	@Override
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException {
		if(allBoardList==null || allBoardList.isEmpty()) {
			throw new InexistentException("����� �Խù��� ������ �����ϴ�.");
		}
		
		return allBoardList;
	}
	

	// �Խ��� ������ ���� �˻�.
	@Override
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException {
		Map<String, Board> kindMap = allBoardList.get(kind);
		if(kindMap==null) 
			throw new InexistentException(kind+"������ �Խ����� �����ϴ�.");
		else if(kindMap.isEmpty())
			throw new InexistentException(kind+"������ �Խ��ǿ� �Խù��� �����ϴ�.");
		
		return kindMap;
	}

	
	
	@Override
	public Board getBoardByNo(String kind, int no) throws InexistentException {
		Map<String, Board> findMap = this.getBoardByKind(kind);
		
		Board board = findMap.get(Integer.toString(no));
		if(board==null)
		throw new InexistentException(kind+"������ �Խ��ǿ� "+no+"�� �ش��ϴ� �Խù��� �����ϴ�.");
		
		 return board;
	}
	
	

	@Override
	public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
		//kind ���� üũ
		Map<String, Board> kindMap = this.getBoardByKind(kind);
		
		//kindMap�� ������ �۹�ȣ �ߺ�üũ����.
	    if(this.duplicateByNo(kind, board.getNo())) { 
	    	//�ߺ��̴�.
	    	throw new DuplicateException(kind+"������ �Խ��ǿ� " + board.getNo()+"��ȣ ���� �̹� �����մϴ�.");
	    }
	    
	     kindMap.put( Integer.toString(board.getNo()) , board);
		
	}
	

	@Override
	public boolean duplicateByNo(String kind, int no) {
		if( allBoardList.get(kind).get(Integer.toString(no)) !=null) { //�ִ�.
			return true;
		}else {
			return false;
		}
	}
	

	@Override
	public void deleteBoard(String kind, int no) throws InexistentException {
		 this.getBoardByNo(kind, no); //kind�� no�� ���縦üũ�Ѵ�.
		
		allBoardList.get(kind).remove( Integer.toString(no) );
	}
	
	
	@Override
	public void updateBoard(Board board, String kind) throws InexistentException {
		//kind�� �ش��ϴ� Map�� ã�� �� �ȿ� board.getNo()�� �ش��ϴ� Ű�� �ִ��� ã�´�. 
		Board savedBoard = this.getBoardByNo(kind, board.getNo()); //�����Ϸ��� ��ü�����Ѵ�.
		
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
			throw new InexistentException("Ÿ�� ������ ���� �� �� �����ϴ�.");
		}
		
		
	}
}








