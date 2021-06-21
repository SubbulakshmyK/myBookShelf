package com.suvi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suvi.model.Role;
import com.suvi.model.User;
import com.suvi.repository.RoleRepo;
import com.suvi.repository.UserRepo;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
    public List<User> listAllUsers() {
        return userRepo.findAll();
    }
     
    public void saveUserDefRole(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    user.setEnabled(true);
	    
	    Role role = roleRepo.findByRoleCode("USER");
	    user.addRole(role);
    	userRepo.save(user);
    }
    
    public void saveUser(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    user.setEnabled(true);
    	userRepo.save(user);
    }
    
    public void updateUser(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	   // user.setEnabled(true);
	    if(user.getRoles()==null || user.getRoles().isEmpty()) {
	    	Role role = roleRepo.findByRoleCode("USER");
	    	user.addRole(role);
	    }
	    System.out.println("=====update User=====>"+user);
    	userRepo.save(user);
    }
     
    public void updatePassword(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    user.setEnabled(true);
    	userRepo.save(user);
    }
    public User get(long id) {
        return userRepo.findById(id).get();
    }
     
    public void delete(long id) {
    	userRepo.deleteById(id);
    }
    
    public List<Role> getRoles(){
    	return roleRepo.findAll();
    }
}
