package ex0801.abstract_final;

//Error 를 수정하고 이유를 주석으로 처리하세요.

final class FinalClassExam{ //상속불가, 생성가능
 final int i = -999999; //값변경불가, 반드시 사용전에 초기화필수.
}


abstract class AbstractClassExam{//상속가능, 생성불가
    abstract String abstractMethodExam(int i,String s); //기능없고 재정의해서 사용   
    final int finalMethodExam(int i, int j){ //재정의불가
        return i+j;
    }
}


class Sample01 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
	//final메소드이므로 재정의 불가
	/*int finalMethodExam(int i, int j){
		return i*j;
	}*/
	
}

class Sample02 /*extends FinalClassExam*/{ //final클래스이므로 상속불가, 생성은가능
	
	
}


//abstract메소드를 정의한 클래스는 반드시 abstract클래스로 선언한다.  
abstract class Sample03 extends AbstractClassExam{
	
	 //동일한 이름의 메소드가 있는경우 인수를 다르게 해야한다.
	 String abstractMethodExam(String s, int i){
		return s+i;
	 }
	 
	abstract String abstractMethodExam(int i,String s);    

	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}
////////////////////////////////////////////////////////////////
class AbstractFinalClassTest{
    public static void main(String args[]){
		AbstractClassExam ace/* = new AbstractClassExam()*/; //abstract클래스 생성안됨! 
		FinalClassExam fce = new FinalClassExam();
		//fce.i=100000;//상수이므로 값변경불가
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}
