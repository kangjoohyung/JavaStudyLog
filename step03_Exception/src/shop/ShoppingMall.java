package shop;

public class ShoppingMall {
	public void enter(int age)throws NoKidsException {
		if(age < 18) {
			throw new NoKidsException(age+"살의 애들은 안돼요~~");
		}
		System.out.println(age+"살님 입장하신걸 환영합니다.^^");
		
	}
}
