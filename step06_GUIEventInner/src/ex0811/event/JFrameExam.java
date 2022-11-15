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

public class JFrameExam extends JFrame implements ActionListener{//BorderLayout Manger �⺻ 
	JButton btn1 = new JButton("Ŭ��1");
	JButton btn2 = new JButton("Ŭ��2");
	
	JTextField text = new JTextField(10);
	
	JTextArea textArea = new JTextArea(5, 10);
	
	/**
	 * �ַ� ȭ�鱸���� �����ڿ��� �ۼ��Ѵ�.
	 * */
     public JFrameExam() {
    	 super("JFrame�ǽ��Դϴ�.");
    	 
    	 //JFrame�� LayoutManger�� ��������
    	 setLayout(new FlowLayout());
    	 
    	 //JButton�߰��ϱ� 
    	 //add(btn1 , BorderLayout.EAST);
    	 //add(btn2, BorderLayout.SOUTH);
    	 
    	 add(btn1);
    	 add(btn2);
    	 
    	 add(text);
    	 add(textArea);
    	 
    	 //â�� ũ��
    	 setSize(500,400);
    	 
    	 //â�� ��ġ ����
    	 //setLocation(300,200);
    	 setLocationRelativeTo(null); //���߾ӿ� ����
    	 
    	 //ȭ�麸����
    	 setVisible(true);
    	 
    	 //x��Ŭ���ϸ� ���α׷� ����
    	 setDefaultCloseOperation(JFrameExam.EXIT_ON_CLOSE);
    	 
    	 //�̺�Ʈ��� => �̺�Ʈ�߻���ü.addXxxListener(�̺�Ʈó����ü);
    	 btn1.addActionListener(this);
    	 btn2.addActionListener(this);
    	 
    	 this.addMouseMotionListener(new MouseExam(text));
    	 
    	 this.addMouseListener(new MouseExam02(this));
    	 
    	 
     }//�����ڳ�
     
	public static void main(String[] args) {
		new JFrameExam();

	}
	
	int count;
	@Override
	public void actionPerformed(ActionEvent e) {
		//��� �ο�
		Object eventObj =e.getSource(); //�̺�Ʈ��ü�� ���´�.
		if(eventObj==btn1) {
			//System.out.println(e.getActionCommand()+"Ŭ���Ǿ����ϴ�.....");
			//text�ڽ��� ��ư�� Ŭ���Ѽ� count�� ����غ��� 
			text.setText(count  + "�� Ŭ��");
			textArea.append(count + "�� Ŭ��\n");
		    
			count++;
			
		}else{
			System.out.println(e.getActionCommand()+"Ŭ���Ǿ� ���α׷� �����մϴ�.");
            System.exit(0);
		}
		
	}


}//Ŭ������
////////////////////////////////////////////////////////////
/**
 * ���콺 �巡�� ������ ��� 
 * */
 class MouseExam extends MouseMotionAdapter{
	 JTextField text;
	 public MouseExam(JTextField text) {
		 this.text = text;
	 }
	 @Override
	public void mouseDragged(MouseEvent e) {
		//���콺�� ��ǥ�� ���ؼ� text�ڽ��� ����Ѵ�. 
		int x = e.getX();
		int y = e.getY();
		
		//System.out.println(x+", " + y +"��ġ Ŭ��");
		
		text.setText(x+", " + y +"��ġ Ŭ��");
	}
 }

///////////////////////////////////////////////////////////////////
 /**
  * ���콺 Enter or Exit 
  * */
class MouseExam02 extends MouseAdapter{
	JFrameExam je;
	public MouseExam02(JFrameExam je) {
		this.je=je;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		//jframe���� title����
		je.setTitle("���콺 �ִ�...");
		
		je.btn1.setText("���콺 �̺�Ʈó��..");
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		//jframe���� title����
		je.setTitle("���콺 ����...");
	}
}






















