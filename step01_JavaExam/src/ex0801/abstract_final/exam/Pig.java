package ex0801.abstract_final.exam;

public class Pig extends Animal {

	@Override
	public void eat() {
		System.out.println("��� �� �Դ´�.");

	}

	@Override
	public void sound() {
	  System.out.println("�ܲ�~~");

	}
	
    @Override
    public void run() {
    	System.out.println("�� �� �ڴ�!!!");
    }

}
