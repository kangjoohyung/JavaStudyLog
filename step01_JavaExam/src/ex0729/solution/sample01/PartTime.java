package ex0729.solution.sample01;

public class PartTime {
	private int empNo;
   private String empName; //
   private String job;
   private int mgr;
   private String hiredate;
   private String deptName;
   
   private int timePay;
   
   public PartTime() {}
   public PartTime(int empNo, String empName, String job, int mgr, String hiredate, String deptName, int timePay) {
	super();
	this.empNo = empNo;
	this.empName = empName;
	this.job = job;
	this.mgr = mgr;
	this.hiredate = hiredate;
	this.deptName = deptName;
	this.timePay = timePay;
  }
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getTimePay() {
		return timePay;
	}
	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}
	
	public void message() {
		System.out.println(empName+"사원은 비정규직입니다.");
	}
	
	@Override
	public String toString() {
	   return empNo +" | " + " | " + empName + " | " + job + " | " 
			      + hiredate + " | " + deptName + " | "+ timePay;
	}
   
   
}
