package kosta.exam.model.dto;

public class FreeBoard extends Board {
   private int readNum;
   
   public FreeBoard() {}
   public FreeBoard(int no, String subject, String writer, 
 		            String content, String date, int readNum) {
 	super(no, subject, writer, content, date);
 	
 	this.readNum=readNum;
   }
   
   
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	   
	@Override
	public String toString() {
		return super.toString() +" | " + readNum ;
	}
	   
}
