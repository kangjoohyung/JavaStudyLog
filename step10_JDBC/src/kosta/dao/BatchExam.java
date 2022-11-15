package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import kosta.util.DbUtil;

public class BatchExam {
	
	/**
	 * 인수로 전달된 사원번호에 해당하는 레코드 삭제하기
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
			    ps.addBatch();//일괄처리작업을 하기위한 문장 추가
			    ps.clearParameters();//?들어가는 정보를 초기화 
			}
			
			/**
			 *  executeBatch()의 리턴값이 oracle v11g까지는 쿼리가 오류가아니면 무조건 -2를 리턴
			 *  
			 *  12c version부터는 executeBatch()의 리턴값이 각 쿼리의 결과의 반영된 레코드 행의 수 리턴!!
			 * */
			//한번에 DBMS에 전송
			int result [] = ps.executeBatch(); //리턴값은 각문장의 성공여부가 저장
			System.out.println("result.length = " + result.length);
			
			boolean state=false; //true이면 취소,  false이면 저장완료
			for(int i : result) {
				System.out.println(i);
				if(i==0) {
					state=true;
					break;
				}
			}
			
			if(state)con.rollback();
			else con.commit();
			
			//con.commit();//저장완료!!
			
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







