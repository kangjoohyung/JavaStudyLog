package ex0816.lamda;

public class LamdaTest {
	public static void main(String[] args) {
		//�����ڵ���� 
		/* AInterface ai = new AInterfaceImpl();
		 ai.aa();*/
		//////////////////////////////////
		//���ٽ� �ڵ����� ����
		AInterface ai = ()->{
			System.out.println("AInterfaceImpl �� aa ȣ���!!");
		};
		ai.aa();
		
		//////////////////////////////////////////
		BInterface bi = (a)->{
			System.out.println("BInterface�� bb(int i) ȣ��� a = " + a);
		};
		
		bi.bb(15);
		///////////////////////////////////////////////////////////
		CInterface ci = (a, b)->{
			System.out.println("CInterface�� cc(int i , int j) ȣ���..");
			return a*b;
		};
		
		int result = ci.cc(5, 4);
        System.out.println("��� : " + result);
	}

}
////////////////////////////////////////////////
/*class AInterfaceImpl implements AInterface{
	@Override
	public void aa() {
		System.out.println("AInterfaceImpl �� aa ȣ���!!");
	}
	
}*/