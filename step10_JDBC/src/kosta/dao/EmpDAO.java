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
	 * 모든 사원의 이름 검색
	 * 실행쿼리 : select ename from emp
	 * 
	 */
	public static void getSelectEname() {
		//로드 : DbUtil클래스에서 끝냄. 생략
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{//연결
			con=DbUtil.getConnection();
			
			//실행
			st=con.createStatement();
			rs=st.executeQuery("select ename from emp order by ename desc"); //""안에 ; 넣으면 오류남
			//executeQuery메소드는 오라클에 쿼리를 전송하고 그 결과를 받아온다.
			
			while(rs.next()) { //next()는 다음 위치로 이동(처음 컬럼제목에서 레코드 행으로 이동됨)
				//각 열의 값들을 조회한다.
				//rs.getString(int columnIndex); // 컬럼 1번쨰, 2번째...등등
				//rs.getString(String columnLabel); // 컬럼 이름으로
				String ename=rs.getString(1);//ename컬럼
				System.out.println(ename);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		//닫기
			DbUtil.dbClose(con,st,rs);
		}
	}
	/**
	 * 사원등록하기
	 * 
"insert into emp(empno, ename, job, sal, hiredate)values(9222,'미나','teacher',3000, sysdate)"
	 */
	public static void insert(Emp emp) {
		//로드 연결 실행 닫기
		Connection con=null;
		Statement st=null;
		//ResultSet 은 select할때만 씀, 위 두개는 DB만질때 무조건 씀
		
		String sql="insert into emp(empno, ename, job, sal, hiredate)"
				+ "values("+emp.getEmpno()+",'"+emp.getEname()+"','"+emp.getJob()+"',"+emp.getSal()+", sysdate)";
		System.out.println("sql="+sql);
		try {
			con=DbUtil.getConnection();
			st=con.createStatement();
			int result=st.executeUpdate(sql);
			if(result==0)System.out.println(result+":등록되지 않았습니다");
			else System.out.println(result+"등록되었습니다");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, st);
		}
	}
	/**
	 * 사원 등록하기 (PreparedStatement 이용하기)
	 */
	public static void preparedInsert(Emp emp) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="insert into emp(empno, ename, job, sal, hiredate)values(?,?,?,?, sysdate)";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql); //prepared가 아닌 prepare임 좀 헷갈림
			//만약 ?가 있다면 ?의 개수만큼 순서대로 setXxx필요
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getSal());
			//쿼리실행-DB쪽으로 쿼리 전송
			int result=ps.executeUpdate();
			if(result==0)System.out.println(result+":등록되지 않았습니다");
			else System.out.println(result+":등록되었습니다");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
	}

	/**
	 * 모든 사원의 정보를 검색
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
			
			//컬럼의 정보를 가져오기
			ResultSetMetaData rmd=rs.getMetaData();
			for(int i=1;i<=rmd.getColumnCount(); i++) {
				String columnName=rmd.getColumnName(i);
				System.out.print(columnName+" ");
			}
			System.out.println();
			
			while(rs.next()) {//커서를 앞으로 이동
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
