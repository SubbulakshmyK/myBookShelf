package com.suvi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.suvi.model.Permission;
import com.suvi.model.Role;
import com.suvi.model.User;
import com.suvi.repository.RoleRepo;
import com.suvi.service.PermissionService;
import com.suvi.service.RoleService;
import com.suvi.service.UserService;

@Controller
public class LoginUserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/signUp")
	public String UserSignUp(Model model) {
	    //service.save(user);
		model.addAttribute("mode", "SIGNUP");
	    return "signUp";
	}

	@GetMapping("/addUser")
	public String AddUser(Model model ) {
	    //service.save(user);
		model.addAttribute("mode", "ADD");
	    return "signUp";
	}

	@GetMapping("/editUser/{userId}")
	public String editUser(@PathVariable("userId") Long userId, Model model) {
		User user = userService.get(userId);
		List<Role> roleslist = userService.getRoles();
		model.addAttribute("user", user);
		model.addAttribute("roleslist", roleslist);
		model.addAttribute("mode", "EDIT");
		System.out.println("===model=>"+model);
	    //service.save(user);
	    return "/UserEdit";
	}
	
	@PostMapping("/signUpUser")
	public String signUpUser(User user) {
		userService.saveUserDefRole(user);
		return "index";
	}
	
	@PostMapping("/saveUser")
	public String SaveUser(User user) {
		userService.saveUser(user);
		return "index";
	}
	
	@GetMapping("/Welcome")
	public String loginSuccess(Model model) {
		return("Welcome");
	}
	
	@GetMapping("/logout")
	public String logoutSuccess(Model model) {
		return("index?logout");
	/*	public String logoutSuccess(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/Welcome?logout";*/
	}

	@GetMapping("/listUsers")
	public String listUsers(Model model) {
		List<User> usersList = userService.listAllUsers();
		model.addAttribute("usersList", usersList);
		System.out.println("===========inside controller=====Edit==usersList==="+usersList);
		return "usersList";
	}
	
	@GetMapping("/updateUser/{id}") //not used
	public String editUserProfile(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("Edit_User");
		List<Role> roles = userService.getRoles();
	    User user = userService.get(id);
	    mav.addObject("user", user);
	    mav.addObject("rolesList", roles);
	    mav.addObject("mode", "EDIT");
		return("UserAdd");
	}

	@PostMapping("/updateUser")
	public String updateUser(User user) {
		userService.updateUser(user);
		return("redirect:/listUsers");
	}	
	
	@PostMapping("/deleteUser")
	public String deleteUser(User user) {
		System.out.println("===========inside controller=======Delete===");
		userService.delete(user.getUserId());
		return("UsersList");
	}
	
	@GetMapping("/listRoles")
	public String listRoles(Model model) {
		List<Role> rolesList=roleService.listAllRoles();
		model.addAttribute("rolesList", rolesList);
		return("RolesList");
	}
	@GetMapping("/addRoles")
	public String addRoles( Model model) {
		model.addAttribute("role", new Role());
		model.addAttribute("mode", "ADD");
		return("/RolesAdd");
	}
	@PostMapping("/saveRoles")
	public String saveRoles(Role newRole) {
		List<Role> newRoles = new ArrayList<Role>();
		newRoles.add(newRole);
		roleService.saveRoles(newRoles);
		return("redirect:/listRoles");
	}
	@GetMapping("/editRole/{roleId}")
	public String editRole(@PathVariable long roleId, Model model) {
		Role role = roleService.findRoleByRoleId((int) roleId);
		model.addAttribute("role", role);
		model.addAttribute("mode", "EDIT");
		return("/RoleEdit");
	}
	@PostMapping("/updateRole")
	public String updateRole(Role role) {
		roleService.updateRole(role);
		return("redirect:/listRoles");
	}	
	@GetMapping("/listPermissions")
	public String listPermissions(Model model) {
		List<Permission> permissionsList = permissionService.listAllPermissions();
		model.addAttribute("permissionsList", permissionsList);
		return("PermissionsList");
	}
	@GetMapping("/addPermissions")
	public String addPermissions( Model model) {
		model.addAttribute("permission", new Permission());
		model.addAttribute("mode", "ADD");
		return("/PermissionsAdd");
	}
	@PostMapping("/savePermissions")
	public String savePermissions(Permission newPermission) {
		List<Permission> newPermissions = new ArrayList<Permission>();
		newPermissions.add(newPermission);
		permissionService.savePermissions(newPermissions);
		return("redirect:/listPermissions");
	}
	@GetMapping("/editPermission/{permissionId}")
	public String editPermission(@PathVariable int permissionId, Model model) {
		Permission permission = permissionService.findByPermissionId(permissionId);
		model.addAttribute("permission", permission);
		model.addAttribute("mode", "EDIT");
		return("/PermissionEdit");
	}
	
	@PostMapping("/updatePermission")
	public String updatePermission(Permission permission) {
		permissionService.updatePermission(permission);
		return("redirect:/listPermissions");
	}
}
