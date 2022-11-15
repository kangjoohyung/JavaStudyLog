package ex0802.exam;

public class FreeServiceImpl implements BoardInterface {

	@Override
	public int insert(Board board) {
		System.out.println("FreeServiceImpl�� insert �Դϴ�...");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("FreeServiceImpl�� update �Դϴ�...");
		return true;
	}

	@Override
	public Board selectByBno(int bno) {
        System.out.println("FreeServiceImpl�� selectByBno(int bno) �Դϴ�.");
		return new FreeBoard(bno, "Free", "ȿ��", "Free�˻��Ϸ�");
	}

}








