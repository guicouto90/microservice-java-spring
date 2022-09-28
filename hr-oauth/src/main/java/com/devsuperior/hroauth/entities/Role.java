package com.devsuperior.hroauth.entities;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String roleName;
	
	private Long id;
	
	public Role() {}

	public Role(String roleName, Long id) {
		super();
		this.roleName = roleName;
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

}
