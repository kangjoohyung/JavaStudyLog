package ex0803;

public class Test {
   public void aa(int i) {
	   System.out.println("aa �޼ҵ� ����...");
	   try {
		   if(i==0) {
			   //return ;
			   System.exit(0); //���α׷�����
		   }
	   }finally {
		   System.out.println("finally �����Դϴ�....");
	   }
	   System.out.println("aa �޼ҵ� ��...");
   }
   
	public static void main(String[] args) {
		new Test().aa(0);

	}

}
