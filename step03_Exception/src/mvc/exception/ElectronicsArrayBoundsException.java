package mvc.exception;
/**
 * Electroncs 배열에 값을 넣을때 배열의 길이가 벗어났을때 발생할 예외객체
 * */
public class ElectronicsArrayBoundsException extends Exception {
	
	public ElectronicsArrayBoundsException() {}
	
	public ElectronicsArrayBoundsException(String message) {
		super(message);
	}

}
