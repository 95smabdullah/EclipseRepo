package sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sample.HibernateUtil;
import Entity.Employee;
public class TestEmployee {
    public static void main(String[] args) {
        // Create a Hibernate SessionFactory
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    	SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

        // Open a session
        try (Session session = sessionFactory.openSession()) {
            Employee employee1 = session.get(Employee.class, 4);
            
            System.out.println(employee1.toString());
//            employee1.setName("John");
//            employee1.setSalary(50000);
//            Employee employee2 = new Employee();
//            employee2.setName("Alice");
//            employee2.setSalary(60000);         
//            employee1.setSalary(11233);
            	
            
            
            
            

            // Begin a transaction
            session.beginTransaction();

//            session.persist(employee1);
//            session.persist(employee2);
//            session.remove(employee1);
//            session.merge(employee1);
            
            
            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close(); // Close the SessionFactory when done
        }
    }
}

