package kosta.exam.model.util;
/**
 * ���� ���θ� üũ�ϴ� Exception
 *   : �Խ����� ����, �Խ����� �۹�ȣ�� �ش��ϴ� �Խù�
 *   : DML(���,  ����, ����) ���� ����
 * */
public class InexistentException extends Exception {
	public InexistentException() {}
	public InexistentException(String message) {
		super(message);
	}
}


