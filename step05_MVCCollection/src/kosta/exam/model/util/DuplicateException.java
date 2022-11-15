package kosta.exam.model.util;
/**
 * 글을 등록할때 글번호 중복인 경우 예외
 * */
public class DuplicateException extends Exception {
   public DuplicateException() {}
   public DuplicateException(String message) {
	   super(message);
   }
}
