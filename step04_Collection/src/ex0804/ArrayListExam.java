package ex0804;

import java.util.ArrayList;

class Test{
	int a=100;
	public void aa() {}
	
	/*@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "����";
	}*/
}
//////////////////////////////////////////////////////
class ArrayListExam extends ArrayList<Object>{

	//���� Variable
	//Object Ÿ��1��, int Ÿ�� 1��;
	Object obj;
	int i;
	

	//Constractor
	public ArrayListExam(){
		super(5);	//�ʱ� �뷮 5�� ����	
		
		
		
	}

	//method
	//method�̸�			����Ÿ��		�μ�						
	
	/*addInt				����			����(int)1��				
	�ϴ��� : �μ��� ���� ������ ��ü�� ����� list�� �߰�.*/
	public void addInt(int i) {
		/*Integer it = new Integer(i);
		super.add(it);*/
		
		super.add(i); //AutoBoxing �� �ȴ�. 
		
	}
		
	
	
	/*addFloat				����			�Ǽ�(float)1��			
		�ϴ��� : �μ��� ���� �Ǽ��� ��ü�� ����� list�� �߰�.*/
	public void addFloat(float f) {
		 /*Float ft = new Float(f);
		 this.add(ft);*/
		
		this.add(f);
	}
	
	
	/*addString			����			String ���ڿ�1��		
		�ϴ��� : �μ��� ���� String �� list�� �߰�.*/
	public void addString(String s) {
		add(s);
		
		add( new Test() );
	}
	
	
	
	/*printList		����			����			
		������ ���������� ���� list�� ����ִ� ��ü�� ���� �Է��� �� �������� ���.
		List�� ����� �� ��ü�� �ɹ������� �������� ���*/
	  public void printList() {
		  this.i = super.size();//3
		  
		   System.out.println("����� ��ü�� ���� : " + this.i);
		   
		  for(int index=0; index < this.i ; index++) {
		    this.obj = super.get(index);
		    System.out.println("����� ��ü : " + obj.toString());
		  }
		  
		  //���� for���� ������ for�� �����غ���
		  System.out.println("---------------------");
		  
		  for(Object o  : this) {  //super �ȵȴ�. 
			  System.out.println( o );
		  }
		  
		  
		  System.out.println("-------------------------");
		  
		  //Test��ü�� a������ ����
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
		int a = it; //��ڽ�
		System.out.println(a);
		
		int b = new Integer(8); //��ڽ�
		System.out.println(b);
		
		Integer aa = 4; //����ڽ�
		aa.byteValue();
		
		
		
	}
}

/*������

list�� ����ִ� ��ü�� �� ������=3
5
5.5
newString

Normal Termination
��� �Ϸ� (0�� ���).
*/