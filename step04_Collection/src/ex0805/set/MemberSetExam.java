package ex0805.set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {
	private Set<Member> set = new HashSet<Member>(); //�ߺ��� �ȵ�!!
	
	public MemberSetExam() {
		/*�߰�(Set�� hashcode()�� ȣ���ؼ� �ٸ��� �ٸ���ü, 
		������ equals�� ȣ���ؼ� �����ϴ� ���� true�̸� �ߺ�, 
		false�̸� �ٸ���ü�� �ν��ؼ� �����Ѵ�.*/
		
		set.add( new Member("����", 13, "����") );
		System.out.println("\n1.=============");
		set.add( new Member("����2", 20, "����") );
		System.out.println("\n2.=============");
		
		set.add( new Member("����2", 20, "�뱸") );
		System.out.println("\n3.=============");
		set.add( new Member("����", 12, "����") );
		System.out.println("\n=============");
		
		
		System.out.println("����� ��ü�� �� : " + set.size());
	}

	public static void main(String[] args) {
		new MemberSetExam();

	}

}
