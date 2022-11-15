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
				MenuView.printMenuForMember(); //회원 접속
				break;
			case 2:
				//회원이면 printUserMenu(회원ID) 
				//비회원이면 printUserMenu(null)  
				MenuView.printUserMenu(null);//비회원은 바로 메인 메뉴 선택으로
				break;
			case 3:
				MenuView.printMenuForAdmin();//관리자 접속
				break;

			case 9:
				System.exit(0);
			}
		}

	}
	
	public static void printMenu() {
		System.out.println("=== Cafe ===");
		System.out.println("접속 유형을 선택해주세요");
		System.out.println("1. 회원으로 주문하기   |   2. 비회원으로 주문하기   |  3. 관리자 접속   |  9. 종료");
	}
	
	public static void printMenuForMember() { //회원접속 
	    while(true) {
			System.out.println("=== 회원으로 주문하기 ===");
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. 로그인   |   2. 아이디 찾기   |  3. 비밀번호 찾기   |  4. 회원가입 하기   |  9. 돌아가기");
			
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
				MenuView.register(); //회원가입 
				break;
			case 9:
				System.exit(0);
			}
		
		}//while
	}
	
	

	/**
	 * 로그인 
	 */
	private static void login() {
		System.out.print("아이디를 입력해 주세요 >");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호를 입력해 주세요 >");
		String userPw = sc.nextLine();
		
		CustomerController.login(userId, userPw);
	}
	
	/**
	 * 아이디 찾기  
	 */
	private static void findId( ) {
		System.out.print("핸드폰 번호를 입력해 주세요 >"); 
		int phonNum = sc.nextInt();
		
		CustomerController.findId(phonNum);
	}
	
	/**
	 * 비밀번호 찾기  
	 */
	private static void findPw() {
		System.out.print("아이디를 입력해 주세요 >"); 
		String useId = sc.nextLine();
		
		System.out.print("핸드폰 번호를 입력해 주세요 >"); 
		int phonNum = sc.nextInt();
		
		CustomerController.findPw(useId);
		CustomerController.findId(phonNum);
	}
	
	/**
	 * 회원가입  
	 */
	private static void register() {
		// TODO Auto-generated method stub
		
	}

	
	public static void printMenuForAdmin() {
	
		
	}
	
	
	//회원/비회원의 메뉴선택
	public static void printUserMenu(String userId) {
		while (true) {
//			UserSessionSet us = UserSessionSet.getInstance();
//			System.out.println(us.getSet()); //Set객체
			
			System.out.println("=== 메뉴 선택 ===");
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. 주문하기   |   2. 장바구니   |  3. 기프티콘으로 구매하기   |  4. 마이페이지   |  9. 돌아가기");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				case 1 : //주문하기 
				    System.out.println("1. 커피   |  2. 스무디/프라페   |  3. 에이드/주스   | 4. 병음료   |  5. 티   |  6. 디저트  | 7. MD상품   | 8. 상품이름검색   | 9. 돌아가기  ");
				    int menu2 =Integer.parseInt( sc.nextLine());
						switch(menu2) {
							case 1 :
								GoodsController.goodsSelectCoffee(); //커피
								break;
							case 2 :
								GoodsController.goodsSelectSmoothieFrape();// 스무디/프라페
								break;
							case 3 :
								GoodsController.goodsSelectAdeJuice(); //에이드 주스
								break;
							case 4 :
								GoodsController.goodsSelectBottleBever(); // 병음료
								break;
							case 5 : 
								GoodsController.goodsSelectTea(); // 티 
								break;	
							case 6 : 
								GoodsController.goodsSelectDessert();// 디저트
								break;
							case 7 :
								GoodsController.goodsSelectMD();// MD
								break;
							case 8 :
								GoodsController.goodsSelect(); //돌아가기
								break;
							case 9 :
								System.exit(0);
							}
				case 2 : //장바구니 
				case 3 : //기프티콘으로 구매하기 
				case 4 : //마이페이지
				case 9 : 
					System.exit(0);
						
				}
			}
		}
	}

