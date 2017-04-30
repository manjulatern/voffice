package com.ncit.api;

import java.util.List;

import com.ncit.entity.Role;

public interface RoleService {

	//Retrieve
	public List<Role> getRoles();
	
	//Create
	public boolean addRole(Role role);
	
	//Update
	public boolean updateRole(Role role);
	
	//Delete
	public boolean deleteRole(int id);
	
	//Get Role By ID
	public Role getRoleById(int id);
	
}
