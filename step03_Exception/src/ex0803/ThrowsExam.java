package ex0803;

public class ThrowsExam {
	
	public void aa(int i) throws ArithmeticException {
		System.out.println("aa �޼ҵ� ȣ���");
		try {
		//try {
		  this.bb(i);
		//}catch (ArithmeticException e) {
		//	System.out.println("���ܹ߻� : 0���� ������ �����.");
		//}
		}finally {
		   System.out.println("aa �޼ҵ� �� ....");
		}
	}
	
	public void bb(int i) throws ArithmeticException {
		System.out.println("bb �޼ҵ� ȣ��....");
		try {
			//try {
			  int result = 100/i; //ArithmeticException
			  System.out.println("������� : " + result);
			//}catch (ArithmeticException e) {
			//	System.out.println("0�� �ȵǿ�!!!");
			//}
		}finally {
		   System.out.println("bb �޼ҵ� ��....");
		}
	}

	public static void main(String[] args)throws ArithmeticException {
		System.out.println("****�����ϱ� ***************");
		ThrowsExam te = new ThrowsExam();
		//try {
		  te.aa(0);
		//}catch (ArithmeticException e) {
		//	System.out.println("���� �߻��߾��.");
		//}
		
		System.out.println("****��****************");

	}

}
