/**
 * Copyright (c) HCL PCF TEAM ,2019.
 */
package com.hcl.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 *
 * com.hcl.cloud.user. abhishek_sin
 */
@SpringBootApplication
//@EnableJpaAuditing
public class UsermoduleApplication {
	/**
	 * main.
	 *
	 * @param args
	 *            for main class.
	 */
	public static void main(String[] args) {
		SpringApplication.run(UsermoduleApplication.class, args);
	}

}
