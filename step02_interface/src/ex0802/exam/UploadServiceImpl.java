package ex0802.exam;

public class UploadServiceImpl implements BoardInterface {

	@Override
	public int insert(Board board) {
		System.out.println("UploadServiceImpl insert ȣ��Ǿ����ϴ�...");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("UploadServiceImpl�� update ȣ��Ǿ����ϴ�...");
		return false;
	}

	@Override
	public Board selectByBno(int bno) {
	    System.out.println("UploadServiceImpl�� selectByBno(int bno) ȣ��Ǿ����ϴ�.");
		return new UploadBoard(bno, "Upload", "����", "Upload�˻��Ϸ�", "test.jpg----");
	}

}





