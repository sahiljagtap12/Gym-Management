package com.cdac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class GymManagementApplication{

	public static void main(String[] args) {
		SpringApplication.run(GymManagementApplication.class, args);
	}
}
