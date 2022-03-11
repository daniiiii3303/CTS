package ro.ase.acs.sql;

import ro.ase.acs.contracts.sqlable.YesSqlMethods;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator implements YesSqlMethods<Connection> {
    public final String SQL_DROP = "DROP TABLE IF EXISTS employees";
    public final String SQL_CREATE = "CREATE TABLE employees(id INTEGER PRIMARY KEY,"
            + "name TEXT, address TEXT, salary REAL)";

    @Override
    public Connection sqlMethod(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL_DROP);
        statement.executeUpdate(SQL_CREATE);
        statement.close();
        connection.commit();

        return connection;
    }
}
