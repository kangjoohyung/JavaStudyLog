package shop;

public class ShoppingMall {
	public void enter(int age)throws NoKidsException {
		if(age < 18) {
			throw new NoKidsException(age+"���� �ֵ��� �ȵſ�~~");
		}
		System.out.println(age+"��� �����ϽŰ� ȯ���մϴ�.^^");
		
	}
}
