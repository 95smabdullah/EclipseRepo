package embedding;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestRelatedObjects {
	public static void main(String[] args) {
		
		EmployeeRecords e = new EmployeeRecords();
		e.setName("Mark");
		e.setSalary(800033);
		Address a = new Address("Eustic", "Cambridge", "MA");
		e.setAddress(a);
		Department d1 = new Department("Finance");
		e.setDepartment(d1);
//		
		EmployeeRecords e2 = new EmployeeRecords();
		e2.setName("Mark2");
		e2.setSalary(800204);
		e2.setAddress(a);
		e2.setDepartment(d1);
		e.getPhone_number().add(959123456);
		e.getPhone_number().add(959763489);
		e2.getPhone_number().add(77876675);
		e2.getPhone_number().add(71638484);
		
		
		
		Passport p1 = new Passport("Z124GH23");
		Passport p2 = new Passport("SDF323TY");
		p1.setEmployeeRecords(e);
		p2.setEmployeeRecords(e2);
		e.setPassport(p1);
		e2.setPassport(p2);
		
		
		ArrayList<EmployeeRecords> el = new ArrayList<>();
		el.add(e);
		el.add(e2);
		d1.setEmployeeRecords(el);
		
		
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		try(Session session = sessionFactory.openSession()){
//			EmployeeRecords e = session.get(EmployeeRecords.class, 1);
//			EmployeeRecords e2 = session.get(EmployeeRecords.class, 2);
//			e.getPhone_number().add(959123456);
//			e.getPhone_number().add(959763489);
//			e2.getPhone_number().add(77876675);
//			e2.getPhone_number().add(71638484);
			
//			ArrayList<EmployeeRecords> el = new ArrayList<>();
//			el.add(e);
//			el.add(e2);
			
//			Department d1 = session.get(Department.class, 1);
//			e.setDepartment(d1);
//			e2.setDepartment(d1);
//			d1.setEmployeeRecords(el);
			Transaction txn = session.getTransaction();
			txn.begin();
			session.persist(e);
			session.persist(e2);
			txn.commit();
//			Transaction txn = session.getTransaction();
//			txn.begin();
//			session.remove(e);
//			txn.commit();
			}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}
	}

