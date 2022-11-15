package ex0804;

public class VariableArgsExam {
   
	 public void test(Object ... i) { //매개변수를 0개이상 허용한다!
		 System.out.println("i.length = "+i.length);
		 for(Object j : i) {
			 System.out.print(j +" , ");
		 }
		 
		 System.out.println("\n----------------------");
		 
	 }
	 
	 public void test2(String s , int ... i) {
		 
	 }
	 
	 //public void test3(int ... i , String s) {// ...은 인수의 마지막에 와야 한다.
		 
	// }
	public static void main(String[] args) {
		VariableArgsExam va =new VariableArgsExam();
		
		/*va.test(3);
		va.test();
		va.test(3,3,4,1);
		va.test(3,5);
		
		va.test("안녕");
		va.test(true, 5.5);*/
		////////////////////////////////////////////////
		va.test2("안녕");
		va.test2("안녕", 1);
		va.test2("안녕",1,2,3,4,4);
		//va.test2(1,2,3,4,4);
		
		

	}

}






