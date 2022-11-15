package kosta.exam.controller;

import java.util.Map;

import kosta.exam.model.dto.Board;
import kosta.exam.model.service.BoardService;
import kosta.exam.model.service.BoardServiceImpl;
import kosta.exam.model.util.DuplicateException;
import kosta.exam.model.util.InexistentException;
import kosta.exam.view.FailView;
import kosta.exam.view.SuccessView;



public class BoardController {
	
  private static BoardService boardService = BoardServiceImpl.getInstance() ;

	/**
	 * 전체검색
	 */
	public static void getAllBoard() {
		//서비스 호출
		try {
			Map<String, Map<String, Board>> allBoardList = boardService.getBoardList();
			SuccessView.printBoard(allBoardList);
			
		} catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * 게시판유형에 해당하는 게시물 정보 검색
	 */
	public static void getBoardByKind(String kind) {
		try {
		  //서비스 호출
		 Map<String, Board> kindMap = boardService.getBoardByKind(kind);
		 SuccessView.printboardByKind(kind, kindMap);
		  
		}catch (InexistentException e) {
			FailView.errorMessage( e.getMessage() );
		}
	}

	/**
	 * 게시판유형에서 글번호에 해당하는 게시물 검색
	 */
	public static void getBoardByno(String kind, int no) {
		try {
			
			Board board = boardService.getBoardByNo(kind, no);
			SuccessView.printBoardByNo(board);
			
		}catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 등록하기
	 */
	public static void insertBoard(String kind, Board board) {
		
		try {
			boardService.insertBoard(kind, board);
			SuccessView.printMessage(kind+"유형의 게시판에 "+board.getNo()+"번호 게시물을 등록했습니다.");
			
		} catch (InexistentException | DuplicateException e) {
			FailView.errorMessage( e.getMessage() );
		}
	}

	/**
	 * 삭제하기
	 */
	public static void deleteBoard(String kind, int no) {
		try {
		  boardService.deleteBoard(kind, no);
		  SuccessView.printMessage("글이 삭제 되었습니다.");
		}catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 수정하기
	 */
	public static void updateBoard(Board board, String kind) {
		try {
		  boardService.updateBoard(board, kind);
		  SuccessView.printMessage("수정되었습니다.");
		}catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}









