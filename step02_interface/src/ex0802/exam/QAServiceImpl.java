package ex0802.exam;

public class QAServiceImpl implements BoardInterface {
 
	@Override
	public int insert(Board board) {
		System.out.println("QAServiceImpl�� insert call....");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("QAServiceImpl�� update call....");
		return true;
	}

	@Override
	public Board selectByBno(int bno) {
		System.out.println("QAServiceImpl�� selectByBno(int bno) call");
		
		Board board = new QABoard(bno, "QA", "����", "�۹�ȣ�˻��Ϸ�", false);
		
		return board;
	}
	
	@Override
	public void replyInsert() {
		System.out.println("QAServiceImp�� replyInsert�Դϴ�....");
	}

}




