package ex0811.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class JFrameExam extends JFrame {//BorderLayout Manger 기본 
	JButton btn1 = new JButton("클릭1");
	JButton btn2 = new JButton("클릭2");
	
	/**
	 * 주로 화면구성을 생성자에서 작성한다.
	 * */
     public JFrameExam() {
    	 super("JFrame실습입니다.");
    	 
    	 //JFrame의 LayoutManger를 변경하자
    	 setLayout(new FlowLayout());
    	 
    	 //JButton추가하기 
    	 //add(btn1 , BorderLayout.EAST);
    	 //add(btn2, BorderLayout.SOUTH);
    	 
    	 add(btn1);
    	 add(btn2);
    	 
    	 //창의 크기
    	 setSize(500,400);
    	 
    	 //창의 위치 설정
    	 //setLocation(300,200);
    	 setLocationRelativeTo(null); //정중앙에 놓기
    	 
    	 //화면보여줘
    	 setVisible(true);
    	 
    	 //x를클릭하면 프로그램 종료
    	 setDefaultCloseOperation(JFrameExam.EXIT_ON_CLOSE);
    	 
     }
	public static void main(String[] args) {
		new JFrameExam();

	}

}
