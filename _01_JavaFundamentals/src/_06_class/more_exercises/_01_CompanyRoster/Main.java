package _06_class.more_exercises._01_CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		Employee employee = null;
		Department theDepartment = new Department();

		for (int i = 0; i < n; i++) {
			String[] tokens = scanner	.nextLine()
										.split("\\s+");

			String name = "";
			double salary = 0;
			String position = "";
			String department = "";
			String email = "";
			int age = 0;

			int tokensLength = tokens.length;

			switch (tokensLength) {
			case 4:
				name = tokens[0];
				salary = Double.parseDouble(tokens[1]);
				position = tokens[2];
				department = tokens[3];

				employee = new Employee(name, salary, position, department);
				break;
			case 5:
				name = tokens[0];
				salary = Double.parseDouble(tokens[1]);
				position = tokens[2];
				department = tokens[3];

				if (tokens[4].length() == 2) {
					age = Integer.parseInt(tokens[4]);
					employee = new Employee(name, salary, position, department, age);
				} else {
					email = tokens[4];
					employee = new Employee(name, salary, position, department, email);
				}
				break;
			case 6:
				name = tokens[0];
				salary = Double.parseDouble(tokens[1]);
				position = tokens[2];
				department = tokens[3];
				email = tokens[4];
				age = Integer.parseInt(tokens[5]);

				employee = new Employee(name, salary, position, department, email, age);
				break;
			}

			theDepartment.addDepartment(department);
			theDepartment.addEmployee(employee, employee.getDepartment());
		}

		scanner.close();

		Map<String, Double> averageSalaries = Department.getAverageSalaries(theDepartment.getDepartments());

		Comparator<Double> cmpAverageSalary = new Comparator<Double>() {

			@Override
			public int compare(Double o1, Double o2) {
				return o2.compareTo(o1);
			}
		};

		List<Map.Entry<String, Double>> entries = new ArrayList<>(averageSalaries.entrySet());
		entries.sort(Map.Entry.comparingByValue(cmpAverageSalary));

		Map<String, Double> sortedMap = new LinkedHashMap<>();

		for (Map.Entry<String, Double> entry : entries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		Iterator<Map.Entry<String, Double>> itr = sortedMap	.entrySet()
															.iterator();

		Map.Entry<String, Double> highestAverageSalaryDepartment = itr.next();
		theDepartment.printDepartment(highestAverageSalaryDepartment);
	}
}
