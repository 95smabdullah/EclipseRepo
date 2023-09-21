package embedding;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	
	@Column(name = "passport_no")
	String passport_no;
	
	@OneToOne(mappedBy = "passport" , cascade = CascadeType.ALL)
	EmployeeRecords employeeRecords;

	public Passport(String passport_no) {
		this.passport_no = passport_no;
	}
	
	public Passport() {
		
	}

	public String getPassport_no() {
		return passport_no;
	}

	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}

	public EmployeeRecords getEmployeeRecords() {
		return employeeRecords;
	}

	public void setEmployeeRecords(EmployeeRecords employeeRecords) {
		this.employeeRecords = employeeRecords;
	}
	
	
	
	

}
