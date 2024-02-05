package com.devsuperior.dsmovie.tests;

import com.devsuperior.dsmovie.entities.RoleEntity;
import com.devsuperior.dsmovie.entities.UserEntity;

import java.time.LocalDate;

public class UserFactory {

	public static UserEntity createUserEntity() {
		UserEntity user = new UserEntity(2L, "Maria", "maria@gmail.com", "$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
		return user;
	}

	//TREINANDO...
	
	public static UserEntity createClientUserEntity() {
		UserEntity user = new UserEntity(1L, "Alex", "alex@gmail.com", "$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
		user.addRole(new RoleEntity(1L, "ROLE_CLIENT"));
		return user;
	}

	public static UserEntity createAdminUserEntity(){
		UserEntity user = new UserEntity(2L, "Maria","maria@gmail.com", "$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
		user.addRole(new RoleEntity(2L, "ROLE_ADMIN"));
		return user;
	}

	public static UserEntity createCustomClientUser(Long id, String username){
		UserEntity userCustomClient = new UserEntity(id, username, "alex@gmail.com", "$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO");
		userCustomClient.addRole(new RoleEntity(1L, "ROLE_CLIENT"));
		return userCustomClient;
	}

	public static UserEntity createCustomAdminUser(Long id, String username){
		UserEntity userCustomAdmin = new UserEntity(id, username, "maria@gmail.com", "$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO");
		userCustomAdmin.addRole(new RoleEntity(2L, "ROLE_ADMIN"));
		return userCustomAdmin;
	}
}
