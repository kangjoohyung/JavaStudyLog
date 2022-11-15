package ex0729.solution.sample01;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FullTime [] full = new FullTime[3];
		
		PartTime [] part = new PartTime[2];

		
		full[0] = new FullTime(10, "���缮", "���׿��", 0 , "2013-05-01", "���ѵ���",8500,200);
		full[1] = new FullTime(20, "�ڸ��", "����",10, "2013-06-20", "���ѵ���",7500,100);
		full[2] = new FullTime(30, "������", "������",10 , "2013-06-22", "���ѵ���",6000,0);
		
		part[0] = new PartTime(40, "��ȫö", "������",20 , "2014-05-01", "���ѵ���",20000);
		part[1] = new PartTime(50, "����", "����",30 , "2014-05-02", "���ѵ���",25000);
		
		
		System.out.println("*****FullTime ���� ***************");
		for(FullTime f  : full) {
			System.out.println(f);//�μ��� ��ü�� ���� ��ü.toString()�ڵ� ȣ���̵ǰ� �����ϴ� ���� ����Ѵ�.!!
		}
		
		System.out.println("*****PartTime ���� ***************");
		for(PartTime p : part) {
			System.out.println(p);//p.toString()ȣ��ȴ�.
		}
		
		System.out.println("\n*****Message***********************");
		for(FullTime f: full) {
		   f.message();
		}
		
		for(PartTime p: part) {
			 p.message();
		}
	}

}






