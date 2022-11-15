package ex0816.thread;

public class SynchronizedExam {

	public static void main(String[] args) {
		System.out.println("****Bank OPEN ****************");
		
		Bank bank = new Bank();
		
		CustomerThread cu1 = new CustomerThread(bank, "������", true);
		CustomerThread cu2 = new CustomerThread(bank, "�Һ���", false);
		
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
 *  �������� Thread�� ������ ��ü 
 * */
 class Bank{
	 int balance;//0
	 
	 /**
	  * @param : state�� true��� �Ա�(������) , false��� ���(�Һ���) 
	  *  
	  *   synchronized ���ȿ��� Ư�� �����带 wait() �ϰ�
	  *   wait()�� ���� ���������� �����带 notify(), notifyAll()�� ��� ���·�  ����� �ִ�.
	  * */
	 public synchronized void balanceChange(String name , boolean state) {
		 if(state) {
			 if(balance==0) {
				//synchronized (this) { //�μ��� this�� ������ü�� ����
				 System.out.print(name +"===> ���� �ܾ� : " + balance +" , ");
				 balance++;
				 System.out.println(name+"===> ���� �� �� �ܾ� : " + balance);
			  //}
			 }else {
				 System.out.println(name + " ������Դϴ�......");
				 try {
				   wait();
				 }catch (Exception e) {
					e.printStackTrace();
				}
			 }
			 
		 }else {
			 if(balance > 0) {
				//synchronized (this) {
				 System.out.print(name +"===> ���� �ܾ� : " + balance +" , ");
				 balance--;
				 System.out.println(name+"===> ���� �� �� �ܾ� : " + balance);
			   //}
			 }else {
				 System.out.println(name+"������Դϴ�.....");
				 try {
				   wait();
				 }catch (Exception e) {
					e.printStackTrace();
				}
			 }
		 }//else��
		 
		 notifyAll();// wait()�� ���� ���������� �����带 �����.
		 
	 }//�޼ҵ� ��
 }//Ŭ���� ��

///////////////////////////////////////////////////////////
 /**
  * �� Thread
  * */
 class CustomerThread extends Thread{
	 Bank bank;
	 String name;
	 boolean state;
	 CustomerThread(Bank bank , String name , boolean state){
		 super(name);//Thread�̸� 
		 this.bank=bank;
		 this.name=name;
		 this.state=state;
	 }
	 
	 @Override
	public void run() {
		 for(int i=1; i <= 50 ; i++) {
			 //����ȣ��
			 bank.balanceChange(name, state);
		 }
		 System.out.println(super.getName()+" End***********");
	}
 }








