package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.BoardDTO;
import kosta.mvc.dto.ReplyDTO;
import kosta.mvc.service.BoardService;
import kosta.mvc.service.BoardServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class BoardController {
	private static BoardService boardService = new BoardServiceImpl();

	/**
	 * 게시물 전체 검색하기 
	 * */
	public static void boardSelectByAll() {
		try {
			//서비스 호출하고 그결과에 따라 성공 또는 실패 뷰로 이동한다. 
			List<BoardDTO> list = boardService.boardSelectAll();
			SuccessView.selectPrint(list);
			
		}catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage( e.getMessage() );
		}
		
	}

	/**
	 * 글번호에 해당하는 게시물 검색하기 
	 * */
	public static void boardSelectByNo(int boardNo) {
		try {
		 BoardDTO boardDTO = boardService.boardSelectByNo(boardNo);
		 SuccessView.selectByNoPrint(boardDTO);
		  
		}catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * 제목에 포함된 검색...
	 * */
	public static void boardSelectBySubject(String word) {
		try {
			List<BoardDTO> list = boardService.boardSelectBySubject(word);
			SuccessView.selectPrint(list);
			
		}catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 *  글 등록하기
	 * */
	public static void boardInsert(BoardDTO board) {
		try {
	      boardService.boardInsert(board);
	      SuccessView.messagePrint("게시물이 등록되었습니다.");
	      
		}catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * 게시물 수정하기
	 * */
	public static void boardUpdate(BoardDTO board) {
		try {
			boardService.boardUpdate(board);
			SuccessView.messagePrint("수정되었습니다.");
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 글번호에 해당하는 게시물 삭제
	 * */
	public static void boardDelete(int boardNo) {
	    try {
			boardService.boardDelete(boardNo);
			SuccessView.messagePrint("삭제되었습니다.");
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	
	/**
	 * 부모글에 댓글 등록하기 
	 * */
	public static void replyInsert(ReplyDTO replyDTO) {
		try {
			boardService.replyInsert(replyDTO);
			SuccessView.messagePrint(replyDTO.getBoardNo()+"번 글에 댓글을 등록하였습니다.");
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * 부모글에 해당하는 댓글정보 검색하기 
	 * */
	public static void replySelectByParentNo(int boardNo) {
		try {
			BoardDTO boardDTO = boardService.replySelectByParentNo(boardNo);
			SuccessView.selectReplyPrint(boardDTO);
			
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	

}





















