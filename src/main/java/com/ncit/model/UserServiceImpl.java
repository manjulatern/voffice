package com.ncit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ncit.api.UserService;
import com.ncit.dbconnection.DatabaseConnection;
import com.ncit.dbconnection.DatabaseConnectionImpl;
import com.ncit.entity.Role;
import com.ncit.entity.User;

public class UserServiceImpl implements UserService {

	DatabaseConnection dbConnection = new DatabaseConnectionImpl();
	Statement statement = dbConnection.doConnection();

	@Override
	public boolean isUserValid(User user) {

		String query = "SELECT * from users where username = '"
				+ user.getUsername() + "' and password = '"
				+ user.getPassword() + "'";

		try {
			ResultSet rs = statement.executeQuery(query);

			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<User> getUserList() {

		List<User> userList = new ArrayList<User>();

		String query = "" + "SELECT u.first_name   AS fname, "
				+ "       u.last_name    AS lname, "
				+ "       u.id    AS userId, "
				+ "       u.username     AS username, "
				+ "       u.password     AS password, "
				+ "       u.address      AS address, "
				+ "       u.created_date AS createdDate, "
				+ "       u.email        AS email, "
				+ "       u.mobile       AS mobile, "
				+ "       u.status       AS userStatus, "
				+ "       u.role_id       AS roleId, "
				+ "       r.name         AS rname, "
				+ "       r.description         AS rdescription "
				+ "FROM   users u " + "       JOIN roles r "
				+ "         ON u.role_id = r.id";

		try {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("userId"));
				user.setFirstName(rs.getString("fname"));
				user.setLastName(rs.getString("lname"));
				user.setUsername(rs.getString("username"));
				user.setAddress(rs.getString("address"));
				user.setCreatedDate(rs.getDate("createdDate"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setStatus(rs.getString("userStatus"));
				user.setPassword(rs.getString("password"));
				user.setStatus(rs.getString("userStatus"));
				
				Role role = new Role();
				role.setId(rs.getInt("roleId"));
				role.setName(rs.getString("rname"));
				role.setDescription(rs.getString("rdescription"));
				
				user.setRole(role);

				// add user to List
				userList.add(user);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUserDetail(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
