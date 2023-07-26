package co.yedam.hr;

import java.util.List;

public class JdbcExe {

	public static void main(String[] args) {
		EmpVo emp = new EmpVo();

		EmpDAO dao = new EmpDAO();

		emp = new EmpVo(1001, "son", "son@email.com", "런던", 1000);
		dao.editEmp(emp);
		System.out.println("end of prog.");
	}

}
