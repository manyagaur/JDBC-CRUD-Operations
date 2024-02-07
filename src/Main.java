
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/diy";
    private static final String user = "root";
    private static final String password = "Bobbyy72@";


    public static void main(String[] args) {
        try {
            //Read Operation
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "select * from Trains";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                String name = result.getString("name");
                System.out.println(name);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}