package ex0803;

import java.io.IOException;

public class ThrowExam {
	
	public void aa(int i) throws IOException , ArithmeticException {
		System.out.println("aa 호출됨....");
		try {
			if(i < 0) {
				//throw new RuntimeException(); //비체크예외 - 예외처리 선택
				throw new IOException("음수를 입력할수 없어요"); //체크예외 - 예외처리 필수 
			}
			
			int result = 100/i;
			System.out.println("result = " + result);
			
		}finally {
		    System.out.println("aa 호출끝 .....");
		}
	}

	public static void main(String[] args)/*throws IOException*/ {

           ThrowExam te = new ThrowExam();
           try {
            te.aa(-2);
           }catch (IOException | ArithmeticException e) {
        	   System.out.println("예외 : " + e.getMessage());
		    }
           
           /*catch (IOException e) {
			 System.out.println("예외1 : " + e.getMessage());
		   }catch (ArithmeticException e) {
			System.out.println("예외2 : "  + e.getMessage());
		   }*/
           System.out.println("끝.....");

	}

}
