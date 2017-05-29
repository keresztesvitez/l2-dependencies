package com.epam.training;

import java.util.HashSet;
import java.util.Set;

public enum Role {
	
	ADMIN(true, 10), USER(true, 8), TRAINER(true, 9), PARTICIPANT(false, 2, false), DEVELOPER(true, 5), ASSISTANT(false, 4);

	private boolean elevated;

	private boolean enabled;

	private int accessLevel;
	
	private Role(boolean elevated, int accessLevel) {
		this.elevated = elevated;
		this.enabled = true;
		this.accessLevel = accessLevel;
	}

	private Role(boolean elevated, int accessLevel, boolean enabled) {
		this.elevated = elevated;
		this.enabled = enabled;
		this.accessLevel = accessLevel;
	}

	public boolean isElevated() {
		return elevated;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public static Set<Role> getElevatedRoles() {
		Set<Role> roles = new HashSet<Role>();
		for (Role currentRole : Role.values()) {
			if (currentRole.isEnabled() && currentRole.isElevated()) {
				roles.add(currentRole);
			}
		}
		return roles;
	}

	public static Set<Role> getRolesAboveAccessLevel(int accessLevel) {
		Set<Role> roles = new HashSet<Role>();
		for (Role currentRole : Role.values()) {
			if (currentRole.getAccessLevel() >= accessLevel) {
				if (currentRole.isEnabled()) {
					roles.add(currentRole);
				}
			}
		}
		return roles;
	}

	public static Set<Role> getRolesBelowAccessLevel(int accessLevel) {
		Set<Role> roles = new HashSet<Role>();
		for (Role currentRole : Role.values()) {
			if (currentRole.getAccessLevel() < accessLevel && currentRole.isEnabled()) {
				roles.add(currentRole);
			}
		}
		return roles;
	}

	public static Set<Role> getElevatedRolesOnAccessLevel(int accessLevel) {
		Set<Role> roles = new HashSet<Role>();
		for (Role currentRole : Role.values()) {
			if (currentRole.getAccessLevel() == accessLevel && currentRole.isEnabled() && currentRole.isElevated()) {
				roles.add(currentRole);
			}
		}
		return roles;
	}

}