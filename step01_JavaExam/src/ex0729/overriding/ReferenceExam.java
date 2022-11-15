package ex0729.overriding;


class ObjectExam{
	String str;
	public ObjectExam(){   }
	public ObjectExam(String str){ 
		this.str=str;
	}
	
	@Override
	public String toString() {
		
		return str +" / " + super.toString();
	}
}

///////////////////////////////////////////
class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			
			String s01= "������"; 
			String s02= "Java";
			
			String s03 = new String("������");
			
			ObjectExam oe1=new ObjectExam("�ָ��� �����ؾ���...");
			
			ObjectExam oe2 = new ObjectExam("�ȳ�");
			
			System.out.println(c);//a
			
			/**
			 * println(Object obj) �Ǵ� print(Object obj) �޼ҵ��� 
			 * �μ��� ��ü�� ���޵Ǹ� obj.toString() �޼ҵ尡 ȣ��ǰ� �� �޼ҵ尡
			 * �����ϴ� ���� ����Ѵ�.
			 * */
			
			System.out.println(s01);//������
			System.out.println(s02);//Java
			
			System.out.println(s03.toString());//������ ????
			
			System.out.println(oe1);// ex0729.overriding.ObjectExam@7de26db8 :Object�� ���� �Ǿ� �ִ� toString�� ȣ�߷�
			System.out.println(oe2.toString());//�ּҰ�
			
	}
}








