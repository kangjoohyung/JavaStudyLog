package ex0817.thread;

public class InterruptedExam {

	public static void main(String[] args) {
		System.out.println("****���� �����մϴ�****");
		Thread th=new Thread(()->{
			try {
				while(true) {
					System.out.println("Thread ����ִ�");
					Thread.sleep(1);
				}
			}catch(InterruptedException e) {
					e.printStackTrace();
			}
		});
		th.start();
		
		try {
		//3�ʰ� ������ th �����带 �����Ų��
		Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		//interrupt()�� �����尡 ��� �Ͻ� �������°� �Ǿ�߸� ���� �����带 ������ų �� �ִ�
		th.interrupt(); // th �����带 ������Ų��
		
		System.out.println("****���� �����մϴ�****");
		
	}

}
