package ex0811.inner;
//���� 391 ~
class Test{
	int a=10;
	static int b=5;
	
	public void aa() {}
	public static void bb() {}
	
	
	/**
	 *  �ν��Ͻ��ɹ�Ŭ���� 
	 *   : static������ �ȵȴ�. - ��, java version 16�̻���� �����ϴ�. 
	 *   : static�ʵ�, static�޼ҵ� ���ٰ���
	 *   : Ŭ�����տ� access modifier 4���� ��� ���𰡴��Ѵ�.
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
		
	}//innerŬ������
	/////////////////////////////////////////////////
	/**
	 * static �ɹ�Ŭ���� 
	 *   : Ŭ�����տ� access modifier 4���� ��� ���𰡴��Ѵ�.
	 *   : static, non-static ��� ���𰡴��ϴ�.
	 *   
	 *   : Outer���� non-static ���ٺҰ�
	 * */
	 static class StaticInner{
		 int a=3;
		 static int c=6;
		 
		 public void test() {
			 System.out.println(a);//3
			 System.out.println(this.a);//3
			 
			 //System.out.println(Test.this.a); //outer����non-static���ٺҰ�
			 
			 System.out.println(b);//5
			 System.out.println(Test.b);//5
			 
			 //aa();//non-static�޼ҵ��̹Ƿ� ���ٺҰ�
			 bb();
		 }
		 
		 public  static void test2() {}
		 
	 }//staticInner��
	 /////////////////////////////////////////////////
	 
	 public void test2() {
		 System.out.println("Test�� test2() �޼ҵ� call......");
		 /**
		  * ���� �̳�Ŭ����
		  *   : access modifier �ü� ���� static����ȵ�.
		  * */
		 /*private*/ class LocalInner{
			int a=3;
			/*static*/ int b=7;
			
			public void aa() {
				System.out.println("LocalInner�� aa() �޼ҵ� ȣ���..");
			}
		 }//LcoalInnerEnd
		 
		 LocalInner li = new LocalInner();
		 li.aa();
		 
	 }//test() ��
	
	
	
}//OuterŬ���� ��
//////////////////////////////////////////////////////////////////
public class InnerAccessExam {
	public static void main(String[] args) {
		System.out.println("--1. �ν��Ͻ� �ɹ� Ŭ���� -----------------------");
		Test t = new Test();
		Test.InstanceInner ti = t.new InstanceInner();
		ti.test();
		
		System.out.println("\n-2. static �ɹ� Ŭ���� -----------------------");
		
		Test.StaticInner ts = new Test.StaticInner();
		ts.test();
		
		System.out.println("\n-3. Local �̳�Ŭ���� -----------------------");
		t.test2();

	}

}













