package ro.ase.acs.contracts.sqlable;

import java.sql.Connection;
import java.sql.SQLException;

public interface YesSqlReadable {
    Connection read(Connection connection) throws SQLException;
}
