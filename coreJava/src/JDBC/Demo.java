package JDBC;

import java.sql.*;
import org.apache.log4j.Logger;
public  class Demo {
    public static final Logger logger = Logger.getLogger(Demo.class);
    public static void main(String[] args) throws SQLException {
        String query = "select * from employee where dept_id = 101";
        String url = "jdbc:mysql://localhost:3306/experimental";

        String userName = "myuser";
        String password = "mypassword";

        Connection con = DriverManager.getConnection(url, userName, password);
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(query);


        while (resultSet.next()){
            logger.info("Emp_id = " + resultSet.getString(1) +
                    " Emp_name = "+ resultSet.getString(2) +
                    " Dept_id = " + resultSet.getString(3));
        }
        con.close();


    }
}


















//package JDBC;
//
//import java.sql.*;
//import com.mysql.cj.jdbc.Driver;
//public class Demo{
//    public static void main(String args[]){
//        try{
//            Connection con=DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/experimental", "myuser", "mypassword");
////here sonoo is database name, root is username and password
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from employee where dept_id = 101");
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
//            con.close();
//        }catch(Exception e){ System.out.println(e);}
//    }
//}