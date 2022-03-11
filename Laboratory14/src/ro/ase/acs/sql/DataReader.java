package ro.ase.acs.sql;

import ro.ase.acs.contracts.sqlable.YesSqlReadable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataReader implements YesSqlReadable {
    public final String SQL_SELECT = "SELECT * FROM employees";
    @Override
    public Connection read(Connection connection) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()) {
                int id = rs.getInt("id");
                System.out.println("id: " + id);
                String name = rs.getString(2);
                System.out.println("name: " + name);
                String address = rs.getString("address");
                System.out.println("address: " + address);
                double salary = rs.getDouble("salary");
                System.out.println("salary: " + salary);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
