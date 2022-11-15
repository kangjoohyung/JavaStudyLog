package ex0804.list;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
	
	private ArrayList<Student> list = new ArrayList<Student>();
	
	/**
	 * 초기치 데이터 5명의 정보를 저장
	 * */
	public StudentServiceImpl() {
		list.add(new Student("A01", "희정", 20, "서울"));
		list.add(new Student("A02", "나영", 25, "대구"));
		list.add(new Student("A03", "효리", 22, "부산"));
		list.add(new Student("A04", "민아", 21, "경기"));
		list.add(new Student("A05", "선경", 20, "서울"));
	}

	@Override
	public boolean insert(Student st) {
		//전달된 학번이 중복인지 먼저 체크한다.
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
		
		//찾았다
		savedSt.setAge( student.getAge() );
		savedSt.setAddr( student.getAddr() );
		
		return true;
	}

}
