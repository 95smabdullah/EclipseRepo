package empCRUD;

import java.util.List;

import org.hibernate.Session;

import Entity.Employee;

public interface EmployeeDAO {
	public void addEmployee(Session session);
	public Employee findEmployee(Session session);
	public List<Employee> readEmployees(Session session);
	public void updateEmployee(Session session);
	public void removeEmployee(Session session);
	

}
