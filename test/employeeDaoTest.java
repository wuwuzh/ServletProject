import org.junit.Test;

public class employeeDaoTest {

    @Test
    public void addStudent() {
        employee employee = new employee();
        employee.setFirst_name("敏");
        employee.setLast_name("张");
        employee.setBirthday("1900-1-1");
        employee.setEmail("z11@z.com");
        employee.setPhone_number("13000000002");
        employee.setPassword("0123456789");
        employeeDao ea = new employeeDao(employee);
    }
}