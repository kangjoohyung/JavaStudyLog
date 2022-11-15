package ex0817.thread;

public class InterruptedExam {

	public static void main(String[] args) {
		System.out.println("****메인 시작합니다****");
		Thread th=new Thread(()->{
			try {
				while(true) {
					System.out.println("Thread 재미있다");
					Thread.sleep(1);
				}
			}catch(InterruptedException e) {
					e.printStackTrace();
			}
		});
		th.start();
		
		try {
		//3초가 지나면 th 스레드를 종료시킨다
		Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		//interrupt()는 쓰레드가 잠시 일시 중지상태가 되어야만 현재 스레드를 중지시킬 수 있다
		th.interrupt(); // th 쓰레드를 중지시킨다
		
		System.out.println("****메인 종료합니다****");
		
	}

}
