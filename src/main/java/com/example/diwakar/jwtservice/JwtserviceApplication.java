package com.example.diwakar.jwtservice;

import com.example.diwakar.jwtservice.models.AppUser;
import com.example.diwakar.jwtservice.models.Role;
import com.example.diwakar.jwtservice.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class JwtserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtserviceApplication.class, args);
	}

	CommandLineRunner run(AppUserService appUserService) {
		return args -> {
			appUserService.saveRole(new Role(null, "ROLE_USER"));
			appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
			appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
			appUserService.saveRole(new Role(null, "ROLE_SUPERADMIN"));

			appUserService.saveUser(new AppUser(null, "John Travolta", "john", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Will Smith", "will", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

			appUserService.addRoleToUser("john", "ROLE_USER");
			appUserService.addRoleToUser("john", "ROLE_MANAGER");
			appUserService.addRoleToUser("will", "ROLE_MANAGER");
			appUserService.addRoleToUser("jim", "ROLE_ADMIN");
			appUserService.addRoleToUser("arnold", "ROLE_SUPERADMIN");
			appUserService.addRoleToUser("arnold", "ROLE_ADMIN");
			appUserService.addRoleToUser("arnold", "ROLE_USER");

		};
	}

}
