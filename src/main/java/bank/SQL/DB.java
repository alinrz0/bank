package bank.SQL;

import java.sql.*;

public class DB {
    private String url = "jdbc:mysql://localhost:3306/sql_bank_managment";
    private String username = "root";
    private String password = "20040502";

    private Statement statement;

    public DB() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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
}
