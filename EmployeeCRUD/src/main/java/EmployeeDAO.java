

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  void insertEmployee(){
        int id = Integer.parseInt(Utilities.getInput("Enter ID"));
        String name = Utilities.getInput("Enter Name");
        float salary = Float.parseFloat(Utilities.getInput("Enter Salary"));
        String query = "INSERT INTO employee (ID,NAME,SALARY) VALUES (?,?,?)";
        jdbcTemplate.update(query, id, name, salary);
    }

    public void readEmployees(){
        String query = "SELECT * FROM employee";
        List<Map<String,Object>> employees = jdbcTemplate.queryForList(query);
//        Set k = employees.get(0).keySet();
//        ArrayList<String> keys = new ArrayList<>(k);


        for(Map emp: employees){
            System.out.println(emp.get("id")+","+emp.get("name")+","+emp.get("salary"));

        }

    }

    public void updateEmployee(){
        int id = Integer.parseInt(Utilities.getInput("Enter ID"));
        String newSalary = Utilities.getInput("Enter new salary");
        String query = "UPDATE employee SET salary = ? WHERE id = ?";
        jdbcTemplate.update(query, newSalary, id);
    }

    public void deleteEmployee(){
        int id = Integer.parseInt(Utilities.getInput("Enter ID"));
        String query = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
