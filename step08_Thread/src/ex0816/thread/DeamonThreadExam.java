package ex0816.thread;

public class DeamonThreadExam {
	public static void main(String[] args) {
		System.out.println("****���� �����մϴ�****");
		
		Runnable r=()->{
			while(true) {
				System.out.println("���� ���󽺷����Դϴ�");
				try {
					Thread.sleep(500);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread th=new Thread(r);
		th.setDaemon(true);//���󽺷���-���ν����尡 ����Ǹ� �Բ� ����ȴ�
		th.start();
		
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("****���� �����մϴ�****");
	}
}
