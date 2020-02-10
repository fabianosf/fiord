package br.com.fiord.service;

import java.util.List;

import br.com.fiord.entity.Restaurant;

public interface RestaurantService {

	Restaurant saveRestaurante(Restaurant restaurant);

	Restaurant updateRestaurant(Restaurant restaurant);

	List<Restaurant> getAllRestaurant();

	Restaurant getRestaurantById(Integer id);

	void deleteRestaurant(Integer id);

}
