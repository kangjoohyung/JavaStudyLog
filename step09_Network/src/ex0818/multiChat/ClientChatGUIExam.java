package ex0818.multiChat;

import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.BorderLayout;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientChatGUIExam extends JFrame {
	JTextArea textArea=new JTextArea();
	JScrollPane jsp=new JScrollPane(textArea);
	JTextField textField=new JTextField();
	
	Socket sk;
	BufferedReader br;
	PrintWriter pw;

	public ClientChatGUIExam() throws HeadlessException {
		super("ä��â");
		Container con=super.getContentPane();
		con.add(jsp, BorderLayout.CENTER);
		con.add(textField, BorderLayout.SOUTH);
		
		//�ɼ� ����
		textArea.setFocusable(false);
		textArea.setBackground(getForeground());
		
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//������ ����
		this.connection();
		
		//������ �����ִ� �����͸� �޾Ƽ� textArea�� ����ϴ� ������
		Thread th=new Thread(()->{
			try {
				String data=null;
				while((data=br.readLine())!=null) {
					textArea.append(data+"\n");
					
					//��ũ���� ���������ڰ� �ִ� ��ġ�� �̵���Ű��
					textArea.setCaretPosition(textArea.getText().length());
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		th.setDaemon(true);//���ν����尡 ����Ǹ� �Բ� ����ȴ�
		th.start();
		
		//�̺�Ʈ ���(textField�� ����)
		textField.addActionListener((e)->{
			//textField�� ���� �о �������� �����Ѵ�
			String inputData=textField.getText();
			pw.println(inputData);
			
			//textField�� ���� �����
			textField.setText("");
		});
		
	}//������ ��
	/**
	 * ä���� ���� ������ ���� ���
	 */
	public void connection() {
		try {
			sk=new Socket("127.0.0.1", 8000);
			br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
			pw=new PrintWriter(sk.getOutputStream(), true);
			
			//��ȭ�� �Է�â�� ����
			String name=JOptionPane.showInputDialog(this, "��ȭ���� �Է����ּ���");
			
			//�������� ��ȭ���� �����Ѵ�
			pw.println(name);
			
			setTitle("["+name+"]"); //JFrame â�� ��ȭ�� ���
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientChatGUIExam();
	}

}
