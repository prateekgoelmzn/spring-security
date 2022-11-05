package com.pg;

import com.pg.constatnts.Constant;
import com.pg.model.User;
import com.pg.repository.AppRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringSecurityJdbcApplication {

	Logger log = LoggerFactory.getLogger(SpringSecurityJdbcApplication.class);

	@Autowired
	AppRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJdbcApplication.class, args);
	}

	@PostConstruct
	public void loadData() {
		log.error("Loading initial data in DB....");
		User user = new User();
		user.setName("user");
		user.setPassword("password");
		user.setRole(Constant.ROLE_USER);
		User admin = new User();
		admin.setName("admin");
		admin.setPassword("admin");
		admin.setRole(Constant.ROLE_ADMIN);
		repo.save(user);
		repo.save(admin);
		log.error("Data loaded successfully.");
	}
}
