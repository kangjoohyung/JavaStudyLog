package ex0729.superEx;

class People{
	int age=20;
	String name="People";
	
	public void aa() {
		System.out.println("People의 aa() 호출됨...");
	}
	
	public void bb() {
		System.out.println("People의 bb() 호출됨...");
	}
}
//////////////////////////////////
class Customer extends People{
	int age=10;
	String addr="오리역";
	
	@Override //annotation = 표식
	public void aa() {
		System.out.println("Customer의 aa() 메소드 호출됨....");
	}
	
	public void cc() {
		System.out.println("Customer의 cc() 메소드 호출됨...");
	}
	
	public void test() {
		
		System.out.println(age); //10
		System.out.println(this.age);//10
		System.out.println(super.age);//20
		
	    System.out.println("---------------------------");
	    System.out.println(name); //
		System.out.println(this.name);//
		System.out.println(super.name);//
		
		System.out.println("---------------------------");
	    System.out.println(addr); //
		System.out.println(this.addr);//
		//System.out.println(super.addr);// 자식부분에 있는필드를 super로 접근 안됨.
		
		System.out.println("=======메소드 호출해보자===============");
		
		aa();
		this.aa();
		super.aa();
		
		System.out.println("-----------------------");
		
		bb();
		this.bb();
		super.bb();
		
		System.out.println("-----------------------");
		cc();
		this.cc();
		//super.cc();//자식부분에 있는 메소드를 super로 호출할수 없다.
		
	}
	
}
/////////////////////////////////////////////////////

public class SuperKeywordExam {
	public static void main(String[] args) {
		//new Customer().test();
		
		/*Customer cu = new Customer();
		System.out.println(cu.age);//10
		System.out.println(cu.addr);//오리역
		System.out.println(cu.name);//People
		
		System.out.println("--------------");
		cu.aa();
		cu.bb();
		cu.cc(); */
		
		/*People p = cu;
		System.out.println(p.age);
		
		System.out.println("cu주소 = " + cu);
		System.out.println("p주소 = " + p);*/
		
		///////////////////////////////////////////
		People p = new Customer(); //다형성이다 
		System.out.println(p.age);// 20
		//System.out.println(p.addr);// 부모타입변수로 자식부분 접근불가
		System.out.println(p.name);//
		
		System.out.println("*****************");
		//재정의된 메소드는 부모타입일지라도 자식부분이 호출된다.
		p.aa(); //Customer의 aa 호출됨
		
		p.bb();
		//p.cc(); //부모타입변수로는 자식부분의 메소드 호출불가.
		//////////////////////////////////////////////////////////
		
		//p가 가리키고 있는곳의 자식부분을 접근하기 위해서
		//ObjectDownCasting이 필요하다.
		if(p instanceof Customer) {
			Customer cu2 = (Customer)p;
			
			System.out.println("p주소 = " + p);
			System.out.println("cu2주소 = " + cu2);
			
			
			System.out.println(cu2.addr);
			cu2.cc();
		}
	}

}















