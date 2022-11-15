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
	 * ��ü�˻�
	 */
	public static void getAllBoard() {
		//���� ȣ��
		try {
			Map<String, Map<String, Board>> allBoardList = boardService.getBoardList();
			SuccessView.printBoard(allBoardList);
			
		} catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * �Խ��������� �ش��ϴ� �Խù� ���� �˻�
	 */
	public static void getBoardByKind(String kind) {
		try {
		  //���� ȣ��
		 Map<String, Board> kindMap = boardService.getBoardByKind(kind);
		 SuccessView.printboardByKind(kind, kindMap);
		  
		}catch (InexistentException e) {
			FailView.errorMessage( e.getMessage() );
		}
	}

	/**
	 * �Խ����������� �۹�ȣ�� �ش��ϴ� �Խù� �˻�
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
	 * ����ϱ�
	 */
	public static void insertBoard(String kind, Board board) {
		
		try {
			boardService.insertBoard(kind, board);
			SuccessView.printMessage(kind+"������ �Խ��ǿ� "+board.getNo()+"��ȣ �Խù��� ����߽��ϴ�.");
			
		} catch (InexistentException | DuplicateException e) {
			FailView.errorMessage( e.getMessage() );
		}
	}

	/**
	 * �����ϱ�
	 */
	public static void deleteBoard(String kind, int no) {
		try {
		  boardService.deleteBoard(kind, no);
		  SuccessView.printMessage("���� ���� �Ǿ����ϴ�.");
		}catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * �����ϱ�
	 */
	public static void updateBoard(Board board, String kind) {
		try {
		  boardService.updateBoard(board, kind);
		  SuccessView.printMessage("�����Ǿ����ϴ�.");
		}catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}









