package ex0801.abstract_final.exam;

public class MainApp {
   public static void main(String[] args) {
	  Animal animal=null;  //�ʵ带 �̿��� ������
	   
	  animal = new Cat();
	  test(animal);
	  
	  animal = new Dog();
	  test(animal);
	  
	  animal = new Pig();
	  test(animal);
   }
   
   public static void test(Animal an) { //�Ű������� �̿��� ������
	   an.eat();
	   an.sound();
	   an.run();
	   
	   System.out.println("---------------");
	   
   }
}
