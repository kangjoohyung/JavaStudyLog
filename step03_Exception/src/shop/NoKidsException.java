package shop;
/**
 * ���̰� 18���� ���� ��� �߻��� ���ܰ�ü
 * */
public class NoKidsException extends Exception { //üũ��������
//public class NoKidsException extends RuntimeException { //üũ��������
    static int count;
	
	public NoKidsException() {
	   super("�ֵ��� ����");
	   count++;
   }
   
   public NoKidsException(String message) {
	   super(message);
	   count++;
   }
}
