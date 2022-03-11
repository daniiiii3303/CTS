package ro.ase.acs.contracts;

import java.sql.Connection;
import java.sql.SQLException;

public interface YesSqlable {
    void createTable(Connection connection) throws SQLException;
}
