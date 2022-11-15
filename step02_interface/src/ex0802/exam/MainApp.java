package ex0802.exam;

public class MainApp {
	 
	//필드를 이용한 다형성 
	private BoardInterface boardInterface;
	private Board board;
	
	public MainApp() {
		//test작업
		//1. QA
		boardInterface = new QAServiceImpl();
		board = new QABoard(1, "QA test", "희정", "다형성", false);
		test(boardInterface, board);
		
		System.out.println("------------------------------------");
		//2. Free
		boardInterface = new FreeServiceImpl();
		board = new FreeBoard(2, "Free Test", "미나","재미있다");
		test(boardInterface, board);
		
		System.out.println("----------------------------------");
		//3. Upload
		boardInterface = new UploadServiceImpl();
		board = new UploadBoard(3, "UpLoad Test", "삼식", "좋아요", "a.jpg");
		test(boardInterface, board);
		
		System.out.println("============================");
		//4. Photo게시판 
		boardInterface = new BoardInterface() {
			
			@Override
			public boolean update(Board board) {
				System.out.println("Photo의 update....");
				return false;
			}
			
			@Override
			public Board selectByBno(int bno) {
				System.out.println("Photo의 selectByBno....");
				return new Board();
			}
			
			@Override
			public int insert(Board board) {
				System.out.println("Photo의 insert....");
				return 0;
			}
		};
		
		test(boardInterface, board);
		
		
	}//생성자
	
	public void test(BoardInterface bi , Board board) { //매개변수를 이용한 다형성
		//등록
		bi.insert(board);
		 
		//수정
		bi.update(board);
		
		
		//부분검색
		Board returnBoard =bi.selectByBno(10);
		System.out.println(returnBoard);
		
		//답변
		bi.replyInsert();
		
		//전체검색
		BoardInterface.selectAll();
		
	}

	public static void main(String[] args) {
		System.out.println("****시작하기 ************");
		
		 new MainApp();
	}

}







