package ex0804;

import java.util.ArrayList;

class Test{
	int a=100;
	public void aa() {}
	
	/*@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "하하";
	}*/
}
//////////////////////////////////////////////////////
class ArrayListExam extends ArrayList<Object>{

	//전역 Variable
	//Object 타입1개, int 타입 1개;
	Object obj;
	int i;
	

	//Constractor
	public ArrayListExam(){
		super(5);	//초기 용량 5개 생성	
		
		
		
	}

	//method
	//method이름			리턴타입		인수						
	
	/*addInt				없음			정수(int)1개				
	하는일 : 인수로 받은 정수를 객체로 만들어 list에 추가.*/
	public void addInt(int i) {
		/*Integer it = new Integer(i);
		super.add(it);*/
		
		super.add(i); //AutoBoxing 이 된다. 
		
	}
		
	
	
	/*addFloat				없음			실수(float)1개			
		하는일 : 인수로 받은 실수를 객체로 만들어 list에 추가.*/
	public void addFloat(float f) {
		 /*Float ft = new Float(f);
		 this.add(ft);*/
		
		this.add(f);
	}
	
	
	/*addString			없음			String 문자열1개		
		하는일 : 인수로 받은 String 을 list에 추가.*/
	public void addString(String s) {
		add(s);
		
		add( new Test() );
	}
	
	
	
	/*printList		없음			없음			
		정수형 전역변수에 현재 list에 들어있는 객체의 개수 입력한 후 전역변수 출력.
		List에 저장된 각 객체를 맴버변수에 저장한후 출력*/
	  public void printList() {
		  this.i = super.size();//3
		  
		   System.out.println("저장된 객체의 개수 : " + this.i);
		   
		  for(int index=0; index < this.i ; index++) {
		    this.obj = super.get(index);
		    System.out.println("저장된 객체 : " + obj.toString());
		  }
		  
		  //위의 for문을 개선된 for로 변경해보자
		  System.out.println("---------------------");
		  
		  for(Object o  : this) {  //super 안된다. 
			  System.out.println( o );
		  }
		  
		  
		  System.out.println("-------------------------");
		  
		  //Test객체의 a변수를 찍어보자
		  obj = super.get(3);
		  if(obj instanceof Test) {
			  Test t =(Test)obj;
			   System.out.println(t.a);
		  }
		  
		  
		  //Integer it=(Integer)super.get(0);
		  
	  }
		

	public static void main(String args[]){
		ArrayListExam list = new ArrayListExam();
		String s = new String("newString");		 
		list.addInt(5);
		list.addFloat(5.5F);
		list.addString(s);
		list.printList();
		
		////////////////////////////////////////////
		Integer it = new Integer(4);
		int a = it; //언박싱
		System.out.println(a);
		
		int b = new Integer(8); //언박싱
		System.out.println(b);
		
		Integer aa = 4; //오토박싱
		aa.byteValue();
		
		
		
	}
}

/*실행결과

list에 들어있는 객체의 총 개수는=3
5
5.5
newString

Normal Termination
출력 완료 (0초 경과).
*/