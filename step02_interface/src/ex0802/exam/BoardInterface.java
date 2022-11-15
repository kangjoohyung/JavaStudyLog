package ex0802.exam;
/**
 * 모든 게시판의 유형이 공통으로 사용하게 될 메소드 정의(규격서)
 * */
public interface BoardInterface {

	/**
	 등록하기 
	  @return : 0이면 실패, 1 이상이면 성공 
	  @param : QABoard 또는 FreeBoard 또는 UploadBoard
    */
	int insert(Board board); //
	
	/**
	 * 수정하기(글번호에 해당하는 정보 수정한다)
	 * @return : true이면  수정완료, false이면 수정실패
	 * 
	  @param : QABoard 또는 FreeBoard 또는 UploadBoard
	 * */
	boolean update(Board board);
	
	/**
	 * 글번호에 해당하는 게시물 검색
	 * */
	Board selectByBno(int bno);
	/////////////////////////////////////////////
	/**
       java version 1.8에 추가된 문법
           : interface안의 메소드에 static이나 default제한자를 추가하면
             abstract이 아닌 기능이 있는 메소드를 만들수 있다.
             공통의 기능을 미리 정의하고 그대로 사용할수 있고
             다른 기능을 하고 싶은경우만 선택적으로 재정의해서 사용한다.
             
             
         1) static
              : 구현객체없이 바로 interface이름.메소드이름() 하고 접근할수 있다.
         
         2) default 
             : 반드시 구현객체를 이용해서 호출할수 있다.

    */
	/*
	 * 답변기능 메소드 
	 * */
	default void replyInsert() {
		System.out.println("BoardInterface의 replyInsert() 입니다.");
	} 
	 
	static void selectAll() {
	   System.out.println("BoardInterface의 selectAll() 입니다..");	
	}
}














