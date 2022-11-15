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
		
		//dao호출하고 그결과를 받아서 원하는 결과인지를 판단하고 아니면 예외발생
		List<BoardDTO> list = boardDAO.boardSelectAll();
		if(list.size()==0 || list.isEmpty())
			throw new SQLException("게시물 정보가 없습니다^^"); //예외가 발생하면 Controller의 catch블럭이동
		
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<BoardDTO> list = boardDAO.boardSelectBySubject(keyWord);
		if(list.size()==0 || list.isEmpty())
			throw new SQLException("제목에 "+keyWord+"를 포함한 정보가 없습니다.");
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		BoardDTO boardDTO = boardDAO.boardSelectByNo(boardNo);
		if(boardDTO==null)throw new SQLException(boardNo+"에 해당하는 게시물이 없습니다."); //예외발생하면 controller의 catch블럭으로이동
		return boardDTO;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {
		if(boardDAO.boardInsert(boardDTO)==0)
			throw new SQLException("게시물이 등록되지 않았습니다.");//예외발생하면 controller의 catch블럭으로이동

	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		if( boardDAO.boardUpdate(boardDTO) == 0 ) 
			throw new SQLException("수정되지않았습니다.");//예외발생하면 controller의 catch블럭으로이동

	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		 if( boardDAO.boardDelete(boardNo) == 0)
			 throw new SQLException("삭제되지 않았습니다.");////예외발생하면 controller의 catch블럭으로이동

	}

	@Override
	public void replyInsert(ReplyDTO replyDTO) throws SQLException {
		if(boardDAO.replyInsert(replyDTO)==0) 
			throw new SQLException("댓글등록이 되지 않았습니다.");

	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SQLException {
		BoardDTO boardDTO = boardDAO.replySelectByParentNo(boardNo);
		if(boardDTO==null)
			throw new SQLException("부모글의 정보가 없습니다.");
		else if(boardDTO.getRepliesList().size()==0)
			throw new SQLException(boardNo+"에 해당하는 댓글의 정보가 없습니다.");
		
		return boardDTO;
	}

}






