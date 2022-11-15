package ex0811.event;

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
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;

public class JFrameExam extends JFrame implements ActionListener{//BorderLayout Manger 기본 
	JButton btn1 = new JButton("클릭1");
	JButton btn2 = new JButton("클릭2");
	
	JTextField text = new JTextField(10);
	
	JTextArea textArea = new JTextArea(5, 10);
	
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
    	 setDefaultCloseOperation(JFrameExam.EXIT_ON_CLOSE);
    	 
    	 //이벤트등록 => 이벤트발생주체.addXxxListener(이벤트처리객체);
    	 btn1.addActionListener(this);
    	 btn2.addActionListener(this);
    	 
    	 this.addMouseMotionListener(new MouseExam(text));
    	 
    	 this.addMouseListener(new MouseExam02(this));
    	 
    	 
     }//생성자끝
     
	public static void main(String[] args) {
		new JFrameExam();

	}
	
	int count;
	@Override
	public void actionPerformed(ActionEvent e) {
		//기능 부여
		Object eventObj =e.getSource(); //이벤트주체를 얻어온다.
		if(eventObj==btn1) {
			//System.out.println(e.getActionCommand()+"클릭되었습니다.....");
			//text박스에 버튼을 클릭한수 count를 출력해보자 
			text.setText(count  + "번 클릭");
			textArea.append(count + "번 클릭\n");
		    
			count++;
			
		}else{
			System.out.println(e.getActionCommand()+"클릭되어 프로그램 종료합니다.");
            System.exit(0);
		}
		
	}


}//클래스끝
////////////////////////////////////////////////////////////
/**
 * 마우스 드래그 했을때 기능 
 * */
 class MouseExam extends MouseMotionAdapter{
	 JTextField text;
	 public MouseExam(JTextField text) {
		 this.text = text;
	 }
	 @Override
	public void mouseDragged(MouseEvent e) {
		//마우스의 좌표를 구해서 text박스에 출력한다. 
		int x = e.getX();
		int y = e.getY();
		
		//System.out.println(x+", " + y +"위치 클릭");
		
		text.setText(x+", " + y +"위치 클릭");
	}
 }

///////////////////////////////////////////////////////////////////
 /**
  * 마우스 Enter or Exit 
  * */
class MouseExam02 extends MouseAdapter{
	JFrameExam je;
	public MouseExam02(JFrameExam je) {
		this.je=je;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		//jframe위에 title변경
		je.setTitle("마우스 있다...");
		
		je.btn1.setText("마우스 이벤트처리..");
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		//jframe위에 title변경
		je.setTitle("마우스 없다...");
	}
}






















