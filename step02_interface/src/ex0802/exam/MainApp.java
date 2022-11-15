package ex0802.exam;

public class MainApp {
	 
	//�ʵ带 �̿��� ������ 
	private BoardInterface boardInterface;
	private Board board;
	
	public MainApp() {
		//test�۾�
		//1. QA
		boardInterface = new QAServiceImpl();
		board = new QABoard(1, "QA test", "����", "������", false);
		test(boardInterface, board);
		
		System.out.println("------------------------------------");
		//2. Free
		boardInterface = new FreeServiceImpl();
		board = new FreeBoard(2, "Free Test", "�̳�","����ִ�");
		test(boardInterface, board);
		
		System.out.println("----------------------------------");
		//3. Upload
		boardInterface = new UploadServiceImpl();
		board = new UploadBoard(3, "UpLoad Test", "���", "���ƿ�", "a.jpg");
		test(boardInterface, board);
		
		System.out.println("============================");
		//4. Photo�Խ��� 
		boardInterface = new BoardInterface() {
			
			@Override
			public boolean update(Board board) {
				System.out.println("Photo�� update....");
				return false;
			}
			
			@Override
			public Board selectByBno(int bno) {
				System.out.println("Photo�� selectByBno....");
				return new Board();
			}
			
			@Override
			public int insert(Board board) {
				System.out.println("Photo�� insert....");
				return 0;
			}
		};
		
		test(boardInterface, board);
		
		
	}//������
	
	public void test(BoardInterface bi , Board board) { //�Ű������� �̿��� ������
		//���
		bi.insert(board);
		 
		//����
		bi.update(board);
		
		
		//�κа˻�
		Board returnBoard =bi.selectByBno(10);
		System.out.println(returnBoard);
		
		//�亯
		bi.replyInsert();
		
		//��ü�˻�
		BoardInterface.selectAll();
		
	}

	public static void main(String[] args) {
		System.out.println("****�����ϱ� ************");
		
		 new MainApp();
	}

}







