package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import kosta.util.DbUtil;

public class BatchExam {
	
	/**
	 * �μ��� ���޵� �����ȣ�� �ش��ϴ� ���ڵ� �����ϱ�
	 * */
	public static void delete(List<Integer> empnoList) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="delete from copy_emp where empno=?";
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			for(int empno : empnoList) {
			    ps.setInt(1, empno);
			    ps.addBatch();//�ϰ�ó���۾��� �ϱ����� ���� �߰�
			    ps.clearParameters();//?���� ������ �ʱ�ȭ 
			}
			
			/**
			 *  executeBatch()�� ���ϰ��� oracle v11g������ ������ �������ƴϸ� ������ -2�� ����
			 *  
			 *  12c version���ʹ� executeBatch()�� ���ϰ��� �� ������ ����� �ݿ��� ���ڵ� ���� �� ����!!
			 * */
			//�ѹ��� DBMS�� ����
			int result [] = ps.executeBatch(); //���ϰ��� �������� �������ΰ� ����
			System.out.println("result.length = " + result.length);
			
			boolean state=false; //true�̸� ���,  false�̸� ����Ϸ�
			for(int i : result) {
				System.out.println(i);
				if(i==0) {
					state=true;
					break;
				}
			}
			
			if(state)con.rollback();
			else con.commit();
			
			//con.commit();//����Ϸ�!!
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(7499,7521,9000,7698,7782,9002,7900);
		delete(list);

	}

}







