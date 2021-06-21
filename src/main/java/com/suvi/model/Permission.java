package com.suvi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="US_PERMISSIONS")
public class Permission {
	@Id
	@Column(name = "PERMISSION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permissionId;
	
    @Column(name= "PERMISSION_CODE", nullable=false, unique=true)
    private String permissionCode;
	
    @Column(name= "PERMISSION_NAME", nullable=false, unique=true)
    private String permissionName;
    
    @Column(name= "ENABLED")
    private boolean enabled=true;
    
    @Column(name= "ISDEFAULT")
    private boolean defaultEntry=false;
    
    //@ManyToMany(mappedBy = "PERMISSIONS")
   //private Set<Role> roles = new HashSet<Role>();

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isDefaultEntry() {
		return defaultEntry;
	}
	public void setDefaultEntry(boolean isDefault) {
		this.defaultEntry = isDefault;
	}
	
/*
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
*/
}
