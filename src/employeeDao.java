import java.sql.*;

public class employeeDao {
    private String driver="com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://lab.cntoworld.pw:3306/ertdatabase?useSSL=false&serverTimezone=GMT";
    private String user="test";
    private String passwd="root";
    private Connection conn=null;
    private PreparedStatement pstat=null;

    employeeDao(employee employeeRegister){
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url, user, passwd);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("驱动加载异常");
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        addEmpolyee(employeeRegister);
    }
    employeeDao(){
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url, user, passwd);

        }
        catch(ClassNotFoundException e)
        {
            System.out.println("驱动加载异常");
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean employeePasswordVerification(String id,String md5){
        String sql = "select password_hash from ert_employees where id = ?";
        try{
            pstat=conn.prepareStatement(sql);
            pstat.setString(1, id);
            ResultSet rs = pstat.executeQuery();
            if(rs == null) return false;
            rs.next();
            String md5_server = rs.getString("password_hash");
            return md5_server.equals(md5);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean addEmpolyee(employee employeeRegister) {
        String first_name = employeeRegister.getFirst_name();
        String last_name = employeeRegister.getLast_name();
        String birthday = employeeRegister.getBirthday();
        String email = employeeRegister.getEmail();
        String phone_number = employeeRegister.getPhone_number();
        String password_hash = employeeRegister.getPassword_hash();
        try {
            String sql="insert into ert_employees (first_name,last_name,birthday,email,phone_number,password_hash) values (?,?,?,?,?,?)";
            pstat=conn.prepareStatement(sql);
            pstat.setString(1, first_name);
            pstat.setString(2, last_name);
            pstat.setString(3, birthday);
            pstat.setString(4, email);
            pstat.setString(5, phone_number);
            pstat.setString(6, password_hash);
            pstat.executeUpdate();
            pstat.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}