package ex0811.inner;
//교재 391 ~
class Test{
	int a=10;
	static int b=5;
	
	public void aa() {}
	public static void bb() {}
	
	
	/**
	 *  인스턴스맴버클래스 
	 *   : static선언은 안된다. - 단, java version 16이상부터 가능하다. 
	 *   : static필드, static메소드 접근가능
	 *   : 클래스앞에 access modifier 4가지 모두 선언가능한다.
	 * */
	protected class InstanceInner{
		int a=7;
		//static int c=100;
		
		public void test() {
			System.out.println(a);//7
			System.out.println(this.a);//7
			System.out.println(Test.this.a);//10
			
			System.out.println(b); //5
			System.out.println(Test.b);//5
			
			aa();
			bb();
			
		}
		
		//public static void test2() {}
		
	}//inner클래스끝
	/////////////////////////////////////////////////
	/**
	 * static 맴버클래스 
	 *   : 클래스앞에 access modifier 4가지 모두 선언가능한다.
	 *   : static, non-static 모두 선언가능하다.
	 *   
	 *   : Outer쪽의 non-static 접근불가
	 * */
	 static class StaticInner{
		 int a=3;
		 static int c=6;
		 
		 public void test() {
			 System.out.println(a);//3
			 System.out.println(this.a);//3
			 
			 //System.out.println(Test.this.a); //outer쪽의non-static접근불가
			 
			 System.out.println(b);//5
			 System.out.println(Test.b);//5
			 
			 //aa();//non-static메소드이므로 접근불가
			 bb();
		 }
		 
		 public  static void test2() {}
		 
	 }//staticInner끝
	 /////////////////////////////////////////////////
	 
	 public void test2() {
		 System.out.println("Test의 test2() 메소드 call......");
		 /**
		  * 로컬 이너클래스
		  *   : access modifier 올수 없고 static선언안됨.
		  * */
		 /*private*/ class LocalInner{
			int a=3;
			/*static*/ int b=7;
			
			public void aa() {
				System.out.println("LocalInner의 aa() 메소드 호출됨..");
			}
		 }//LcoalInnerEnd
		 
		 LocalInner li = new LocalInner();
		 li.aa();
		 
	 }//test() 끝
	
	
	
}//Outer클래스 끝
//////////////////////////////////////////////////////////////////
public class InnerAccessExam {
	public static void main(String[] args) {
		System.out.println("--1. 인스턴스 맴버 클래스 -----------------------");
		Test t = new Test();
		Test.InstanceInner ti = t.new InstanceInner();
		ti.test();
		
		System.out.println("\n-2. static 맴버 클래스 -----------------------");
		
		Test.StaticInner ts = new Test.StaticInner();
		ts.test();
		
		System.out.println("\n-3. Local 이너클래스 -----------------------");
		t.test2();

	}

}













