package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.Employee;
import mx.utng.practice.repository.EmployeeRepository;

@Named
@ViewScoped
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	private Employee employee=new Employee();
	private List<Employee>  employees;
	private boolean editMode = false;
	
	@PostConstruct
	public void init(){
		setEmployees(employeeRepository.findAll());
	}
	
	public void save(){
		employeeRepository.save(employee);
		if(!editMode){
			getEmployees().add(employee);
		}
		employee=new Employee();
		setEditMode(false);
	}
	
	public void delete(Employee employee){
		employeeRepository.delete(employee);
		employees.remove(employee);
	}
	public void update(Employee employee){
		setEmployee(employee);
		setEditMode(true);
	}
	public void cancel(){
		employee = new Employee();
		setEditMode(false);
	}
	

	
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	

}//
