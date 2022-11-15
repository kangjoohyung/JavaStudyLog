package ex0803;

public class ExceptionExam {

	public static void main(String[] args) {
		System.out.println("****시작하기 *******************");
		try {
		  String param = args[0]; //ArrayIndexOutOfBoundsException
		  System.out.println("param = " + param);
		  
		  int convertNo = Integer.parseInt(param); //NumberFormatException
		  System.out.println("convertNo = " + convertNo);
		  
		  int result = 100/convertNo;
		  System.out.println("나눈 결과 : " + result);
		  
		}catch(ArrayIndexOutOfBoundsException e) {
			//예외가 발생했을때 해야하는 일 작성!!
			System.out.println("e = " + e.toString()); //발생예외객체 : 예외메시지
			System.out.println("반드시 인수를 넣어주세요.");
		}catch (NumberFormatException e) {
			System.out.println("반드시 숫자만 입력해주세요.");
			System.out.println("e.getMessage() = " + e.getMessage());
			
		}catch (Exception e) {
			System.out.println("예외가 발생했어요~~~");
			
			//예외에 대한 정보를 Stack영역에 모아 두었다가 오류메시지 한번에 출력해준다.
			//예외정보를 가장 detail하게 출력해준다. 그래서 개발모드에서 필수적으로 필요하고
			//운영모드에서는 반드시 제거해야한다.
			e.printStackTrace(); //이 메소드가 출력기능을 가지고 있다.
		}finally {
			System.out.println("예외발생여부와 상관없이 반드시  실행한다.....");
			
		}
		
		System.out.println("******끝 *************************");

	}

}
