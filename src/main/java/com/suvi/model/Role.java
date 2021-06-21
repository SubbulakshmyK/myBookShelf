package com.suvi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "US_ROLES")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROLE_ID")
    private Integer roleId;
    
    @Column(name="ROLE_CODE", nullable=false, unique=true)
    private String roleCode;
    
    @Column(name="ROLE_NAME", nullable=false, unique=true)
    private String roleName;
    
   // @ManyToMany(mappedBy = "roles")
    //private Set<User> users;
    @Column(name="PRIORITY", nullable=false, unique=true)
    private int priority;
    
    @Column(name="ENABLED", nullable=false)
    private boolean enabled=true;
    
    @Column(name="ISDEFAULT")
    private boolean defaultEnrty=false;

//    @ManyToMany
//    @JoinTable(
//        name = "BS_US_ROLE_PERMISSIONS", 
//        joinColumns =@JoinColumn( name = "ROLE_ID"),//, referencedColumnName = "ROLE_ID"), 
//        inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID")) //, referencedColumnName = "PERMISSION_ID"))
//    private Set<Permission> permissions = new HashSet<Permission>(); 
//   
//    
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isDefaultEntry() {
		return defaultEnrty;
	}
	public void setDefaultEntry(boolean isDefault) {
		this.defaultEnrty = isDefault;
	}

//	public Set<Permission> getPermissions() {
//		return permissions;
//	}
//	public void setPermissions(Set<Permission> permissions) {
//		this.permissions = permissions;
//	}
//	public void addPermission(Permission permission) {
//		this.permissions.add(permission);
//	}
	
	@Override
	public String toString() {
		//return this.roleName;
		return this.roleCode;
	}
	public String print() {
		//return this.roleName;
		//return this.roleCode;
		return "Role [roleId=" + roleId + ", roleCode=" + roleCode + ", roleName=" + roleName + ", Default="+defaultEnrty//users=" + users
				+ ", priority=" + priority + ", Enabled=" + enabled + "]";
	}
 
}