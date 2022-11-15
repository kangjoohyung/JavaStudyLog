package ex0802.exam;
/**
 * ��� �Խ����� ������ �������� ����ϰ� �� �޼ҵ� ����(�԰ݼ�)
 * */
public interface BoardInterface {

	/**
	 ����ϱ� 
	  @return : 0�̸� ����, 1 �̻��̸� ���� 
	  @param : QABoard �Ǵ� FreeBoard �Ǵ� UploadBoard
    */
	int insert(Board board); //
	
	/**
	 * �����ϱ�(�۹�ȣ�� �ش��ϴ� ���� �����Ѵ�)
	 * @return : true�̸�  �����Ϸ�, false�̸� ��������
	 * 
	  @param : QABoard �Ǵ� FreeBoard �Ǵ� UploadBoard
	 * */
	boolean update(Board board);
	
	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� �˻�
	 * */
	Board selectByBno(int bno);
	/////////////////////////////////////////////
	/**
       java version 1.8�� �߰��� ����
           : interface���� �޼ҵ忡 static�̳� default�����ڸ� �߰��ϸ�
             abstract�� �ƴ� ����� �ִ� �޼ҵ带 ����� �ִ�.
             ������ ����� �̸� �����ϰ� �״�� ����Ҽ� �ְ�
             �ٸ� ����� �ϰ� ������츸 ���������� �������ؼ� ����Ѵ�.
             
             
         1) static
              : ������ü���� �ٷ� interface�̸�.�޼ҵ��̸�() �ϰ� �����Ҽ� �ִ�.
         
         2) default 
             : �ݵ�� ������ü�� �̿��ؼ� ȣ���Ҽ� �ִ�.

    */
	/*
	 * �亯��� �޼ҵ� 
	 * */
	default void replyInsert() {
		System.out.println("BoardInterface�� replyInsert() �Դϴ�.");
	} 
	 
	static void selectAll() {
	   System.out.println("BoardInterface�� selectAll() �Դϴ�..");	
	}
}














