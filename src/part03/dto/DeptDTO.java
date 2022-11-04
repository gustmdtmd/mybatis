package part03.dto;

import java.util.List;

public class DeptDTO {
	private int department_id;
	private String department_name;
	private List<EmpDTO> empList;
//	private LocDTO loc;
	
	public DeptDTO() {
	
	}

//	public LocDTO getLoc() {
//		return loc;
//	}
//	
//	public void setLoc(LocDTO loc) {
//		this.loc = loc;
//	}
	
	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public List<EmpDTO> getEmpList() {
		return empList;
	}

	public void setEmoList(List<EmpDTO> empList) {
		this.empList = empList;
	}

	
}
