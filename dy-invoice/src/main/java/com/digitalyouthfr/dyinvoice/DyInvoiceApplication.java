package com.digitalyouthfr.dyinvoice;

import com.digitalyouthfr.dyinvoice.service.implementation.RoleServiceImplementation;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class DyInvoiceApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

/*	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.NONE);
		mapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.ANY);
		mapper.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.ANY);
		return mapper;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(DyInvoiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initRoleService(RoleServiceImplementation roleService) {
		return args -> {
			roleService.createDefaultRoles();
		};
	}

    /*@Bean
    public CommandLineRunner initUserService(UserServiceImplementation userService) {
        return args -> {
            userService.createDefaultAdmin();
        };
    }*/

}
