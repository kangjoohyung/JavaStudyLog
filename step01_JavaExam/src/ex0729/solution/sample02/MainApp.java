package ex0729.solution.sample02;



public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Employee emp [] = new Employee [5]; //�ʵ带 �̿��� ������
		
		emp[0] = new FullTime(10, "���缮", "���׿��", 0 , "2013-05-01", "���ѵ���",8500,200);
		emp[1] = new FullTime(20, "�ڸ��", "����",10, "2013-06-20", "���ѵ���",7500,100);
		emp[2] = new FullTime(30, "������", "������",10 , "2013-06-22", "���ѵ���",6000,0);
		
		emp[3] = new PartTime(40, "��ȫö", "������",20 , "2014-05-01", "���ѵ���",20000);
		emp[4] = new PartTime(50, "����", "����",30 , "2014-05-02", "���ѵ���",25000);
		
		for(Employee e: emp) {
			System.out.println(e);//e.toString()
		}
		
		System.out.println("\n****Message ********************");
		
		for(Employee e : emp) {
			e.message();
		}
		
	}

}






