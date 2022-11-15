package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kosta.util.DbUtil;
import kosta.vo.Emp;

public class SqlInjectionTest2 {
	/**
	 * Statement인경우
	 * select empno, ename, job, sal, hiredate from emp where sal> '2000'
	 */
	public static void statementTest(String param) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String sql="select empno, ename, job, sal, hiredate from emp where sal> '2000'"+param+" order by sal";
		try {
			con = DbUtil.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Emp emp=new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
				System.out.println(emp); //emp.toString()
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, st, rs);
		}
	}
	/**
	 * PreparedStatement인경우
	 * select empno, ename, job, sal, hiredate from emp where sal> '2000'
	 */
	public static void preparedStatementTest(String param) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select empno, ename, job, sal, hiredate from emp where sal> ?"+param+" order by sal";
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1,param);
			while(rs.next()) {
				Emp emp=new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
				System.out.println(emp); //emp.toString()
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
	}

	public static void main(String[] args) {
		System.out.println("----1. Statement인 경우----");
		statementTest("2000");
		
		System.out.println("\n----2.PreparedStatement인경우----");
		preparedStatementTest("2000");

	}
}
