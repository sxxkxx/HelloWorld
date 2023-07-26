package co.yedam.hr;

public class EmpVo {
	// emp_temp
	private int empId;
	private String empName;
	private String email;
	private String address;
	private int salary;

	public EmpVo() {

	}

	public EmpVo(int empId, String empName, String email, String address, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.address = address;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {

		return "id: " + empId + ", 이름: " + empName + ", mail: " + email + ", 주소: " + address + ", 월급: " + salary;
	}
}
