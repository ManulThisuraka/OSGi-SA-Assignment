package fillingstationemployeeproducer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import employeelist.EmployeeReport;
import employeemodel.EmployeeRecord;

public class FillingStationEmployeeServiceImpl implements FillingStationEmployeeService {

	Scanner scaninput = new Scanner(System.in);
	int selection;

	// addEmployeeRecord Implementation
	public synchronized int addEmployeeRecord(int id, String name, int hours, int othours) {
		int salary;
		salary = (hours * 150) + (othours * 250);
		EmployeeRecord newRecord = new EmployeeRecord(id, name, hours, othours, salary);
		EmployeeReport.dailyReport.add(newRecord);
		return 1;
	}

	// viewDailyReport Implementation
	@Override
	public int viewDailyReport() {
		List<EmployeeRecord> finalreport = EmployeeReport.dailyReport;

		if (finalreport.size() == 0) {
			System.out.println("");
			System.out.println("No Records Found!");
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("Employee ID:" + "\t" + "Employee Name" + "\t" + "Hours Worked" + "\t" + "OT Hours"
					+ "\t" + "Salary" + "\t");

			for (EmployeeRecord record : finalreport) {
				System.out.println(record.getEmpId() + "\t	" + record.getName() + "\t	" + record.getHours() + "\t	"
						+ record.getOthours() + "\t	" + record.getSalary() + "\t");
			}

		}
		System.out.println("");
		return 1;
	}

	// calculateSalary Implementation
	@Override
	public int calculateSalary(int hours, int othours) {
		int salary;
		salary = (hours * 150) + (othours * 250);
		return salary;
	}

	// EmployeeService Implementation
	@Override
	public int EmployeeService() {

		System.out.println(" ___________________________________________________________");
		System.out.println("|                                                           |");
		System.out.println("|***************      C E Y P E T C O      *****************|");
		System.out.println("|**********     Ceylon Petroleum Corporation     ***********|");
		System.out.println("|___________________________________________________________|");
		do {
			selection = 0;
			System.out.println("");
			System.out.println("**********  Welcome to Employee Work Management  **********");
			System.out.println("");
			System.out.println("Please choose your option from below list or enter 99 to exit.");
			System.out.println("");
			System.out.println("Add new employee record ==> 1");
			System.out.println("View Daily Report       ==> 2");
			System.out.println("");
			System.out.println("Exit                    ==> 99");
			System.out.println("");
			System.out.println("");
			System.out.print("Enter your option: ");

			try {
				selection = scaninput.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("");
				System.out.print("Invalid Input !!!!!!!!");
				System.out.println("");
				System.out.print("We will redirect you to dashboard");
				System.out.println("");
				scaninput.nextLine();
				continue;
			}

			if (selection == 1) { // Add new employee section

				System.out.println("************* Add New Employee Record************");
				System.out.println("");

				System.out.print("Enter Employee ID: ");
				int empID = scaninput.nextInt();
				System.out.print("Enter Employee Name: ");
				scaninput.nextLine();
				String empName = scaninput.nextLine();
				System.out.print("How many hours the employee worked?: ");
				int empHours = scaninput.nextInt();
				System.out.print("How many OT hours the employee worked?: ");
				int empOtHours = scaninput.nextInt();

				int empSalary = calculateSalary(empHours, empOtHours);

				System.out.println("");
				System.out.print("Salary for the day ==> Rs." + empSalary + "/=");
				System.out.println("");
				System.out.println("");

				int result = addEmployeeRecord(empID, empName, empHours, empOtHours);

				if (result == 1) {
					System.out.println("Employee Added Successfully! You will be redirect to Dashboard automatically!");
					System.out.println("");
				} else {
					System.out.println("Something went wrong! You will be redirect to Dashboard automatically!");
					System.out.println("");
				}
			} else if (selection == 2) {
				int result = viewDailyReport();
				if (result != 1)
					System.out.println("Something Went Wrong. You will be redirect to home automatically!");
			}

		} while (selection != 99);
		{
		}
		return 0;
	}

	// allEmployees Implementation
	public List<EmployeeRecord> allEmployees() {
		// TODO Auto-generated method stub
		return EmployeeReport.dailyReport;
	}

}
