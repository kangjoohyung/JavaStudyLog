package ex0816.thread;

public class SynchronizedExam {

	public static void main(String[] args) {
		System.out.println("****Bank OPEN ****************");
		
		Bank bank = new Bank();
		
		CustomerThread cu1 = new CustomerThread(bank, "생산자", true);
		CustomerThread cu2 = new CustomerThread(bank, "소비자", false);
		
		cu1.start();
		cu2.start();
		
		try {
			cu1.join();
			cu2.join();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("****Bank CLOSE ****************");

	}

}
////////////////////////////////////////
/**
 *  여러개의 Thread가 공유할 객체 
 * */
 class Bank{
	 int balance;//0
	 
	 /**
	  * @param : state는 true라면 입금(생산자) , false라면 출금(소비자) 
	  *  
	  *   synchronized 블럭안에서 특정 스레드를 wait() 하고
	  *   wait()에 의해 중지상태인 스레드를 notify(), notifyAll()로 대기 상태로  만들수 있다.
	  * */
	 public synchronized void balanceChange(String name , boolean state) {
		 if(state) {
			 if(balance==0) {
				//synchronized (this) { //인수의 this는 공유객체를 뜻함
				 System.out.print(name +"===> 현재 잔액 : " + balance +" , ");
				 balance++;
				 System.out.println(name+"===> 증가 한 후 잔액 : " + balance);
			  //}
			 }else {
				 System.out.println(name + " 대기중입니다......");
				 try {
				   wait();
				 }catch (Exception e) {
					e.printStackTrace();
				}
			 }
			 
		 }else {
			 if(balance > 0) {
				//synchronized (this) {
				 System.out.print(name +"===> 현재 잔액 : " + balance +" , ");
				 balance--;
				 System.out.println(name+"===> 감소 한 후 잔액 : " + balance);
			   //}
			 }else {
				 System.out.println(name+"대기중입니다.....");
				 try {
				   wait();
				 }catch (Exception e) {
					e.printStackTrace();
				}
			 }
		 }//else끝
		 
		 notifyAll();// wait()에 의해 중지상태인 스레드를 깨운다.
		 
	 }//메소드 끝
 }//클래스 끝

///////////////////////////////////////////////////////////
 /**
  * 고객 Thread
  * */
 class CustomerThread extends Thread{
	 Bank bank;
	 String name;
	 boolean state;
	 CustomerThread(Bank bank , String name , boolean state){
		 super(name);//Thread이름 
		 this.bank=bank;
		 this.name=name;
		 this.state=state;
	 }
	 
	 @Override
	public void run() {
		 for(int i=1; i <= 50 ; i++) {
			 //은행호출
			 bank.balanceChange(name, state);
		 }
		 System.out.println(super.getName()+" End***********");
	}
 }








