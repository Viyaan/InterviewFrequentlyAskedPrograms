package interview.collections.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareEmployee {

	public static void main(String args[]) {
		List<Employee> empLst = new ArrayList<>();

		empLst.add(new Employee("viyaan", "jhiingade", "CAA"));
		empLst.add(new Employee("priyanka", "khadke", "CAA"));
		empLst.add(new Employee("madhuri", "dasa", "CTP"));
		empLst.add(new Employee("sanjay", "kumar", "CTP"));
		empLst.add(new Employee("aditya", "konodia", "CTP"));
		empLst.add(new Employee("aditya", "konodia", "ATP"));
		empLst.add(new Employee("venkata", "pradeepa", "CTP"));
		empLst.add(new Employee("unnati", "shenoy", "CTP"));
		empLst.add(new Employee("unnati", "aaaa", "CTP"));

		// Comparator<Employee> employeeNameComparator =
		// Comparator.comparing(Employee::getFirstName);

		/* ****************** Java 7 ************************/

		Collections.sort(empLst, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getFirstName().compareTo(o2.getFirstName()) == 0) {
					if (o1.getLastName().compareTo(o2.getLastName()) == 0) {
						return o1.getDepartment().compareTo(o2.getDepartment());
					} else {
						return o1.getLastName().compareTo(o2.getLastName());
					}
				} else {
					return o1.getFirstName().compareTo(o2.getFirstName());
				}
			}

		});
		
		/* ****************** Streams ************************/

		empLst.stream().sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName)
				.thenComparing(Employee::getDepartment));
		empLst.forEach(x -> System.out.println(x));
		
		/* ****************** Java 8 ************************/

		empLst.sort((Employee o1, Employee o2) -> {
			if (o1.getFirstName().compareTo(o2.getFirstName()) == 0) {
				if (o1.getLastName().compareTo(o2.getLastName()) == 0) {
					return o1.getDepartment().compareTo(o2.getDepartment());
				} else {
					return o1.getLastName().compareTo(o2.getLastName());
				}
			} else {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		});

		empLst.forEach(s -> System.out.println(s.toString()));

	}
}

class Employee {

	private String firstName;

	private String lastName;

	private String department;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", department=" + department + "]";
	}
}
