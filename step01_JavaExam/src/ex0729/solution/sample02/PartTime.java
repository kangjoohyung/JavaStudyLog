package ex0729.solution.sample02;

public class PartTime extends Employee {
  private int timePay;
  
  public PartTime() {}
  public PartTime(int empNo, String empName, String job, int mgr, String hiredate, String deptName , int timePay) {
	super(empNo, empName, job, mgr, hiredate, deptName);
	this.timePay=timePay;
	
 }
	public int getTimePay() {
		return timePay;
	}
	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}
	
	@Override
	public void message() {
		System.out.println( getEmpName()+"사원은 비정규직입니다. ");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( super.toString() );
		
		builder.append("timePay=");
		builder.append(timePay);
		builder.append("]");
		return builder.toString();
	}
  
  
  
  
}
