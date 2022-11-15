package shop;
/**
 * 나이가 18보다 작을 경우 발생할 예외객체
 * */
public class NoKidsException extends Exception { //체크예외종류
//public class NoKidsException extends RuntimeException { //체크예외종류
    static int count;
	
	public NoKidsException() {
	   super("애들은 가라");
	   count++;
   }
   
   public NoKidsException(String message) {
	   super(message);
	   count++;
   }
}
