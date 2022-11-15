package kosta.util;
/**
* interface 안에 있는 모든 필드는 상수이다 - public static final 자동이다.
* 상수는 모두 대문자로 쓴다.
 * 
 */
public interface DbProperties {
	String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
	String URL="jdbc:oracle:thin:@localhost:1521:xe"; //사용자마다 다름, pdf1page
	String USER_ID="c##scott"; //c##구분잘하기
	String USER_PWD="TIGER"; //pw대소문자 가림
}
