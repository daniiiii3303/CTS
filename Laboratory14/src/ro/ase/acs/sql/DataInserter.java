package ro.ase.acs.sql;

import ro.ase.acs.contracts.sqlable.YesSqlMethods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataInserter implements YesSqlMethods<Connection> {
    public final String SQL_INSERT = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
    public final String SQL_INSERT_WITH_PARAMS = "INSERT INTO employees VALUES (?,?,?,?)";
    public final String NAME = "Ionescu Vasile";
    public final String CITY = "Brasov";
    public final float SALARY = 4500;

    @Override
    public Connection sqlMethod(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL_INSERT);
        statement.close();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_WITH_PARAMS);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, NAME);
            preparedStatement.setString(3, CITY);
            preparedStatement.setDouble(4, SALARY);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
