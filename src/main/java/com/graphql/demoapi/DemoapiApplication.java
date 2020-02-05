package com.graphql.demoapi;

import com.graphql.demoapi.model.Food;
import com.graphql.demoapi.service.FoodService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoapiApplication.class, args);
	}

	@Bean
	ApplicationRunner init(FoodService foodService) {
		return args -> {
			Stream.of("Pizza", "Spam", "Eggs", "Avocado").forEach(name -> {
				Food food = new Food();
				food.setName(name);
				foodService.saveFood(food);
			});
			foodService.getFoods().forEach(System.out::println);
		};
	}
}
