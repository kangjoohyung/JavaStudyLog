package ex0811.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class JFrameExam extends JFrame {//BorderLayout Manger �⺻ 
	JButton btn1 = new JButton("Ŭ��1");
	JButton btn2 = new JButton("Ŭ��2");
	
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
    	 
    	 //â�� ũ��
    	 setSize(500,400);
    	 
    	 //â�� ��ġ ����
    	 //setLocation(300,200);
    	 setLocationRelativeTo(null); //���߾ӿ� ����
    	 
    	 //ȭ�麸����
    	 setVisible(true);
    	 
    	 //x��Ŭ���ϸ� ���α׷� ����
    	 setDefaultCloseOperation(JFrameExam.EXIT_ON_CLOSE);
    	 
     }
	public static void main(String[] args) {
		new JFrameExam();

	}

}
