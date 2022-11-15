package ex0816.lamda;

public class LamdaTest {
	public static void main(String[] args) {
		//원래코딩방식 
		/* AInterface ai = new AInterfaceImpl();
		 ai.aa();*/
		//////////////////////////////////
		//람다식 코딩으로 변경
		AInterface ai = ()->{
			System.out.println("AInterfaceImpl 의 aa 호출됨!!");
		};
		ai.aa();
		
		//////////////////////////////////////////
		BInterface bi = (a)->{
			System.out.println("BInterface의 bb(int i) 호출됨 a = " + a);
		};
		
		bi.bb(15);
		///////////////////////////////////////////////////////////
		CInterface ci = (a, b)->{
			System.out.println("CInterface의 cc(int i , int j) 호출됨..");
			return a*b;
		};
		
		int result = ci.cc(5, 4);
        System.out.println("결과 : " + result);
	}

}
////////////////////////////////////////////////
/*class AInterfaceImpl implements AInterface{
	@Override
	public void aa() {
		System.out.println("AInterfaceImpl 의 aa 호출됨!!");
	}
	
}*/