package mvc.view;

import java.util.Properties;
import java.util.Scanner;

import kosta.util.DbUtil;
import mvc.view.MenuView;
import mvc.controller.CustomerController;
import mvc.session.UserSession;
import mvc.controller.CustomerController;
import mvc.session.UserSessionSet;
import mvc.session.UserSession;
import mvc.controller.GoodsController;
import mvc.session.UserSessionSet;
import mvc.controller.GoodsController;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	private Properties proFile = DbUtil.getProFile();

	public static void menu() {
		while (true) {
			UserSessionSet us = UserSessionSet.getInstance();
			//System.out.println(ss.getSet());
			
			MenuView.printMenu();
			
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.printMenuForMember(); //ȸ�� ����
				break;
			case 2:
				//ȸ���̸� printUserMenu(ȸ��ID) 
				//��ȸ���̸� printUserMenu(null)  
				MenuView.printUserMenu(null);//��ȸ���� �ٷ� ���� �޴� ��������
				break;
			case 3:
				MenuView.printMenuForAdmin();//������ ����
				break;

			case 9:
				System.exit(0);
			}
		}

	}
	
	public static void printMenu() {
		System.out.println("=== Cafe ===");
		System.out.println("���� ������ �������ּ���");
		System.out.println("1. ȸ������ �ֹ��ϱ�   |   2. ��ȸ������ �ֹ��ϱ�   |  3. ������ ����   |  9. ����");
	}
	
	public static void printMenuForMember() { //ȸ������ 
	    while(true) {
			System.out.println("=== ȸ������ �ֹ��ϱ� ===");
			System.out.println("�޴��� �������ּ���");
			System.out.println("1. �α���   |   2. ���̵� ã��   |  3. ��й�ȣ ã��   |  4. ȸ������ �ϱ�   |  9. ���ư���");
			
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1: 
				MenuView.login();
				break;
			case 2:
				MenuView.findId();
				break;
			case 3:
				MenuView.findPw();
				break;
			case 4:
				MenuView.register(); //ȸ������ 
				break;
			case 9:
				System.exit(0);
			}
		
		}//while
	}
	
	

	/**
	 * �α��� 
	 */
	private static void login() {
		System.out.print("���̵� �Է��� �ּ��� >");
		String userId = sc.nextLine();
		
		System.out.print("��й�ȣ�� �Է��� �ּ��� >");
		String userPw = sc.nextLine();
		
		CustomerController.login(userId, userPw);
	}
	
	/**
	 * ���̵� ã��  
	 */
	private static void findId( ) {
		System.out.print("�ڵ��� ��ȣ�� �Է��� �ּ��� >"); 
		int phonNum = sc.nextInt();
		
		CustomerController.findId(phonNum);
	}
	
	/**
	 * ��й�ȣ ã��  
	 */
	private static void findPw() {
		System.out.print("���̵� �Է��� �ּ��� >"); 
		String useId = sc.nextLine();
		
		System.out.print("�ڵ��� ��ȣ�� �Է��� �ּ��� >"); 
		int phonNum = sc.nextInt();
		
		CustomerController.findPw(useId);
		CustomerController.findId(phonNum);
	}
	
	/**
	 * ȸ������  
	 */
	private static void register() {
		// TODO Auto-generated method stub
		
	}

	
	public static void printMenuForAdmin() {
	
		
	}
	
	
	//ȸ��/��ȸ���� �޴�����
	public static void printUserMenu(String userId) {
		while (true) {
//			UserSessionSet us = UserSessionSet.getInstance();
//			System.out.println(us.getSet()); //Set��ü
			
			System.out.println("=== �޴� ���� ===");
			System.out.println("�޴��� �������ּ���");
			System.out.println("1. �ֹ��ϱ�   |   2. ��ٱ���   |  3. ����Ƽ������ �����ϱ�   |  4. ����������   |  9. ���ư���");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				case 1 : //�ֹ��ϱ� 
				    System.out.println("1. Ŀ��   |  2. ������/������   |  3. ���̵�/�ֽ�   | 4. ������   |  5. Ƽ   |  6. ����Ʈ  | 7. MD��ǰ   | 8. ��ǰ�̸��˻�   | 9. ���ư���  ");
				    int menu2 =Integer.parseInt( sc.nextLine());
						switch(menu2) {
							case 1 :
								GoodsController.goodsSelectCoffee(); //Ŀ��
								break;
							case 2 :
								GoodsController.goodsSelectSmoothieFrape();// ������/������
								break;
							case 3 :
								GoodsController.goodsSelectAdeJuice(); //���̵� �ֽ�
								break;
							case 4 :
								GoodsController.goodsSelectBottleBever(); // ������
								break;
							case 5 : 
								GoodsController.goodsSelectTea(); // Ƽ 
								break;	
							case 6 : 
								GoodsController.goodsSelectDessert();// ����Ʈ
								break;
							case 7 :
								GoodsController.goodsSelectMD();// MD
								break;
							case 8 :
								GoodsController.goodsSelect(); //���ư���
								break;
							case 9 :
								System.exit(0);
							}
				case 2 : //��ٱ��� 
				case 3 : //����Ƽ������ �����ϱ� 
				case 4 : //����������
				case 9 : 
					System.exit(0);
						
				}
			}
		}
	}

