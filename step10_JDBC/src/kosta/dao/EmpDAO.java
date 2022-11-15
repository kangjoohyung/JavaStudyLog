package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kosta.util.DbUtil;
import kosta.vo.Emp;

public class EmpDAO {
	/**
	 * ��� ����� �̸� �˻�
	 * �������� : select ename from emp
	 * 
	 */
	public static void getSelectEname() {
		//�ε� : DbUtilŬ�������� ����. ����
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{//����
			con=DbUtil.getConnection();
			
			//����
			st=con.createStatement();
			rs=st.executeQuery("select ename from emp order by ename desc"); //""�ȿ� ; ������ ������
			//executeQuery�޼ҵ�� ����Ŭ�� ������ �����ϰ� �� ����� �޾ƿ´�.
			
			while(rs.next()) { //next()�� ���� ��ġ�� �̵�(ó�� �÷����񿡼� ���ڵ� ������ �̵���)
				//�� ���� ������ ��ȸ�Ѵ�.
				//rs.getString(int columnIndex); // �÷� 1����, 2��°...���
				//rs.getString(String columnLabel); // �÷� �̸�����
				String ename=rs.getString(1);//ename�÷�
				System.out.println(ename);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		//�ݱ�
			DbUtil.dbClose(con,st,rs);
		}
	}
	/**
	 * �������ϱ�
	 * 
"insert into emp(empno, ename, job, sal, hiredate)values(9222,'�̳�','teacher',3000, sysdate)"
	 */
	public static void insert(Emp emp) {
		//�ε� ���� ���� �ݱ�
		Connection con=null;
		Statement st=null;
		//ResultSet �� select�Ҷ��� ��, �� �ΰ��� DB������ ������ ��
		
		String sql="insert into emp(empno, ename, job, sal, hiredate)"
				+ "values("+emp.getEmpno()+",'"+emp.getEname()+"','"+emp.getJob()+"',"+emp.getSal()+", sysdate)";
		System.out.println("sql="+sql);
		try {
			con=DbUtil.getConnection();
			st=con.createStatement();
			int result=st.executeUpdate(sql);
			if(result==0)System.out.println(result+":��ϵ��� �ʾҽ��ϴ�");
			else System.out.println(result+"��ϵǾ����ϴ�");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, st);
		}
	}
	/**
	 * ��� ����ϱ� (PreparedStatement �̿��ϱ�)
	 */
	public static void preparedInsert(Emp emp) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="insert into emp(empno, ename, job, sal, hiredate)values(?,?,?,?, sysdate)";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql); //prepared�� �ƴ� prepare�� �� �򰥸�
			//���� ?�� �ִٸ� ?�� ������ŭ ������� setXxx�ʿ�
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getSal());
			//��������-DB������ ���� ����
			int result=ps.executeUpdate();
			if(result==0)System.out.println(result+":��ϵ��� �ʾҽ��ϴ�");
			else System.out.println(result+":��ϵǾ����ϴ�");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
	}

	/**
	 * ��� ����� ������ �˻�
	 * select empno, ename, job, sal, hiredate from emp
	 */
	public static List<Emp> selectAll() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select empno, ename, job, sal, hiredate from emp";
		List<Emp> list=new ArrayList<Emp>();
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			//�÷��� ������ ��������
			ResultSetMetaData rmd=rs.getMetaData();
			for(int i=1;i<=rmd.getColumnCount(); i++) {
				String columnName=rmd.getColumnName(i);
				System.out.print(columnName+" ");
			}
			System.out.println();
			
			while(rs.next()) {//Ŀ���� ������ �̵�
				int empno=rs.getInt("empno");
				String ename=rs.getString("ENAME");
				String job=rs.getString(3);
				int sal=rs.getInt(4);
				String hiredate=rs.getString(5);
				System.out.println(empno+"|"+ename+"|"+job+"|"+hiredate);
				
				list.add(new Emp(empno, ename, job, sal, hiredate));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
}
