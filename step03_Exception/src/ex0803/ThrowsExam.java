package ex0803;

public class ThrowsExam {
	
	public void aa(int i) throws ArithmeticException {
		System.out.println("aa 메소드 호출됨");
		try {
		//try {
		  this.bb(i);
		//}catch (ArithmeticException e) {
		//	System.out.println("예외발생 : 0으로 나눌수 없어요.");
		//}
		}finally {
		   System.out.println("aa 메소드 끝 ....");
		}
	}
	
	public void bb(int i) throws ArithmeticException {
		System.out.println("bb 메소드 호출....");
		try {
			//try {
			  int result = 100/i; //ArithmeticException
			  System.out.println("나눈결과 : " + result);
			//}catch (ArithmeticException e) {
			//	System.out.println("0은 안되요!!!");
			//}
		}finally {
		   System.out.println("bb 메소드 끝....");
		}
	}

	public static void main(String[] args)throws ArithmeticException {
		System.out.println("****시작하기 ***************");
		ThrowsExam te = new ThrowsExam();
		//try {
		  te.aa(0);
		//}catch (ArithmeticException e) {
		//	System.out.println("예외 발생했어요.");
		//}
		
		System.out.println("****끝****************");

	}

}
