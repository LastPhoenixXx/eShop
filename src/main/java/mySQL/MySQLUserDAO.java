package mySQL;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.PasswordHasher;
import dao.UserDAO;
import models.User;

public class MySQLUserDAO implements UserDAO {

	private final static String SELECT_LOGIN_QUERY = "SELECT * FROM users WHERE login=? ";
	private final static String INSERT_QUERY = "INSERT INTO users(login, password, name, region, gender, comment)"
			+ " VALUES(?, ?, ?,?,?,?)";
	private final static String UPDATE_QUERY="UPDATE users SET login=?,password=?,name=?,region=?,gender=?,comment=? WHERE id=?";

	MySQLDAOFactory mySQLDAOFactory = new MySQLDAOFactory();

	@Override
	public boolean checkUserByLogin(String login) {
		User user = null;
		ResultSet rs = null;
		Connection conn = mySQLDAOFactory.openConnection();

		try {
			PreparedStatement prepSt;
			prepSt = conn.prepareStatement(SELECT_LOGIN_QUERY);
			System.out.println("SELECT_LOGIN_QUERY");
			prepSt.setString(1, login);
			rs = prepSt.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mySQLDAOFactory.closeConnection(conn);

		}

		return false;
	}

	@Override
	public void insertUser(User user) {

		Connection conn = mySQLDAOFactory.openConnection();

		PreparedStatement prepSt;
		try {

			prepSt = conn.prepareStatement(INSERT_QUERY);

			prepSt.setString(1, user.getLogin());
			prepSt.setString(2, user.getPassword());
			prepSt.setString(3, user.getName());
			prepSt.setString(4, user.getRegion());
			prepSt.setInt(5, user.getGender());
			prepSt.setString(6, user.getComment());
			prepSt.executeUpdate();
			prepSt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mySQLDAOFactory.closeConnection(conn);
		}

	}

	@SuppressWarnings("null")
	@Override
	public User getUserByLoginPassword(String login, String password) {

		User user = new User();
		ResultSet rs = null;
		Connection conn = mySQLDAOFactory.openConnection();

		try {
			PreparedStatement prepSt;
			prepSt = conn.prepareStatement(SELECT_LOGIN_QUERY);
			prepSt.setString(1, login);
			rs = prepSt.executeQuery();

			if (rs.next()) {

				user.setId(rs.getInt("id"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRegion(rs.getString("region"));
				user.setGender(rs.getInt("gender"));
				user.setComment(rs.getString("comment"));
				
				if (user.getPassword().equals(new PasswordHasher().hash(password))) {
					return user;

				}
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mySQLDAOFactory.closeConnection(conn);

		}

		return null;
	}

	@Override
	public void updateUser(User user) {
		Connection conn = mySQLDAOFactory.openConnection();
		try
		  {
		    // create our java preparedstatement using a sql update query
		    PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);
System.out.println("Up1");
		    // set the preparedstatement parameters
		    ps.setString(1,user.getLogin());
		    ps.setString(2,user.getPassword());
		    ps.setString(3,user.getName());
		    ps.setString(4,user.getRegion());
		    ps.setInt(5, user.getGender());
		    ps.setString(6,user.getComment());
		    ps.setLong(7, user.getId());
System.out.println("Up2");
		    // call executeUpdate to execute our sql update statement
		    ps.executeUpdate();
		    ps.close();
		  }
		  catch (SQLException se)
		  {
		    // log the exception
		    se.printStackTrace();
		  }
		
		
	}

	
		
	

}
