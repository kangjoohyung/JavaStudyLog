package ex0729.superEx;

class People{
	int age=20;
	String name="People";
	
	public void aa() {
		System.out.println("People�� aa() ȣ���...");
	}
	
	public void bb() {
		System.out.println("People�� bb() ȣ���...");
	}
}
//////////////////////////////////
class Customer extends People{
	int age=10;
	String addr="������";
	
	@Override //annotation = ǥ��
	public void aa() {
		System.out.println("Customer�� aa() �޼ҵ� ȣ���....");
	}
	
	public void cc() {
		System.out.println("Customer�� cc() �޼ҵ� ȣ���...");
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
		//System.out.println(super.addr);// �ڽĺκп� �ִ��ʵ带 super�� ���� �ȵ�.
		
		System.out.println("=======�޼ҵ� ȣ���غ���===============");
		
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
		//super.cc();//�ڽĺκп� �ִ� �޼ҵ带 super�� ȣ���Ҽ� ����.
		
	}
	
}
/////////////////////////////////////////////////////

public class SuperKeywordExam {
	public static void main(String[] args) {
		//new Customer().test();
		
		/*Customer cu = new Customer();
		System.out.println(cu.age);//10
		System.out.println(cu.addr);//������
		System.out.println(cu.name);//People
		
		System.out.println("--------------");
		cu.aa();
		cu.bb();
		cu.cc(); */
		
		/*People p = cu;
		System.out.println(p.age);
		
		System.out.println("cu�ּ� = " + cu);
		System.out.println("p�ּ� = " + p);*/
		
		///////////////////////////////////////////
		People p = new Customer(); //�������̴� 
		System.out.println(p.age);// 20
		//System.out.println(p.addr);// �θ�Ÿ�Ժ����� �ڽĺκ� ���ٺҰ�
		System.out.println(p.name);//
		
		System.out.println("*****************");
		//�����ǵ� �޼ҵ�� �θ�Ÿ�������� �ڽĺκ��� ȣ��ȴ�.
		p.aa(); //Customer�� aa ȣ���
		
		p.bb();
		//p.cc(); //�θ�Ÿ�Ժ����δ� �ڽĺκ��� �޼ҵ� ȣ��Ұ�.
		//////////////////////////////////////////////////////////
		
		//p�� ����Ű�� �ִ°��� �ڽĺκ��� �����ϱ� ���ؼ�
		//ObjectDownCasting�� �ʿ��ϴ�.
		if(p instanceof Customer) {
			Customer cu2 = (Customer)p;
			
			System.out.println("p�ּ� = " + p);
			System.out.println("cu2�ּ� = " + cu2);
			
			
			System.out.println(cu2.addr);
			cu2.cc();
		}
	}

}















