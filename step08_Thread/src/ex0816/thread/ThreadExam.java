package ex0816.thread;

public class ThreadExam {

	public static void main(String[] args) {
		System.out.println("***���� �����մϴ� ****************");
		
		NumberThread th1 = new NumberThread("ù��° Thread");
		NumberThread th2 = new NumberThread("�ι�° Thread");
		
		AlphaThread alpah = new AlphaThread();
		Thread th3 = new Thread(alpah, "����° Thread");
		
		/*th1.run();
		th2.run();
		th3.run();*/
		
		//�켱����
		//th1.setPriority(Thread.MAX_PRIORITY);
        //th2.setPriority(Thread.MIN_PRIORITY);
        
		th1.start();
		th2.start();
		th3.start();
		/*try {
		  th1.join(); //Ư���� Thread��(th1) ���� �� ��ĥ������ �Ʒ� ������ ��� 
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println("�� �� = " +  th1.sum );
		
	    System.out.println("****���� �� �Դϴ�. ***************");

	}

}
//////////////////////////////////////////////////
/**
 *  1 ~ 100���� ����ϴ� ��� Thread
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
			  Thread.sleep(100);//0.1�� ��� (���罺���带 �������·� ����� - �����ð��� ������ ���(�غ�)���·ΰ���.)
			}catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			Thread.yield();//�纸 (������ ���¿��� �����·� �̵�) 
		}
		System.out.println(super.getName()+" ����!");
	}
}
////////////////////////////////////////

/**
 * A~Z���� ����ϴ� ��� Thread
 * */
class AlphaThread implements Runnable{
	@Override
	public void run() {
	    Thread th = Thread.currentThread(); //���� �������� Thread��ü
		
		for(char ch ='A' ; ch <= 'z' ; ch++) {
			System.out.println(th.getName() +" ==> " + ch + " , getPriority = " + th.getPriority());
			/*try {
			 Thread.sleep(30);;//0.03��
			}catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			Thread.yield();//�纸 (������ ���¿��� �����·� �̵�) 
		}
		System.out.println(th.getName()+" ===> ����!!!!");
		
	}
	
}








