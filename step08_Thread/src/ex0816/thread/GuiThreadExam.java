package ex0816.thread;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GuiThreadExam extends JFrame{
	JTextField text1 =new JTextField(5);
	JTextField text2 =new JTextField(5);
	
	JButton btn = new JButton("Ŭ��");
	
    boolean state;//false (true�̸� ������, false�̸� ����) 
	
    public GuiThreadExam() {
    	
    	setLayout(new FlowLayout()); //JFrame�� ���̾ƿ�����
    	
    	Container con = super.getContentPane();
    	con.add(text1);
    	con.add(text2);
    	con.add(btn);
    	
    	setSize(500, 400);//JFrame�� ũ�� 
    	setLocationRelativeTo(null);//���߾ӿ� ���� 
    	setVisible(true);
    	//x�� Ŭ�������� ���α׷� ����
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	new TimerThread().start();
    	new DecimalThread(text1).start();
    	
    	//�̺�Ʈ ���
        btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// a ~ z text�ڽ��� ��� 
				if(!state) {
					state=true;
					/*new Thread(){//355page
						public void run() {
							for(char ch='A' ; ch <= 'z' ; ch++) {
							  text2.setText(ch+"");
							  try {
							     Thread.sleep(100);//0.1��
							  }catch (Exception e) {
								e.printStackTrace();
							  }
							}//for��
							
							state=false; 
						}//run����
				   }.start();*/
					/////////////////
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							for(char ch='A' ; ch <= 'z' ; ch++) {
								  text2.setText(ch+"");
								  try {
								     Thread.sleep(100);//0.1��
								  }catch (Exception e) {
									e.printStackTrace();
								  }
								}//for��
								
								state=false; 
							
						}
					}).start();
					
				}
				
			}
		});
    	
    }//�����ڳ�
	public static void main(String[] args) {
		new GuiThreadExam();

	}
	
	////////////////////////////////
	/**
	 * Jframe���� �ð踦 ���� �ϰ� �ϴ� Thread(1�ʸ��� ����)
	 * */
	class TimerThread extends Thread{
		@Override
		public void run() {
			while(true) {
				//���� ��¥�� �ð�
				Calendar now = Calendar.getInstance();
				
				int y = now.get(Calendar.YEAR);
				int m = now.get(Calendar.MONTH) +1;
				int d = now.get(Calendar.DATE);
				
				int h = now.get(Calendar.HOUR_OF_DAY);
				int min = now.get(Calendar.MINUTE);
				int s = now.get(Calendar.SECOND);
				
				String time = y+"�� " + m+"�� " + d +"�� " + h +" : "+ min +" : "+ s; 
				
				GuiThreadExam.this.setTitle(time);
				
				try {
				  Thread.sleep(1000); //1�� ������
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//while��
		}//runEnd
	}
	

}//Ŭ������
///////////////////////////////////
/**
 *  1 ~ 1000���� text�ڽ��� ����ϱ� 
 * */
class DecimalThread extends Thread{
	private JTextField text;
	public DecimalThread(JTextField text) {
		this.text = text;
	}
	@Override
	public void run() {
		for(int i=1; i <=1000 ; i++) {
			//text�ڽ��� ���� ���
			text.setText(i+"");
			try {
			  Thread.sleep(10);//0.01�� ���
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
//////////////////////////////////////////////////











