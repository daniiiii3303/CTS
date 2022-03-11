package ro.ase.acs.contracts.sqlable;

import java.sql.Connection;
import java.sql.SQLException;

public interface YesSqlMethods<T> {
    T sqlMethod(Connection connection) throws SQLException;
}
