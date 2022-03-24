package fillingstationemployeeproducer;

import java.util.List;

import employeemodel.EmployeeRecord;

public interface FillingStationEmployeeService {

	public int EmployeeService(); // CLI Service

	public int addEmployeeRecord(int id, String name, int hours, int othours); // Add new employee records

	public int viewDailyReport(); // View employee work details

	public int calculateSalary(int hours, int othours); // Calculate employee Salary

	public List<EmployeeRecord> allEmployees(); // Return the list of records

}
