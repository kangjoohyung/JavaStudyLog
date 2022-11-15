package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kosta.util.DbUtil;



public class TransactionDAO {
  /**
   * ������ü ��� ����
   * */
	public void transfer(String inputAccount, String outputAccount, int money) {
		Connection con=null;
		
		try {
			con = DbUtil.getConnection();
			
			con.setAutoCommit(false);//�ڵ�Ŀ������!!!

			//1. ����� �Ѵ�. - update
			int result = this.withDraw(con, outputAccount, money);
			if(result==0)throw new SQLException("��ݰ��¿����� ������ü �����߽��ϴ�.^^");
			
			//2.  1�� �����̸� �Ա��� �Ѵ�. - update
			result=this.deposit(con, inputAccount, money);
			if(result==0) throw new SQLException("�Աݰ��¹�ȣ ������ ������ü �����߽��ϴ�.^^");
			
			//3. 2�� �����̸� �Աݰ����� �ܾ��� ��ȸ�Ѵ�. - select
			if( this.isCheckBalance(con, inputAccount) )
				throw new SQLException("�Աݰ��� �Ѿױݾ� �ʰ��� ������ü �����Ͽ����ϴ�.");
			
			//4. ��ȸ�� �ݾ��� 1000�̸��̸� commit�Ѵ�, �׿ܴ� ��� rollback�Ѵ�.
			con.commit();
			System.out.println("������ü �����Ͽ����ϴ�.!!!");
			
		}catch (Exception e) {
			e.printStackTrace();
			try {
			  con.rollback();
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println(e.getMessage());
		}finally {
			DbUtil.dbClose(con, null);
		}
		
	}
	
	/**
	 * ����ϱ� 
	 * update bank set balance=balance-? where account = ?
	 * */
	public int withDraw(Connection con , String outputAccount , int money)throws SQLException { //��ݰ��¹�ȣ, �ݾ� 
		PreparedStatement ps=null;
		String sql="update bank set balance=balance-? where account = ?";
		int result=0;
		try {
		   ps = con.prepareStatement(sql);
		   ps.setInt(1, money);
		   ps.setString(2, outputAccount);
		   
		   result = ps.executeUpdate();
		   
		}finally {
			DbUtil.dbClose(null, ps);
		}
		
		return result;
	}
	
	/**
	 * �Ա��ϱ�
	 * update bank set balance=balance+? where account =?
	 * */
     public int deposit(Connection con , String inputAccount , int money)throws SQLException { //�԰��¹�ȣ, �ݾ� 
    	 PreparedStatement ps=null;
 		String sql="update bank set balance=balance+? where account =?";
 		int result=0;
 		try {
 		   ps = con.prepareStatement(sql);
 		   ps.setInt(1, money);
 		   ps.setString(2, inputAccount);
 		   
 		   result = ps.executeUpdate();
 		   
 		}finally {
 			DbUtil.dbClose(null, ps);
 		}
 		
 		return result;
	}
	
	/**
	 * �ܾ���ȸ�ϱ� 
	 * @return : true�̸� �ܾ��ʰ�,  false�̸� �ʰ��ƴϴ�.
	 * 
	 * select balance from bank where account=?
	 * */
     public boolean isCheckBalance(Connection con, String inputAccount)throws SQLException {//�Աݰ��¹�ȣ
    	 PreparedStatement ps=null;
    	 ResultSet rs=null;
    	 boolean result=false;
    	 String sql="select balance from bank where account=?";
    	 try {
    		 ps =con.prepareStatement(sql);
    		 ps.setString(1, inputAccount);
    		 rs = ps.executeQuery();
    		 if(rs.next()) {
    			 int balance = rs.getInt(1);
    			 if(balance >1000)result=true;
    		 }
    		 
    	 }finally {
    		 DbUtil.dbClose(null, ps, rs);
    	 }
    	 return result;
     }
	
	
	
	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
		//System.out.println("--1. ��ݰ��� ����----");
		//dao.transfer("A02", "A05",200);//�Ա�, ���, �ݾ�
		
		//System.out.println("--2. �Աݰ��� ����----");
		//dao.transfer("A04", "A01",200);//�Ա�, ���, �ݾ�
		
		
		//System.out.println("--3. �Աݰ����� �Ѿ� 1000�� �̻��ΰ��----");
		//dao.transfer("A02", "A01",700);//�Ա�, ���, �ݾ�
		
		System.out.println("--4. ����----------");
		dao.transfer("A02", "A01",100);//�Ա�, ���, �ݾ�
	}
}











