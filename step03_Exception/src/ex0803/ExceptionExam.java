package ex0803;

public class ExceptionExam {

	public static void main(String[] args) {
		System.out.println("****�����ϱ� *******************");
		try {
		  String param = args[0]; //ArrayIndexOutOfBoundsException
		  System.out.println("param = " + param);
		  
		  int convertNo = Integer.parseInt(param); //NumberFormatException
		  System.out.println("convertNo = " + convertNo);
		  
		  int result = 100/convertNo;
		  System.out.println("���� ��� : " + result);
		  
		}catch(ArrayIndexOutOfBoundsException e) {
			//���ܰ� �߻������� �ؾ��ϴ� �� �ۼ�!!
			System.out.println("e = " + e.toString()); //�߻����ܰ�ü : ���ܸ޽���
			System.out.println("�ݵ�� �μ��� �־��ּ���.");
		}catch (NumberFormatException e) {
			System.out.println("�ݵ�� ���ڸ� �Է����ּ���.");
			System.out.println("e.getMessage() = " + e.getMessage());
			
		}catch (Exception e) {
			System.out.println("���ܰ� �߻��߾��~~~");
			
			//���ܿ� ���� ������ Stack������ ��� �ξ��ٰ� �����޽��� �ѹ��� ������ش�.
			//���������� ���� detail�ϰ� ������ش�. �׷��� ���߸�忡�� �ʼ������� �ʿ��ϰ�
			//���忡���� �ݵ�� �����ؾ��Ѵ�.
			e.printStackTrace(); //�� �޼ҵ尡 ��±���� ������ �ִ�.
		}finally {
			System.out.println("���ܹ߻����ο� ������� �ݵ��  �����Ѵ�.....");
			
		}
		
		System.out.println("******�� *************************");

	}

}
