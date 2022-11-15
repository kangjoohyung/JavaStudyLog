package ex0801.abstract_final;

class Test{
	final int i =100; //final필드(명시적초기화 가능, 생성자를 이용한 초기화가 가능)
	
	static final int j =100; //상수 (명시적 초기화가능, 생성자를 이용한 초기가 안됨)
	
	/*Test(int i){
		this.i = i; //final필드 초기화가능
	}*/
	
	
	
}

public class FinalVariableExam {
	public static void main(String[] args) {

		
//		  new Test(5);
		  //new Test(100);

	}

}
