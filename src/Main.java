
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/diy";
    private static final String user = "root";
    private static final String password = "Bobbyy72@";


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
          //Read Operation
        /*try {
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
        } */
        /*
            // Create operation
        try{
            Connection connection=DriverManager.getConnection(url,user,password);
            Statement statement=connection.createStatement();
            String query=String.format("insert into Trains(name, day_of_arrival, time_of_arrival)"+ "values('%s','%s','%s')",  "Porbandar Express", "Thursday", "5:00");
            int rows_affected=statement.executeUpdate(query);
            if (rows_affected>0){
                System.out.println(rows_affected);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }*/

        /*
         // Update operation
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement=connection.createStatement();
            String query = "Update Trains set id='4' where day_of_arrival='Thursday'" ;
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected>0){
                System.out.println(rowsAffected);
            }
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }*/

        /*try{
            Connection connection=DriverManager.getConnection(url,user,password);
            Statement statement=connection.createStatement();
            String query="delete from Trains where name='Hogwarts Express'";
            int rowsAffected=statement.executeUpdate(query);
            if (rowsAffected>0){
                System.out.println(rowsAffected);
            }
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }*/

        // CRUD operations using Prepared Statements

        try{
            Connection connection=DriverManager.getConnection(url,user,password);
            String query="select * from Trains where name=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, "Shatabdi Express");
            ResultSet resultSet=preparedStatement.executeQuery();

            if(resultSet.next()){
                String day=resultSet.getString("day_of_arrival");
                System.out.println(day);
            }

        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}