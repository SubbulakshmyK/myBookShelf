package com.suvi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suvi.model.Permission;
import com.suvi.model.Permission;
import com.suvi.repository.PermissionRepo;

@Service
@Transactional
public class PermissionService {
	
	@Autowired
	private PermissionRepo permissionRepo;
	
	public List<Permission> listAllPermissions(){
		List<Permission> permissionsList = permissionRepo.findAll();
		return permissionsList;
	}
	public List<Permission> listActivePermissions(){
		List<Permission> permissionsList = permissionRepo.findActivePermissions();
		return permissionsList;
	}
	
	public Permission findByPermissionId(int permissionId){
		Permission permission = permissionRepo.findByPermissionId(permissionId);
		return permission;		
	}

	public List<Permission> savePermissions(List<Permission> newPermissions){
		List<Permission> addedPermissions = permissionRepo.saveAll(newPermissions);
		return addedPermissions;
	}
	
	public Permission updatePermission(Permission Permission) {
		Permission updatedPermission = permissionRepo.save(Permission);
		return updatedPermission;
	}
}
