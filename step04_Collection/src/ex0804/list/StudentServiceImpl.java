package ex0804.list;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
	
	private ArrayList<Student> list = new ArrayList<Student>();
	
	/**
	 * �ʱ�ġ ������ 5���� ������ ����
	 * */
	public StudentServiceImpl() {
		list.add(new Student("A01", "����", 20, "����"));
		list.add(new Student("A02", "����", 25, "�뱸"));
		list.add(new Student("A03", "ȿ��", 22, "�λ�"));
		list.add(new Student("A04", "�ξ�", 21, "���"));
		list.add(new Student("A05", "����", 20, "����"));
	}

	@Override
	public boolean insert(Student st) {
		//���޵� �й��� �ߺ����� ���� üũ�Ѵ�.
		Student savedSt = this.selectBySno(st.getSno());

		if(savedSt!=null) return false;
		
		return list.add(st);
	}

	@Override
	public List<Student> selectAll() {
		return list;
	}

	@Override
	public Student selectBySno(String sno) {
		for(Student student : list) {
			if(student.getSno().equals(sno)) {
				return student;
			}
		}
		
		return null;
	}

	@Override
	public boolean delete(String sno) {
		Student savedSt = this.selectBySno(sno);
		
		return list.remove(savedSt);
	}

	@Override
	public boolean update(Student student) {
		 Student savedSt = this.selectBySno( student.getSno());
		 
		if(savedSt==null)return false;
		
		//ã�Ҵ�
		savedSt.setAge( student.getAge() );
		savedSt.setAddr( student.getAddr() );
		
		return true;
	}

}
