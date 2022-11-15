package ex0801.abstract_final;

//Error �� �����ϰ� ������ �ּ����� ó���ϼ���.

final class FinalClassExam{ //��ӺҰ�, ��������
 final int i = -999999; //������Ұ�, �ݵ�� ������� �ʱ�ȭ�ʼ�.
}


abstract class AbstractClassExam{//��Ӱ���, �����Ұ�
    abstract String abstractMethodExam(int i,String s); //��ɾ��� �������ؼ� ���   
    final int finalMethodExam(int i, int j){ //�����ǺҰ�
        return i+j;
    }
}


class Sample01 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
	//final�޼ҵ��̹Ƿ� ������ �Ұ�
	/*int finalMethodExam(int i, int j){
		return i*j;
	}*/
	
}

class Sample02 /*extends FinalClassExam*/{ //finalŬ�����̹Ƿ� ��ӺҰ�, ����������
	
	
}


//abstract�޼ҵ带 ������ Ŭ������ �ݵ�� abstractŬ������ �����Ѵ�.  
abstract class Sample03 extends AbstractClassExam{
	
	 //������ �̸��� �޼ҵ尡 �ִ°�� �μ��� �ٸ��� �ؾ��Ѵ�.
	 String abstractMethodExam(String s, int i){
		return s+i;
	 }
	 
	abstract String abstractMethodExam(int i,String s);    

	void sampleMethod03(){
		System.out.println("void sampleMethod03() ȣ�� ��");
	}
}
////////////////////////////////////////////////////////////////
class AbstractFinalClassTest{
    public static void main(String args[]){
		AbstractClassExam ace/* = new AbstractClassExam()*/; //abstractŬ���� �����ȵ�! 
		FinalClassExam fce = new FinalClassExam();
		//fce.i=100000;//����̹Ƿ� ������Ұ�
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}
