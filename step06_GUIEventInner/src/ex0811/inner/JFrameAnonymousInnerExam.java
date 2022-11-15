package ex0811.inner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;

public class JFrameAnonymousInnerExam extends JFrame {//BorderLayout Manger 기본 
	JButton btn1 = new JButton("클릭1");
	JButton btn2 = new JButton("클릭2");
	
	JTextField text = new JTextField(10);
	
	JTextArea textArea = new JTextArea(5, 10);
	
	int count;
	
	/**
	 * 주로 화면구성을 생성자에서 작성한다.
	 * */
     public JFrameAnonymousInnerExam() {
    	 super("JFrame실습입니다.");
    	 
    	 //JFrame의 LayoutManger를 변경하자
    	 setLayout(new FlowLayout());
    	 
    	 //JButton추가하기 
    	 //add(btn1 , BorderLayout.EAST);
    	 //add(btn2, BorderLayout.SOUTH);
    	 
    	 add(btn1);
    	 add(btn2);
    	 
    	 add(text);
    	 add(textArea);
    	 
    	 //창의 크기
    	 setSize(500,400);
    	 
    	 //창의 위치 설정
    	 //setLocation(300,200);
    	 setLocationRelativeTo(null); //정중앙에 놓기
    	 
    	 //화면보여줘
    	 setVisible(true);
    	 
    	 //x를클릭하면 프로그램 종료
    	 setDefaultCloseOperation(JFrameAnonymousInnerExam.EXIT_ON_CLOSE);
    	 
    	 //이벤트등록 => 이벤트발생주체.addXxxListener(이벤트처리객체);
    	 btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(count++ +"번 클릭 ");
				
			}
		});
    	 
    	 btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append(count++ +"번 클릭 \n");
				
			}
		});
    	 
    	 this.addMouseMotionListener(new MouseMotionAdapter() {
    		 @Override
    		public void mouseDragged(MouseEvent e) {
    			text.setText(e.getX() +" , " + e.getY());
    		}
		});
    	 
    	 
    	 this.addMouseListener(new MouseAdapter() {
    		 @Override
    		public void mouseEntered(MouseEvent e) {
    			JFrameAnonymousInnerExam.this.setTitle("마우스있다....");
    		}
    		 
    		 @Override
    		public void mouseExited(MouseEvent e) {
    			setTitle("마우스 없다.....");
    		}
		});
    	 
    	 
     }//생성자끝
     
	public static void main(String[] args) {
		new JFrameAnonymousInnerExam();

	}
	
	

}//클래스끝
////////////////////////////////////////////////////////////







