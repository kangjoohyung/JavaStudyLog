package ex0801.abstract_final.exam;

public class Pig extends Animal {

	@Override
	public void eat() {
		System.out.println("¸ðµç °É ¸Ô´Â´Ù.");

	}

	@Override
	public void sound() {
	  System.out.println("²Ü²Ü~~");

	}
	
    @Override
    public void run() {
    	System.out.println("Àß ¸ø ¶Ú´Ù!!!");
    }

}
