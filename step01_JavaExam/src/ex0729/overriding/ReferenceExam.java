package ex0729.overriding;


class ObjectExam{
	String str;
	public ObjectExam(){   }
	public ObjectExam(String str){ 
		this.str=str;
	}
	
	@Override
	public String toString() {
		
		return str +" / " + super.toString();
	}
}

///////////////////////////////////////////
class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			
			String s01= "장희정"; 
			String s02= "Java";
			
			String s03 = new String("월요일");
			
			ObjectExam oe1=new ObjectExam("주말에 공부해야지...");
			
			ObjectExam oe2 = new ObjectExam("안녕");
			
			System.out.println(c);//a
			
			/**
			 * println(Object obj) 또는 print(Object obj) 메소드의 
			 * 인수로 객체가 전달되면 obj.toString() 메소드가 호출되고 그 메소드가
			 * 리턴하는 값을 출력한다.
			 * */
			
			System.out.println(s01);//장희정
			System.out.println(s02);//Java
			
			System.out.println(s03.toString());//월요일 ????
			
			System.out.println(oe1);// ex0729.overriding.ObjectExam@7de26db8 :Object에 정의 되어 있는 toString이 호추룀
			System.out.println(oe2.toString());//주소값
			
	}
}








