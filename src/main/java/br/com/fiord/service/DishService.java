package br.com.fiord.service;

import java.util.List;

import br.com.fiord.entity.Dish;

public interface DishService {

	Dish saveDish(Dish dish);

	Dish updateDish(Dish dish);

	List<Dish> getAllDish();

	Dish getDishById(Integer id);

	void deleteDish(Integer id);

}
