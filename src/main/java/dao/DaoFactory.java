package dao;

import java.sql.Connection;

public  abstract class DaoFactory {
	private Connection conn;
	public DaoFactory() {
		
	}
 public abstract ProductDAO getProductDAO();
 public abstract Connection openConnection();
 public abstract void closeConnection(Connection conn);
}
