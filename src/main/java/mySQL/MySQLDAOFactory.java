package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.DaoFactory;
import dao.ProductDAO;



public class MySQLDAOFactory extends DaoFactory{

	@Override
	public ProductDAO getProductDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection openConnection() {
		try {
			// The newInstance() call is a work around for some
			// broken Java implementations
			System.out.print("Loading driver... ");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Success");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		Connection conn = null;		
		System.out.print("con ");
		try {
			
			System.out.print("Obtaining connection... ");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/iteashop?" + "user=root&password=");

			System.out.println("OK");

		} catch (SQLException ex) {
			System.out.println("Failed");
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		// TODO Auto-generated method stub
		return conn;
	}

	@Override
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
