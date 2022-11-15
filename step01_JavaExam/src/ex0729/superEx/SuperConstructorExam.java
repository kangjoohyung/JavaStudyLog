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
		
		HelloTest t;//다른폴에 있기때문에 import 필요(ctrl + shift + O)
		
		JFrame f;
		JTextField text;
		InputStream is;
		
	}
	Parent(String s){
		System.out.println(3);
	}
	
}
/////////////////////////////////////////////////
class Child extends Parent{ //Child is a Parent 성립
	 Child() {
		this(10);//현재클래스 내에 int형 하나받는 생성자 호출
		System.out.println(4);
	}
	 
	Child(int i) {
		super(i); //부모의 int형 하나받는 생성자 호출
		System.out.println(5);
	}
	
	Child(boolean b) {
		super(b+"쫑"); //부모의 String 하나 받는 생성자 호출
		System.out.println(6);
	}
}
///////////////////////////////////////////////
public class SuperConstructorExam {
	public static void main(String[] args) {

		//new Child();//생성자호출된다.  1 4
		//new Child(5); // 1 5
		//new Child(true);// 1 6
		
		/*결론 : 자식이 생성될때 부모의 기본생성자를 호출한다.
		         자식생성자 구현부 첫번째 줄에 super() 생략된것과 같다.
		         자식이 생성될때 인수가 있는 생성자를 호출하더라도
		         부모의 기본생성자를 호출한다.
         */
		/////////////////////////////////////////////////////////////
		//만약, 1 ,2, 3 없다면 (부모가 생성자를 하나도 만들지 않는다면)
		//new Child();//
		//new Child(5); // 
		//new Child(true);// 
		
		/*
		 *부모의 생성자가 없으면 기본 생성자가 자동으로 삽입되기때문에
		 *오류 없이 잘 실행된다. 
		 * */
		/////////////////////////////////////////////////////////////
		
		/*
		 * 만약, 1 없고  , 2 3만 존재한다면(부모가 기본생자를 만들지않고
		 *  생성자를 만들어 놓았다면.....)
		 *   :자식 생성자 구현부 첫번째 줄에서 에러발생한다.
		 *    this(값, ...) 또는 super(값,...)를 이용해서 부모의 기본생성자가 아닌
		 *    다른 생성자를 호출 해야한다.
		 * */
		
		 new Child();
		
	}

}







