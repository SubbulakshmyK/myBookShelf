package com.suvi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.suvi.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

	@Query("SELECT r FROM Role r WHERE r.roleName = ?1")
	public Role findByRoleCode(String roleCode);

	@Query("SELECT r FROM Role r WHERE r.enabled = 1 order by r.priority")
	public List<Role> findActiveRoles();

	@Query("SELECT r FROM Role r WHERE r.roleId = ?1")
	public Role findByRoleId(int roleId);
}
