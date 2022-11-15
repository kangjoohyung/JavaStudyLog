package kosta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB������ ���� �ε�, ����, �ݱ�
 */

public class DbUtil {
/**
 * �ε�: �����Ϸ��� DBMS�� �����ϴ� ����(DB lib�� �ʿ��ϴ�)
 */
	static { //�� static �� �ƴϾ �ȴ�. �����ڿ��� �ص� ������. �޼ҵ忡���� �������� �ʴ�.
		try {
		Class.forName(DbProperties.DRIVER_NAME); //�������̽����� ��� ������ �ڵ�
		//Class.forName("oracle.jdbc.driver.OracleDriver"); 
		//��ҹ��� ������ �������ִ�. (pdf2page), ��ã�ų� �ϸ� �ͼ��ǻ���,
		//�ٲ��� �ʱ⶧���� ����� �����ϰų� �ܺ� ���Ϸ� ������. -> �� �ڵ� �������̽����� �������� ����� ����
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
/**
 * ����: 
 */
	public static Connection getConnection() throws SQLException {
		Connection con=DriverManager.getConnection(DbProperties.URL,DbProperties.USER_ID,DbProperties.USER_PWD);
		return con;
	}
/**
 * �ݱ� - ���� ��ü �ݱ�-select�� ���
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
 * �ݱ�-���� ��ü �ݱ�-DML or DDL�ΰ��
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
			System.out.println("****���� ����****");
			Connection con=DbUtil.getConnection();
			System.out.println("con="+con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//�߰� Ȯ�ο� ���θ޼ҵ�, MainApp���� ���θ޼ҵ� Ŭ���� ���鿹��.*/
}
