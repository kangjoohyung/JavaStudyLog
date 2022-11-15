package ex0804.list;

import java.util.List;

public interface StudentService {
  /**
   * ����ϱ�  
   * @return : true�̸� ��ϼ���, false�̸� ��Ͻ���
   */
	boolean insert(Student st);
	
	/**
	 *��ü�˻�
	 * */
	List<Student> selectAll();
	
	/**
	 * �й��� �ش��ϴ� �л��� ���� �˻�
	 * */
	Student selectBySno(String sno);
	
	/**
	 * �й��� �ش��ϴ� �л��� ����  ����
	 * @return : true�̸� ��������, false�̸� ��������
	 * */
	 boolean delete(String sno);
	
	/**
	 * �й��� �ش��ϴ� �л��� ���� �����ϱ� (����, �ּҸ� ����)
	 * @return : true�̸� ��������, false�̸� ��������
	 * */
	 boolean update(Student student);
}








