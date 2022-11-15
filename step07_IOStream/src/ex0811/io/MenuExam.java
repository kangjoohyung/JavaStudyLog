package ex0811.io;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MenuExam extends JFrame {
	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("����(F)");
	JMenu edit = new JMenu("����");
	JMenu help = new JMenu("Help");
	JMenu align = new JMenu("����");
	
	JMenuItem nFile = new JMenuItem("������");
	JMenuItem open = new JMenuItem("����");
	JMenuItem save = new JMenuItem("����");
	JMenuItem exit = new JMenuItem("����");
	
	
	JCheckBoxMenuItem name = new JCheckBoxMenuItem("�̸�");
	JCheckBoxMenuItem date = new JCheckBoxMenuItem("��¥");
	
	JMenuItem info = new JMenuItem("����");
	
	JTextArea text = new JTextArea();
	JScrollPane jsp = new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JDialog dialog = new JDialog(this, "help");
	JLabel dName= new JLabel("kang seok min"  );
	JButton enter = new JButton("Ȯ ��");

	
	BufferedInputStream bi = null;
	
	public MenuExam(){
		super("�������");
		Container con = getContentPane();
	
		//�޴� ����Ű
		file.setMnemonic('F'); //Alt + F
		
		
		
		//�޴������ۿ� ����Ű
		nFile.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke('E', InputEvent.CTRL_MASK ^ InputEvent.ALT_MASK));
	
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		
		file.add(nFile);
		file.add(save);
		file.add(open);
		file.addSeparator();
		file.add(exit);
		
		edit.add(align);
		align.add(name);
		align.add(date);
		
		help.add(info);
		
		setJMenuBar(menuBar);
		con.add(jsp, BorderLayout.CENTER);
		
		Toolkit toolkit = getToolkit();
		Dimension dim = toolkit.getScreenSize();
		int screenWidth = dim.width;
		int screenHeight = dim.height;
		
		dName.setHorizontalAlignment(JLabel.CENTER);
		dialog.add(dName, "Center");
		dialog.add(enter, "South");
		dialog.setBounds(((screenWidth-200)/2), ((screenHeight-200)/2), 200, 200);
		
		setBounds(((screenWidth-500)/2), ((screenHeight-500)/2), 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//�̺�Ʈ ���
		nFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(""); // text.append("");//���� �߰�!!!!
				MenuExam.this.setTitle("�������");
			}
		});
		
	
		

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				
			}
		});
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();//���̾�α�â�� �ݱ�
				
			}
		});
		
		
		//�����ϱ� 
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog fileSave = new FileDialog(MenuExam.this, "Save", FileDialog.SAVE);
				fileSave.setVisible(true);
				
				String dir = fileSave.getDirectory();
				String fileName = fileSave.getFile();
				//System.out.println(dir+"/"+fileName);
				
				try(BufferedOutputStream  bos =
						new BufferedOutputStream(new FileOutputStream(dir+"/"+fileName))) {
				//���Ͼ��� - Buffered�̿�
				  
				  String data = text.getText();
				  bos.write(data.getBytes());
				  
				  bos.flush();
				  
				  setTitle(fileName);
				
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		//���� 
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileOpen = new JFileChooser();
				int mode = fileOpen.showOpenDialog(MenuExam.this);
				System.out.println("mode : " + mode);
				
				if(mode== JFileChooser.APPROVE_OPTION){
					
					File file = fileOpen.getSelectedFile();//����������
					
				    try(BufferedInputStream bis = 
				    		new BufferedInputStream(new FileInputStream(file))){
				    	
				    	byte b [] = new byte[bis.available()];
				    	bis.read(b);
				    	
				    	text.setText(new String(b));
				    	
				    	setTitle(file.getName());//Ÿ��Ʋ�� ���� �ֱ� 
				    	
				    }catch(Exception ex) {
				    	ex.printStackTrace();
				    }
				}//if����
			}
		});
		
	}
	
	public static void main(String[] args) {
		new MenuExam();
	}

}






