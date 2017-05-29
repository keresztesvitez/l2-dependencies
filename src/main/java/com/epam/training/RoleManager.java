package com.epam.training;

import java.util.Set;

public class RoleManager {

	public Set<Role> getElevatedRoles() {
		return Role.getElevatedRoles();
	}
	
	public Set<Role> getRolesAboveAccessLevel(int accessLevel) {
		return Role.getRolesAboveAccessLevel(accessLevel);
	}
	
	public Set<Role> getRolesBelowAccessLevel(int accessLevel) {
		return Role.getRolesAboveAccessLevel(accessLevel);
	}
	
	public Set<Role> getElevatedRolesOnAccessLevel(int accessLevel) {
		return Role.getElevatedRolesOnAccessLevel(accessLevel);
	}
	
	
}
