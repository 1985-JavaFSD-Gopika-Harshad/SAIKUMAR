package com.example.programs;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
	
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
 public class EmployeeSorting{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees=new ArrayList<>();
		employees.add(new Employee(1,"Raju",9999999));
		employees.add(new Employee(2,"Rani",6786786));
		employees.add(new Employee(3,"Raja",7897897));
		
		Collections.sort(employees,new Comparator<Employee>() {
			public int compare(Employee e1,Employee e2) {
				return Double.compare(e2.getSalary(), e1.getSalary());
			}
		});
		for(Employee emp:employees) {
			System.out.println(emp);
		}

	}
}
