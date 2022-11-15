package ex0816.thread;

public class DeamonThreadExam {
	public static void main(String[] args) {
		System.out.println("****메인 시작합니다****");
		
		Runnable r=()->{
			while(true) {
				System.out.println("나는 데몬스레드입니다");
				try {
					Thread.sleep(500);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread th=new Thread(r);
		th.setDaemon(true);//데몬스레드-메인스레드가 종료되면 함께 종료된다
		th.start();
		
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("****메인 종료합니다****");
	}
}
