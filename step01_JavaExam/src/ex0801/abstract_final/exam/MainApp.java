package ex0801.abstract_final.exam;

public class MainApp {
   public static void main(String[] args) {
	  Animal animal=null;  //필드를 이용한 다형성
	   
	  animal = new Cat();
	  test(animal);
	  
	  animal = new Dog();
	  test(animal);
	  
	  animal = new Pig();
	  test(animal);
   }
   
   public static void test(Animal an) { //매개변수를 이용한 다형성
	   an.eat();
	   an.sound();
	   an.run();
	   
	   System.out.println("---------------");
	   
   }
}
