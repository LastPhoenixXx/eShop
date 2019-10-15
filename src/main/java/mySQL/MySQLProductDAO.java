package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import dao.ProductDAO;
import models.Product;

public class MySQLProductDAO implements ProductDAO{

	public Connection openDatabase() {
		Connection conn =null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			 conn = DriverManager.getConnection("jdbc:mysql://localhost/iteashop?" + "user=root&password=");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("Failed");
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
	//private DaoFactory daoFactory; 
	private final static String SELECTID_QUERY = "SELECT * FROM products WHERE id = ?";
	private final static String SELECTCATEGORY_QUERY = "SELECT * FROM products WHERE category = ?";
	private final static String SELECTLIST_QUERY = "SELECT * FROM products";
	
	@Override
	public List<Product> getProductList() {
		List<Product> productList = new ArrayList<Product>();
		
		Statement selectStmt = null;
		ResultSet rs = null;
		
		
			Connection conn =openDatabase();
			try {
				selectStmt = conn.createStatement();
				rs = selectStmt.executeQuery(SELECTLIST_QUERY);
				while (rs.next()) {
					Product product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getInt("price"));
					product.setCategory(rs.getInt("category"));
					productList.add(product);
				}
				conn.close();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		return productList;
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByCategory(int category) {
List<Product> productList = new ArrayList<Product>();
		
	
		ResultSet rs = null;

		PreparedStatement prepSt = null;
		
			Connection conn =openDatabase();
			try {
				prepSt = conn.prepareStatement(SELECTCATEGORY_QUERY);
				prepSt.setInt(1, category);
				rs = prepSt.executeQuery();
				
				while (rs.next()) {
					Product product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getInt("price"));
					product.setCategory(rs.getInt("category"));
					productList.add(product);
				}
				conn.close();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				if (prepSt != null) {
					try {
						prepSt.close();
					} catch (SQLException sqlEx) {
					}
					prepSt = null;
				}
			}	
		return productList;
	}
}
