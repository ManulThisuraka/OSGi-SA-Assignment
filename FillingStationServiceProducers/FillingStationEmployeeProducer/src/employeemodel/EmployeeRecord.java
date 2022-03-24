package employeemodel;

public class EmployeeRecord {
	int empId;
	String name;
	int hours;
	int othours;
	int salary;
	public EmployeeRecord(int empId, String name, int hours, int othours, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.hours = hours;
		this.othours = othours;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getOthours() {
		return othours;
	}
	public void setOthours(int othours) {
		this.othours = othours;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
