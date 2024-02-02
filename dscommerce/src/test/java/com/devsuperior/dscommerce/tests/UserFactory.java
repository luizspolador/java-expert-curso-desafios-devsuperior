package com.devsuperior.dscommerce.tests;

import com.devsuperior.dscommerce.entities.Role;
import com.devsuperior.dscommerce.entities.User;

import java.time.LocalDate;

public class UserFactory {
    public static User createClientUser(){
        User userClient = new User(1L, "Maria", "maria@gmail.com", "999845785", LocalDate.parse("2001-07-25"), "$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO");
        userClient.addRole(new Role(1L, "ROLE_CLIENT"));
        return userClient;
    }

    public static User createAdminUser(){
        User userAdmin = new User(2L, "Alex", "alex@gmail.com", "999845778", LocalDate.parse("1987-12-13"), "$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO");
        userAdmin.addRole(new Role(2L, "ROLE_ADMIN"));
        return userAdmin;
    }

    public static User createCustomClientUser(Long id, String username){
        User userCustomClient = new User(id, username, "maria@gmail.com", "999845785", LocalDate.parse("2001-07-25"), "$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO");
        userCustomClient.addRole(new Role(1L, "ROLE_CLIENT"));
        return userCustomClient;
    }

    public static User createCustomAdminUser(Long id, String username){
        User userCustomAdmin = new User(id, username, "alex@gmail.com", "999845778", LocalDate.parse("1987-12-13"), "$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO");
        userCustomAdmin.addRole(new Role(2L, "ROLE_ADMIN"));
        return userCustomAdmin;
    }
}
