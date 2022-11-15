package ex0801.abstract_final.exam;

public abstract class Animal {
    /**
     * 모든 동물이 갖을수 있는 공통의 기능 정의
     * */
	public abstract void eat() ;
	
	public void run() {
		System.out.println("잘 뛴다!!");
	}
	
	public abstract void sound() ;
}
