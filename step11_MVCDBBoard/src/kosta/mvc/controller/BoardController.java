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
	 * �Խù� ��ü �˻��ϱ� 
	 * */
	public static void boardSelectByAll() {
		try {
			//���� ȣ���ϰ� �װ���� ���� ���� �Ǵ� ���� ��� �̵��Ѵ�. 
			List<BoardDTO> list = boardService.boardSelectAll();
			SuccessView.selectPrint(list);
			
		}catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage( e.getMessage() );
		}
		
	}

	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� �˻��ϱ� 
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
	 * ���� ���Ե� �˻�...
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
	 *  �� ����ϱ�
	 * */
	public static void boardInsert(BoardDTO board) {
		try {
	      boardService.boardInsert(board);
	      SuccessView.messagePrint("�Խù��� ��ϵǾ����ϴ�.");
	      
		}catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * �Խù� �����ϱ�
	 * */
	public static void boardUpdate(BoardDTO board) {
		try {
			boardService.boardUpdate(board);
			SuccessView.messagePrint("�����Ǿ����ϴ�.");
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� ����
	 * */
	public static void boardDelete(int boardNo) {
	    try {
			boardService.boardDelete(boardNo);
			SuccessView.messagePrint("�����Ǿ����ϴ�.");
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	
	/**
	 * �θ�ۿ� ��� ����ϱ� 
	 * */
	public static void replyInsert(ReplyDTO replyDTO) {
		try {
			boardService.replyInsert(replyDTO);
			SuccessView.messagePrint(replyDTO.getBoardNo()+"�� �ۿ� ����� ����Ͽ����ϴ�.");
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * �θ�ۿ� �ش��ϴ� ������� �˻��ϱ� 
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





















