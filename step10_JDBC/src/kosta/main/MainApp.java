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
		System.out.println("----1. ename ��������----");
		EmpDAO.getSelectEname();
		System.out.println("----2. ��� ����ϱ�----");
		//EmpDAO.insert(new Emp(9333,"����","����",5000)); 
		//�ߺ� insert�ȵǾ� �ι������ϸ� �翬�� ��������.
		System.out.println("----3. ��� ����ϱ�(Prepared)----");
		//EmpDAO.preparedInsert(new Emp(9444,"ȿ��","����",2500));
		System.out.println("----4. ��ü ��� �˻��ϱ�----");
		List<Emp> list=EmpDAO.selectAll();
		
		System.out.println("****LIST ����غ��� ****");
		for(Emp e:list) {
			System.out.println(e);
		}
	}
}
