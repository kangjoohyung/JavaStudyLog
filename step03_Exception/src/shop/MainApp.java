package shop;

import java.util.Random;

public class MainApp {

	public static void main(String[] args)/*throws NoKidsException */ {
		System.out.println("======Store Open =======================");
		ShoppingMall sm = new ShoppingMall();
		Random rd = new Random();
		
			for(int i=0; i < 10 ; i++) {
			  // int age = (int)(Math.random()*55)+1;
				int age = rd.nextInt(55)+1; // 1 ~ 55
			   try {
			     sm.enter(age);
			   }catch (NoKidsException e) {
				  System.out.println(e.getMessage());
			   }
			   
			   System.out.println();
			}
		
		
		System.out.println("======Store Close =======================");
        System.out.println("ÃÑ ¿¹¿Ü ¼Õ´Ô : " + NoKidsException.count  + "¸í");
	}

}





