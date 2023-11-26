import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeCRUD {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext c1 = new ClassPathXmlApplicationContext("beans.xml");
        EmployeeDAO ed = c1.getBean(EmployeeDAO.class);

        int choice = 0;
    do {
        choice = Integer.parseInt(Utilities.getInput("1 - Insert Employee\n2 - Fetch All Employees\n3 - Update Salary\n4 - Delete Employee\n5 - Exit"));
        switch (choice) {
            case 1 -> {

                ed.insertEmployee();
                break;
            }
            case 2 -> {
                ed.readEmployees();
                break;
            }
            case 3 -> {
                ed.updateEmployee();
                break;
            }
            case 4 -> {
                ed.deleteEmployee();
                break;
            }
        }
    } while(choice!= 5);
    c1.close();

    }
}
