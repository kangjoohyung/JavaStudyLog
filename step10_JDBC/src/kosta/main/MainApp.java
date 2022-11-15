package kosta.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import kosta.dao.EmpDAO;
import kosta.util.DbUtil;
import kosta.vo.Emp;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("----1. ename 가져오기----");
		EmpDAO.getSelectEname();
		System.out.println("----2. 사원 등록하기----");
		//EmpDAO.insert(new Emp(9333,"쩡이","백조",5000)); 
		//중복 insert안되어 두번실행하면 당연히 오류난다.
		System.out.println("----3. 사원 등록하기(Prepared)----");
		//EmpDAO.preparedInsert(new Emp(9444,"효리","가수",2500));
		System.out.println("----4. 전체 사원 검색하기----");
		List<Emp> list=EmpDAO.selectAll();
		
		System.out.println("****LIST 출력해보자 ****");
		for(Emp e:list) {
			System.out.println(e);
		}
	}
}
