package kosta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB연동을 위한 로드, 연결, 닫기
 */

public class DbUtil {
/**
 * 로드: 연결하려는 DBMS를 선택하는 과정(DB lib가 필요하다)
 */
	static { //꼭 static 블럭 아니어도 된다. 생성자에서 해도 괜찮다. 메소드에서는 적당하지 않다.
		try {
		Class.forName(DbProperties.DRIVER_NAME); //인터페이스에서 상수 만든후 코딩
		//Class.forName("oracle.jdbc.driver.OracleDriver"); 
		//대소문자 가리고 정해져있다. (pdf2page), 못찾거나 하면 익셉션생김,
		//바뀌지 않기때문에 상수로 관리하거나 외부 파일로 관리함. -> 위 코딩 인터페이스에서 만들어놓은 상수로 변경
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
/**
 * 연결: 
 */
	public static Connection getConnection() throws SQLException {
		Connection con=DriverManager.getConnection(DbProperties.URL,DbProperties.USER_ID,DbProperties.USER_PWD);
		return con;
	}
/**
 * 닫기 - 사용된 객체 닫기-select인 경우
 */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			dbClose(con,st);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
/**
 * 닫기-사용된 객체 닫기-DML or DDL인경우
 */
	public static void dbClose(Connection con, Statement st) {
		try {
			if(st!=null)st.close();
			if(con!=null)con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*public static void main(String[] args) {
		try {
			System.out.println("****메인 시작****");
			Connection con=DbUtil.getConnection();
			System.out.println("con="+con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//중간 확인용 메인메소드, MainApp으로 메인메소드 클래스 만들예정.*/
}
