package com.suvi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suvi.model.Role;
import com.suvi.repository.RoleRepo;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;
	
	public List<Role> listAllRoles(){
		List<Role> rolesList = roleRepo.findAll();
		return rolesList;
	}
	
	public List<Role> listActiveRoles(){
		List<Role> rolesList = roleRepo.findActiveRoles();
		return rolesList;
	}
	public Role findRoleByRoleId(int roleId){
		Role role = roleRepo.findByRoleId(roleId);
		return role;
	}	
	
	public List<Role> saveRoles(List<Role> newRoles){
		List<Role> addedRoles = roleRepo.saveAll(newRoles);
		return addedRoles;
	}
	
	public Role updateRole(Role role) {
		Role updatedRole = roleRepo.save(role);
		return updatedRole;
	}
}
