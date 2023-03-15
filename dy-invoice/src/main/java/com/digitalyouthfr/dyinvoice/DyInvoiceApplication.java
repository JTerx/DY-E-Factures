package com.digitalyouthfr.dyinvoice;

import com.digitalyouthfr.dyinvoice.service.implementation.RoleServiceImplementation;
import com.digitalyouthfr.dyinvoice.service.implementation.UserServiceImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DyInvoiceApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {

		SpringApplication.run(DyInvoiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initRoleService(RoleServiceImplementation roleService) {
		return args -> {
			roleService.createDefaultRoles();
		};
	}

/*	@Bean
	public CommandLineRunner initUserService(UserServiceImplementation userService) {
		return args -> {
			userService.createDefaultAdmin();
		};
	}*/

}
