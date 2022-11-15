package ex0802.exam;

public class FreeServiceImpl implements BoardInterface {

	@Override
	public int insert(Board board) {
		System.out.println("FreeServiceImpl의 insert 입니다...");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("FreeServiceImpl의 update 입니다...");
		return true;
	}

	@Override
	public Board selectByBno(int bno) {
        System.out.println("FreeServiceImpl의 selectByBno(int bno) 입니다.");
		return new FreeBoard(bno, "Free", "효리", "Free검색완료");
	}

}








