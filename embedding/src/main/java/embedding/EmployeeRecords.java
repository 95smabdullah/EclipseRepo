package embedding;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.*;

@Entity
public class EmployeeRecords {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		int id;
		
		@Column(name = "name")
		String name;
		
		@Column(name = "salary")
		float salary;
		
		@ElementCollection
		@CollectionTable(name = "phone_numbers")
		@Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
		@Column(name = "phone_number")
		List<Integer> phone_number;
		
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "department_id" )
		Department department;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "passport_no", unique = true)
		Passport passport;
		
		@Embedded
		Address address;
		
		public EmployeeRecords() {
			this.phone_number = new ArrayList<Integer>();
		}
		
		public EmployeeRecords(String name, float salary, Address address) {
			this.name = name;
			this.salary = salary;
			this.address = address;
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
		public float getSalary() {
			return salary;
		}
		public void setSalary(float d) {
			this.salary = d;
		}
		
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		
		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}
		

		public Passport getPassport() {
			return passport;
		}

		public void setPassport(Passport passport) {
			this.passport = passport;
		}
		
		

		public List<Integer> getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(List<Integer> phone_number) {
			this.phone_number = phone_number;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
		}	
}
