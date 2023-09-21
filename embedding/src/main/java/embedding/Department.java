package embedding;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	Long id;
	
	@Column(name = "dept_name")
	String name;
	
	@OneToMany(mappedBy = "department")
	List<EmployeeRecords> employeeRecords;
	
	

	public Department() {
		
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeRecords> getEmployeeRecords() {
		return employeeRecords;
	}

	public void setEmployeeRecords(List<EmployeeRecords> employeeRecords) {
		this.employeeRecords = employeeRecords;
	}
	
	

}
