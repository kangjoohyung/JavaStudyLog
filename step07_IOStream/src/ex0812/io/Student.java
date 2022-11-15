package ex0812.io;

import java.io.Serializable;

/**
 *  객체를 파일에 저장위해서는 직렬화 필수 
 *   : 필드만 직렬화대상이된다.(생성자, 메소드제외)
 *   : static필드, transient 제한자가 있으면 직렬화대상에서 제외!
 * */
public class Student implements Serializable{
    private String name;
    private int age;
    private transient String addr;
    
    public Student() {}
	public Student(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return name +" | " + age +" | " + addr ;
	}
    
}
