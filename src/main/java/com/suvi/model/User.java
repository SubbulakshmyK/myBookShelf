package com.suvi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table (name="US_USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="USER_NAME" , nullable=false, unique=true)
	private String userName;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@Column(name="EMAIL", nullable=false, unique=true)
	private String email;
	
	@Column(name="MOBILE_NO", nullable=false)
	private String mobileNo;
	
	@Column(name="ALT_MOBILE_NO",nullable=true)
	private String altMobileNo;
	
	@Column(name="FULL_NAME",nullable=true)
	private String fullName;
	
	private boolean enabled;
	
    @ManyToMany(fetch = FetchType.EAGER) //cascade = CascadeType.ALL,
    @JoinTable(
            name = "US_USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"), //, referencedColumnName="USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")//, referencedColumnName="ROLE_ID")
            )
    private Set<Role> roles = new HashSet<>();
    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAltMobileNo() {
		return altMobileNo;
	}
	public void setAltMobileNo(String altMobileNo) {
		this.altMobileNo = altMobileNo;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void addRole(Role role) {
		this.roles.add(role);
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", altMobileNo=" + altMobileNo + ", fullName=" + fullName
				+ ", enabled=" + enabled + ", roles=" + roles + "]";
	}

}
