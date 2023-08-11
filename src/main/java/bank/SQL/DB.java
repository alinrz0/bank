package bank.SQL;

import bank.User.Gender;

import java.sql.*;

public class DB {
    private String url = "jdbc:mysql://localhost:3306/sql_bank_managment";
    private String username = "root";
    private String password = "20040502";

    private Statement statement;
    private Connection connection;

    public DB() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM client");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("firstname"));
//            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkClientInformation(String username, String password) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT username,password FROM client WHERE username = " + "'"+username+"'");
            while (resultSet.next()) {
                if (resultSet.getString("password").equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void insertClient(String password, String firstname , String lastname, String phone, String email, String username, Date birthday, String gender, String national_id_number){
        String procedureName = "insert_client";
        String callStatement = "{ call " + procedureName + "(?, ?, ?, ?, ?, ?, ?, ?, ?) }";

        try (CallableStatement callableStatement = connection.prepareCall(callStatement)) {
            // Set input parameters for the procedure
            callableStatement.setString(1, password);
            callableStatement.setString(2, firstname);
            callableStatement.setString(3, lastname);
            callableStatement.setString(4, phone);
            callableStatement.setString(5, email);
            callableStatement.setString(6, username);
            callableStatement.setDate(7,  birthday);
            callableStatement.setString(8, String.valueOf(gender.charAt(0)));
            callableStatement.setString(9, national_id_number);
            System.out.println("Executing SQL: " + callableStatement.toString());
            // Execute the procedure
            callableStatement.execute();

            // Retrieve output parameters or result sets if needed
            // Example: int outputValue = callableStatement.getInt(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
