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

public class JFrameAnonymousInnerExam extends JFrame {//BorderLayout Manger �⺻ 
	JButton btn1 = new JButton("Ŭ��1");
	JButton btn2 = new JButton("Ŭ��2");
	
	JTextField text = new JTextField(10);
	
	JTextArea textArea = new JTextArea(5, 10);
	
	int count;
	
	/**
	 * �ַ� ȭ�鱸���� �����ڿ��� �ۼ��Ѵ�.
	 * */
     public JFrameAnonymousInnerExam() {
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
    	 setDefaultCloseOperation(JFrameAnonymousInnerExam.EXIT_ON_CLOSE);
    	 
    	 //�̺�Ʈ��� => �̺�Ʈ�߻���ü.addXxxListener(�̺�Ʈó����ü);
    	 btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(count++ +"�� Ŭ�� ");
				
			}
		});
    	 
    	 btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append(count++ +"�� Ŭ�� \n");
				
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
    			JFrameAnonymousInnerExam.this.setTitle("���콺�ִ�....");
    		}
    		 
    		 @Override
    		public void mouseExited(MouseEvent e) {
    			setTitle("���콺 ����.....");
    		}
		});
    	 
    	 
     }//�����ڳ�
     
	public static void main(String[] args) {
		new JFrameAnonymousInnerExam();

	}
	
	

}//Ŭ������
////////////////////////////////////////////////////////////







