package ex0803;

import java.io.IOException;

public class ThrowExam {
	
	public void aa(int i) throws IOException , ArithmeticException {
		System.out.println("aa ȣ���....");
		try {
			if(i < 0) {
				//throw new RuntimeException(); //��üũ���� - ����ó�� ����
				throw new IOException("������ �Է��Ҽ� �����"); //üũ���� - ����ó�� �ʼ� 
			}
			
			int result = 100/i;
			System.out.println("result = " + result);
			
		}finally {
		    System.out.println("aa ȣ�ⳡ .....");
		}
	}

	public static void main(String[] args)/*throws IOException*/ {

           ThrowExam te = new ThrowExam();
           try {
            te.aa(-2);
           }catch (IOException | ArithmeticException e) {
        	   System.out.println("���� : " + e.getMessage());
		    }
           
           /*catch (IOException e) {
			 System.out.println("����1 : " + e.getMessage());
		   }catch (ArithmeticException e) {
			System.out.println("����2 : "  + e.getMessage());
		   }*/
           System.out.println("��.....");

	}

}
