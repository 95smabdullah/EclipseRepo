package empCRUD;
import sample.HibernateUtil;
import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import empCRUD.Utilities;
import empCRUD.EmployeeDAOImpl;


public class TestEmployeeCRUD {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		EmployeeDAO ed = new EmployeeDAOImpl();
		int choice = 0;
		try(Session session = sessionFactory.openSession()){
			do {
				choice = Integer.parseInt(Utilities.getInput("1 - Add Emloyee.\n2 - Find Employe.\n3 - Read All Employee.\n4 - Update Employee.\n5 - Delete Employee.\n6 - Stop.\n\n Enter your choice."));
				switch(choice) {
				case 1:
					ed.addEmployee(session);
					break;
				case 2:
					ed.findEmployee(session);
					break;
				case 3:
					ed.readEmployees(session);
					break;
				case 4:
					ed.updateEmployee(session);
					break;
				case 5:
					ed.removeEmployee(session);
					break;
					
				}
			}while(choice != 6);
			
			
		}
		
	}
}
