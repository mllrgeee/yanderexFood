package com.yanderexFood.yanderexFood;

import com.yanderexFood.yanderexFood.models.UserDetailsImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YanderexFoodApplication {
	public static UserDetailsImpl currentUser;
	public static void main(String[] args) {
		SpringApplication.run(YanderexFoodApplication.class, args);
	}

}
