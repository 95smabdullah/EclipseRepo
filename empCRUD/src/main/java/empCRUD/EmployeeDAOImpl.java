package empCRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Session session) {
		// TODO Auto-generated method stub
		String name = Utilities.getInput("Enter Name");
		float salary = Float.parseFloat(Utilities.getInput("Enter salary"));
		Employee e = new Employee();
		e.setName(name);
		e.setSalary(salary);
		Transaction txn = null;
		try{
		txn = session.beginTransaction();
		session.persist(e);
		txn.commit();
		}catch (Exception er) {
		    if (txn != null) {
		        txn.rollback();
		    }
		    er.printStackTrace(); // Handle or log the exception
		}
	}

	@Override
	public Employee findEmployee(Session session) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(Utilities.getInput("Enter ID"));
		Employee e = session.get(Employee.class, id);
		System.out.println(e.toString());
		
		return null;
	}

	@Override
	public List<Employee> readEmployees(Session session) {
		// TODO Auto-generated method stub
		String hql = "FROM Employee";
		Query<Employee> query = session.createQuery(hql,Employee.class);
		List<Employee> employees = query.getResultList();
		for(Employee e:employees)System.out.println(e.toString());
		
		
		return null;
	}

	@Override
	public void updateEmployee(Session session) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(Utilities.getInput("Enter ID"));
		Employee e = session.get(Employee.class, id);
		float salary = Float.parseFloat(Utilities.getInput("Enter new salary"));
		e.setSalary(salary);
		Transaction txn = null;
		try{
			txn = session.beginTransaction();
			session.merge(e);
			txn.commit();
			}catch (Exception er) {
			    if (txn != null) {
			        txn.rollback();
			    }
			    er.printStackTrace(); // Handle or log the exception
			}
		}

	@Override
	public void removeEmployee(Session session) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(Utilities.getInput("Enter ID"));
		Employee e = session.get(Employee.class, id);
		Transaction txn = null;
		try{
			txn = session.beginTransaction();
			session.remove(e);
			txn.commit();
			}catch (Exception er) {
			    if (txn != null) {
			        txn.rollback();
			    }
			    er.printStackTrace(); // Handle or log the exception
			}
		}

}
