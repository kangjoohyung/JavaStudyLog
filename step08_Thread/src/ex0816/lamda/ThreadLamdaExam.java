package ex0816.lamda;

public class ThreadLamdaExam {

	public static void main(String[] args) {
		System.out.println("***���� �����մϴ� ****************");
		
		Runnable r = ()->{
			Thread th = Thread.currentThread();
			for(int i=1; i <=100 ; i++) {
				System.out.println(th.getName()+" => " + i  +" , getPriority = " + th.getPriority());
			}
			System.out.println(th.getName()+" ����!");
		};
		
		Thread th1 = new Thread(r, "ù��° Thread");
		
		
		NumberThread th2 = new NumberThread("�ι�° Thread");
		
	
		Thread th3 = new Thread(()->{
			
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
			
		}, "����° Thread");
		
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
		
		System.out.println("�� �� = " +  th2.sum );
		
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








