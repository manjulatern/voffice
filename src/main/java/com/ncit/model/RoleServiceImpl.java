package com.ncit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ncit.api.RoleService;
import com.ncit.dbconnection.DatabaseConnection;
import com.ncit.dbconnection.DatabaseConnectionImpl;
import com.ncit.entity.Role;

public class RoleServiceImpl implements RoleService {

	DatabaseConnection dbConnection = new DatabaseConnectionImpl();
	Statement statement = dbConnection.doConnection();

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		List<Role> roleList = new ArrayList<Role>();

		String query = "SELECT * FROM roles";

		try {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Role role = new Role();

				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
				roleList.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return roleList;
	}

	@Override
	public boolean addRole(Role role) {
		String query = "Insert into roles(name,description)" + " values('"
				+ role.getName() + "','" + role.getDescription() + "');";

		try {
			statement.execute(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateRole(Role role) {
		String query = "Update roles set name = '" + role.getName()
				+ "',description = '" + role.getDescription() + "'"
				+ "where id = " + role.getId() + "";

		try {
			statement.execute(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteRole(int id) {
		String query = "DELETE from roles where id = " + id + "";

		try {
			statement.execute(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Role getRoleById(int id) {

		String query = "SELECT * from roles where id = " + id + "";

		Role role = new Role();

		try {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {

				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}

}
