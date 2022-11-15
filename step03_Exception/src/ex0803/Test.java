package ex0803;

public class Test {
   public void aa(int i) {
	   System.out.println("aa 메소드 시작...");
	   try {
		   if(i==0) {
			   //return ;
			   System.exit(0); //프로그램종료
		   }
	   }finally {
		   System.out.println("finally 영역입니다....");
	   }
	   System.out.println("aa 메소드 끝...");
   }
   
	public static void main(String[] args) {
		new Test().aa(0);

	}

}
