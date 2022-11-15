package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.BoardDAO;
import kosta.mvc.dao.BoardDAOImpl;
import kosta.mvc.dto.BoardDTO;
import kosta.mvc.dto.ReplyDTO;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO = new BoardDAOImpl();

	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		
		//daoȣ���ϰ� �װ���� �޾Ƽ� ���ϴ� ��������� �Ǵ��ϰ� �ƴϸ� ���ܹ߻�
		List<BoardDTO> list = boardDAO.boardSelectAll();
		if(list.size()==0 || list.isEmpty())
			throw new SQLException("�Խù� ������ �����ϴ�^^"); //���ܰ� �߻��ϸ� Controller�� catch���̵�
		
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<BoardDTO> list = boardDAO.boardSelectBySubject(keyWord);
		if(list.size()==0 || list.isEmpty())
			throw new SQLException("���� "+keyWord+"�� ������ ������ �����ϴ�.");
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		BoardDTO boardDTO = boardDAO.boardSelectByNo(boardNo);
		if(boardDTO==null)throw new SQLException(boardNo+"�� �ش��ϴ� �Խù��� �����ϴ�."); //���ܹ߻��ϸ� controller�� catch�������̵�
		return boardDTO;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {
		if(boardDAO.boardInsert(boardDTO)==0)
			throw new SQLException("�Խù��� ��ϵ��� �ʾҽ��ϴ�.");//���ܹ߻��ϸ� controller�� catch�������̵�

	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		if( boardDAO.boardUpdate(boardDTO) == 0 ) 
			throw new SQLException("���������ʾҽ��ϴ�.");//���ܹ߻��ϸ� controller�� catch�������̵�

	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		 if( boardDAO.boardDelete(boardNo) == 0)
			 throw new SQLException("�������� �ʾҽ��ϴ�.");////���ܹ߻��ϸ� controller�� catch�������̵�

	}

	@Override
	public void replyInsert(ReplyDTO replyDTO) throws SQLException {
		if(boardDAO.replyInsert(replyDTO)==0) 
			throw new SQLException("��۵���� ���� �ʾҽ��ϴ�.");

	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SQLException {
		BoardDTO boardDTO = boardDAO.replySelectByParentNo(boardNo);
		if(boardDTO==null)
			throw new SQLException("�θ���� ������ �����ϴ�.");
		else if(boardDTO.getRepliesList().size()==0)
			throw new SQLException(boardNo+"�� �ش��ϴ� ����� ������ �����ϴ�.");
		
		return boardDTO;
	}

}






