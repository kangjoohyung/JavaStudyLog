package ex0804;

public class VariableArgsExam {
   
	 public void test(Object ... i) { //�Ű������� 0���̻� ����Ѵ�!
		 System.out.println("i.length = "+i.length);
		 for(Object j : i) {
			 System.out.print(j +" , ");
		 }
		 
		 System.out.println("\n----------------------");
		 
	 }
	 
	 public void test2(String s , int ... i) {
		 
	 }
	 
	 //public void test3(int ... i , String s) {// ...�� �μ��� �������� �;� �Ѵ�.
		 
	// }
	public static void main(String[] args) {
		VariableArgsExam va =new VariableArgsExam();
		
		/*va.test(3);
		va.test();
		va.test(3,3,4,1);
		va.test(3,5);
		
		va.test("�ȳ�");
		va.test(true, 5.5);*/
		////////////////////////////////////////////////
		va.test2("�ȳ�");
		va.test2("�ȳ�", 1);
		va.test2("�ȳ�",1,2,3,4,4);
		//va.test2(1,2,3,4,4);
		
		

	}

}






