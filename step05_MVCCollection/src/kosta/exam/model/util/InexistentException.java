package kosta.exam.model.util;
/**
 * 존재 여부를 체크하는 Exception
 *   : 게시판의 유형, 게시판의 글번호에 해당하는 게시물
 *   : DML(등록,  수정, 삭제) 관련 예외
 * */
public class InexistentException extends Exception {
	public InexistentException() {}
	public InexistentException(String message) {
		super(message);
	}
}


