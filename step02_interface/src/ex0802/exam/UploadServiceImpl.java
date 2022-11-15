package ex0802.exam;

public class UploadServiceImpl implements BoardInterface {

	@Override
	public int insert(Board board) {
		System.out.println("UploadServiceImpl insert 호출되었습니다...");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("UploadServiceImpl의 update 호출되었습니다...");
		return false;
	}

	@Override
	public Board selectByBno(int bno) {
	    System.out.println("UploadServiceImpl의 selectByBno(int bno) 호출되었습니다.");
		return new UploadBoard(bno, "Upload", "나영", "Upload검색완료", "test.jpg----");
	}

}





