package br.com.fiord.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiord.entity.Restaurant;
import br.com.fiord.exception.ResourceNotFoundException;
import br.com.fiord.repository.RestaurantRepository;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurant saveRestaurante(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		Optional<Restaurant> restaurantDb = this.restaurantRepository.findById(restaurant.getId());

		if (restaurantDb.isPresent()) {
			Restaurant restaurantUpdate = restaurantDb.get();
			restaurantUpdate.setId(restaurant.getId());
			restaurantUpdate.setName(restaurant.getName());
			restaurantRepository.save(restaurantUpdate);
			return restaurantUpdate;
		} else {
			throw new ResourceNotFoundException("Restaurant not found with id: " + restaurant.getId());
		}
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		return this.restaurantRepository.findAll();
	}

	@Override
	public Restaurant getRestaurantById(Integer id) {
		Optional<Restaurant> restaurantDb = this.restaurantRepository.findById(id);

		if (restaurantDb.isPresent()) {
			return restaurantDb.get();
		} else {
			throw new ResourceNotFoundException("Restaurant not found with id: " + id);
		}
	}

	@Override
	public void deleteRestaurant(Integer id) {
		Optional<Restaurant> restaurantDb = this.restaurantRepository.findById(id);

		if (restaurantDb.isPresent()) {
			this.restaurantRepository.delete(restaurantDb.get());
		} else {
			throw new ResourceNotFoundException("Restaurant not found with id: " + id);
		}
	}

}
