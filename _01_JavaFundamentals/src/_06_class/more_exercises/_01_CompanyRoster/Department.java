package _06_class.more_exercises._01_CompanyRoster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Department {

	private Map<String, List<Employee>> departments;

	public Department() {
		this.departments = new HashMap<>();
	}

	public Map<String, List<Employee>> getDepartments() {
		return departments;
	}

	public void setDepartments(Map<String, List<Employee>> departments) {
		this.departments = departments;
	}

	public void addDepartment(String department) {
		this.departments.putIfAbsent(department, new ArrayList<Employee>());
	}

	public void addEmployee(Employee employee, String department) {
		List<Employee> employees = this.departments.get(department);

		if (employee == null) {
			System.out.println("There is no such department -> " + department);
		} else {
			employees.add(employee);
		}
	}

	public static Map<String, Double> getAverageSalaries(Map<String, List<Employee>> departments) {

		Map<String, Double> averageSalaries = new HashMap<>();

		for (String department : departments.keySet()) {

			double sum = 0;
			int employeesCount = 0;

			List<Employee> employees = departments.get(department);
			employeesCount = employees.size();

			for (Employee employee : employees) {
				sum += employee.getSalary();
			}

			double averageSalary = sum / employeesCount;

			averageSalaries.put(department, averageSalary);
		}

		return averageSalaries;
	}

	public void printDepartment(Map.Entry<String, Double> entry) {
		List<Employee> employees = this.departments.get(entry.getKey());

		Collections.sort(employees, (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));

		System.out.println("Highest Average Salary: " + entry.getKey());
		employees.forEach(e -> System.out.printf(	"%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(),
													e.getAge()));
	}
}
