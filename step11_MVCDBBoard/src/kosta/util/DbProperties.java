package kosta.util;
/**
* interface �ȿ� �ִ� ��� �ʵ�� ����̴� - public static final �ڵ��̴�.
* ����� ��� �빮�ڷ� ����.
 * 
 */
public interface DbProperties {
	String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
	String URL="jdbc:oracle:thin:@localhost:1521:xe"; //����ڸ��� �ٸ�, pdf1page
	String USER_ID="c##exam"; //c##�������ϱ�
	String USER_PWD="kang"; //pw��ҹ��� ����
}
