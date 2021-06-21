package com.suvi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.suvi.model.Permission;

public interface PermissionRepo extends JpaRepository<Permission, Integer>{

	@Query("SELECT p FROM Permission p WHERE p.enabled = 1 order by p.permissionName")
	List<Permission> findActivePermissions();

	@Query("SELECT p FROM Permission p WHERE p.permissionId = ?1")
	Permission findByPermissionId(int permissionId);

}
