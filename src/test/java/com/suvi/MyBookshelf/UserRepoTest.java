package com.suvi.MyBookshelf;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.suvi.model.Role;
import com.suvi.model.User;
import com.suvi.repository.RoleRepo;
import com.suvi.repository.UserRepo;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTest {
 
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepo userRepo;
     
    @Autowired
    private RoleRepo roleRepo;
    
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUserName("Kumar");
        user.setPassword("ravi2020");
        user.setEmail("ravikumar@gmail.com");
        user.setMobileNo("0");
        user.setAltMobileNo("0");
        user.setEnabled(true);
        user.setFullName("Ravi");

        User savedUser = userRepo.save(user);
         
        User existUser = entityManager.find(User.class, savedUser.getUserId());
         
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
         
    }
    
    @Test
    public void testAddRoleToNewUser() {
        Role roleAdmin = roleRepo.findByRoleCode("ADMIN");
         
        User user = new User();
        user.setUserName("Kumar2");
        user.setPassword("ravi20202");
        user.setEmail("ravikumar@gmail2.com");
        user.setMobileNo("0");
        user.setAltMobileNo("0");
        user.setEnabled(true);
        user.setFullName("Ravi2");
        user.addRole(roleAdmin);       
         
        User savedUser = userRepo.save(user);
         
        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }
    
    @Test
    public void testAddRoleToExistingUser() {
        User user = userRepo.findById(5L).get();
        Role roleUser = roleRepo.findByRoleCode("USER");
        Role roleGuest = roleRepo.findByRoleCode("GUEST");
         
        user.addRole(roleUser);
        user.addRole(roleGuest);
         
        User savedUser = userRepo.save(user);
         
        assertThat(savedUser.getRoles().size()).isEqualTo(2);      
    }

}
