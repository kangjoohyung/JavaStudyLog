package kosta.vo;
/**
 * ����� ����(�Ӽ�) �����ϴ� ��ü
 *
 */

public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int sal;
	private String hiredate;
	
	public Emp() {}

	public Emp(int empno, String ename, String job, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
	}
	public Emp(int empno, String ename, String job, int sal, String hiredate) {
		this(empno,ename,job,sal);
		this.hiredate = hiredate;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emp [empno=");
		builder.append(empno);
		builder.append(", ename=");
		builder.append(ename);
		builder.append(", job=");
		builder.append(job);
		builder.append(", sal=");
		builder.append(sal);
		builder.append(", hiredate=");
		builder.append(hiredate);
		builder.append("]");
		return builder.toString();
	}
	
}
