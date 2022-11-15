package kosta.mvc.model.dao;

import java.sql.SQLException;

import kosta.mvc.model.dto.Customer;

public interface CustomerDAO {
  /**
   * 로그인하기
   * */
	Customer login(String userId, String userPwd)throws SQLException;
	
	/**
	 * 가입
	 * */
	
	/**
	 * 회원정보수정
	 * */
	
	/**
	 * 회원탈퇴
	 * */
}
