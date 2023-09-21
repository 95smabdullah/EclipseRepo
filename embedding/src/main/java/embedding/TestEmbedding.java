package embedding;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class TestEmbedding {
	public static void main(String[] args) {
		Address a = new Address("Eustic","Cambridge", "MA");
		EmployeeRecords e = new EmployeeRecords();
		e.setName("Mark");
		e.setSalary(80000);
		e.setAddress(a);
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		try(Session session = sessionFactory.openSession()){
			Transaction txn = session.getTransaction();
			txn.begin();
			session.persist(e);
			txn.commit();
			}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		}
	}

