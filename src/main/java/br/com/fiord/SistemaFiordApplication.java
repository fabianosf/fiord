package br.com.fiord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiord.entity.Dish;
import br.com.fiord.entity.Restaurant;
import br.com.fiord.repository.DishRepository;
import br.com.fiord.repository.RestaurantRepository;

@SpringBootApplication
public class SistemaFiordApplication implements CommandLineRunner {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private DishRepository dishRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaFiordApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Restaurant rest1 = new Restaurant("Restaurant 1");
		Restaurant rest2 = new Restaurant("Restaurant 2");

		Dish dish1 = new Dish("Macarrao", 20.50F, rest1);
		Dish dish2 = new Dish("Lasanha", 28.00F, rest1);
		Dish dish3 = new Dish("Peixe", 20.00F, rest2);
		Dish dish4 = new Dish("Arroz", 10.00F, rest2);

		List<Dish> itemList = new ArrayList<Dish>();
		itemList.add(dish1);
		itemList.add(dish2);
		itemList.add(dish3);
		itemList.add(dish4);

		restaurantRepository.saveAll(Arrays.asList(rest1, rest2));
		dishRepository.saveAll(Arrays.asList(dish1, dish2, dish3, dish4));

	}

}
