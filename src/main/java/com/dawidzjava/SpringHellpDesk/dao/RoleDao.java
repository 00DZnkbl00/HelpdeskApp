package com.dawidzjava.SpringHellpDesk.dao;


import com.dawidzjava.SpringHellpDesk.entity.Role;

public interface RoleDao {

	public void save(Role role);

	public Role findRoleByName(String theRoleName);
	
}
