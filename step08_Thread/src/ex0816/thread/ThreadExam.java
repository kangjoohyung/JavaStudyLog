package ex0816.thread;

public class ThreadExam {

	public static void main(String[] args) {
		System.out.println("***메인 시작합니다 ****************");
		
		NumberThread th1 = new NumberThread("첫번째 Thread");
		NumberThread th2 = new NumberThread("두번째 Thread");
		
		AlphaThread alpah = new AlphaThread();
		Thread th3 = new Thread(alpah, "세번째 Thread");
		
		/*th1.run();
		th2.run();
		th3.run();*/
		
		//우선순위
		//th1.setPriority(Thread.MAX_PRIORITY);
        //th2.setPriority(Thread.MIN_PRIORITY);
        
		th1.start();
		th2.start();
		th3.start();
		/*try {
		  th1.join(); //특정한 Thread가(th1) 일을 다 마칠때까지 아래 문장을 대기 
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println("총 합 = " +  th1.sum );
		
	    System.out.println("****메인 끝 입니다. ***************");

	}

}
//////////////////////////////////////////////////
/**
 *  1 ~ 100까지 출력하는 기능 Thread
 * */
class NumberThread extends Thread{
	int sum;
	public NumberThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i=1; i <=100 ; i++) {
			System.out.println(super.getName()+" => " + i  +" , getPriority = " + super.getPriority());
			sum+=i;
			/*try {
			  Thread.sleep(100);//0.1초 대기 (현재스레드를 중지상태로 만든다 - 일정시간이 끝나면 대기(준비)상태로간다.)
			}catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			Thread.yield();//양보 (실행중 상태에서 대기상태로 이동) 
		}
		System.out.println(super.getName()+" 종료!");
	}
}
////////////////////////////////////////

/**
 * A~Z까지 출력하는 기능 Thread
 * */
class AlphaThread implements Runnable{
	@Override
	public void run() {
	    Thread th = Thread.currentThread(); //현재 실행중인 Thread객체
		
		for(char ch ='A' ; ch <= 'z' ; ch++) {
			System.out.println(th.getName() +" ==> " + ch + " , getPriority = " + th.getPriority());
			/*try {
			 Thread.sleep(30);;//0.03초
			}catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			Thread.yield();//양보 (실행중 상태에서 대기상태로 이동) 
		}
		System.out.println(th.getName()+" ===> 종료!!!!");
		
	}
	
}








