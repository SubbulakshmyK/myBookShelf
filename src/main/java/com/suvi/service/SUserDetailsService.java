package com.suvi.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//import com.suvi.model.Permission;
import com.suvi.model.Role;
import com.suvi.model.User;
import com.suvi.repository.RoleRepo;
import com.suvi.repository.UserRepo;

public class SUserDetailsService implements UserDetailsService {


	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
    public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException {
        User user = userRepo.findByUserName(userName);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
              " ", " ", true, true, true, true, 
              getAuthorities(roleRepo.findActiveRoles())
              //getAuthorities(Arrays.asList(roleRepo.findByRoleCode("USER_ROLE")))
             );
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
           user.getPassword(), user.isEnabled(), true, true, 
          true, getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities( Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roleCodes = new ArrayList<>();
        for (Role role : roles) {
        	roleCodes.add(role.getRoleCode());
        }
        for (String rolecode : roleCodes) {
            authorities.add(new SimpleGrantedAuthority(rolecode));
        }
        return authorities;
        //return getGrantedAuthorities(getPermissions(roles));
    }

    private List<String> getPermissions(Collection<Role> roles) {
 
        List<String> permissions = new ArrayList<>();
       /* List<Permission> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPermissions());
        }
        for (Permission permission : collection) {
        	permissions.add(permission.getPermissionName());
        }*/
        return permissions;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> permissions) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }
        return authorities;
    }

	/*
	 * @Override
	public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
		User user = userRepo.findByUser_name(user_name);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new SUsersDetail(user);

	}
   private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }*/
}
