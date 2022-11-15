package kosta.mvc.dto;

/**
 * 댓글의 정보=속성 관리하는 객체 
 * */
public class ReplyDTO {
   private int replyNo; //댓글번호
   private String replyContent;//댓글내용
   private int boardNo;//부모글 글번호
   private String replyRegdate; //등록일
   
   
   
   public ReplyDTO() {}
   
   public ReplyDTO( String replyContent, int boardNo) { //댓글내용 , 부모글의 글번호
		this.replyContent = replyContent;
		this.boardNo = boardNo;
   }

   public ReplyDTO(int replyNo, String replyContent, int boardNo, String replyRegdate) {
	this(replyContent, boardNo);
	
	this.replyNo = replyNo;
	this.replyRegdate = replyRegdate;
  }

	public int getReplyNo() {
		return replyNo;
	}
	
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	
	public String getReplyContent() {
		return replyContent;
	}
	
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	public String getReplyRegdate() {
		return replyRegdate;
	}
	
	public void setReplyRegdate(String replyRegdate) {
		this.replyRegdate = replyRegdate;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReplyDTO [replyNo=");
		builder.append(replyNo);
		builder.append(", replyContent=");
		builder.append(replyContent);
		builder.append(", boardNo=");
		builder.append(boardNo);
		builder.append(", replyRegdate=");
		builder.append(replyRegdate);
		builder.append("]");
		return builder.toString();
	}
	
	
   
  
}


