package ex0729.superEx;

import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JTextField;

import ex0729.HelloTest;

class Parent{
	/*Parent(){
		System.out.println(1);
	}*/
	
	Parent(int i){
		System.out.println(2);
		
		HelloTest t;//�ٸ����� �ֱ⶧���� import �ʿ�(ctrl + shift + O)
		
		JFrame f;
		JTextField text;
		InputStream is;
		
	}
	Parent(String s){
		System.out.println(3);
	}
	
}
/////////////////////////////////////////////////
class Child extends Parent{ //Child is a Parent ����
	 Child() {
		this(10);//����Ŭ���� ���� int�� �ϳ��޴� ������ ȣ��
		System.out.println(4);
	}
	 
	Child(int i) {
		super(i); //�θ��� int�� �ϳ��޴� ������ ȣ��
		System.out.println(5);
	}
	
	Child(boolean b) {
		super(b+"��"); //�θ��� String �ϳ� �޴� ������ ȣ��
		System.out.println(6);
	}
}
///////////////////////////////////////////////
public class SuperConstructorExam {
	public static void main(String[] args) {

		//new Child();//������ȣ��ȴ�.  1 4
		//new Child(5); // 1 5
		//new Child(true);// 1 6
		
		/*��� : �ڽ��� �����ɶ� �θ��� �⺻�����ڸ� ȣ���Ѵ�.
		         �ڽĻ����� ������ ù��° �ٿ� super() �����ȰͰ� ����.
		         �ڽ��� �����ɶ� �μ��� �ִ� �����ڸ� ȣ���ϴ���
		         �θ��� �⺻�����ڸ� ȣ���Ѵ�.
         */
		/////////////////////////////////////////////////////////////
		//����, 1 ,2, 3 ���ٸ� (�θ� �����ڸ� �ϳ��� ������ �ʴ´ٸ�)
		//new Child();//
		//new Child(5); // 
		//new Child(true);// 
		
		/*
		 *�θ��� �����ڰ� ������ �⺻ �����ڰ� �ڵ����� ���ԵǱ⶧����
		 *���� ���� �� ����ȴ�. 
		 * */
		/////////////////////////////////////////////////////////////
		
		/*
		 * ����, 1 ����  , 2 3�� �����Ѵٸ�(�θ� �⺻���ڸ� �������ʰ�
		 *  �����ڸ� ����� ���Ҵٸ�.....)
		 *   :�ڽ� ������ ������ ù��° �ٿ��� �����߻��Ѵ�.
		 *    this(��, ...) �Ǵ� super(��,...)�� �̿��ؼ� �θ��� �⺻�����ڰ� �ƴ�
		 *    �ٸ� �����ڸ� ȣ�� �ؾ��Ѵ�.
		 * */
		
		 new Child();
		
	}

}







