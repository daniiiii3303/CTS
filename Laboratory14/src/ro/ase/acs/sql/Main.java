package ro.ase.acs.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		final String DATABASE_TYPE = "org.sqlite.JDBC";
		final String CONNECTION_TYPE = "jdbc:sqlite:database.db";
		TableCreator tableCreator = new TableCreator();
		DataInserter dataInserter = new DataInserter();
		DataReader dataReader = new DataReader();

		try {
			Class.forName(DATABASE_TYPE);
			Connection connection = DriverManager.getConnection(CONNECTION_TYPE);
			connection.setAutoCommit(false);

			tableCreator.sqlMethod(connection);
			dataInserter.sqlMethod(connection);
			dataReader.read(connection);
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
