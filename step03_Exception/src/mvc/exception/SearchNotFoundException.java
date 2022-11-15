package mvc.exception;

/**
 * 상품코드로 상품을 조회했을때 찾는 정보가 null이면 발생시킬 예외 객체 
 * */
public class SearchNotFoundException extends Exception {
   public SearchNotFoundException() {}
   public SearchNotFoundException(String message) {
	   super(message);
   }
}
