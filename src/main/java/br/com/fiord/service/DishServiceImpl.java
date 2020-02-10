package br.com.fiord.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiord.entity.Dish;
import br.com.fiord.exception.ResourceNotFoundException;
import br.com.fiord.repository.DishRepository;

@Service
@Transactional
public class DishServiceImpl implements DishService {

	@Autowired
	private DishRepository dishRepository;

	@Override
	public Dish saveDish(Dish dish) {
		return dishRepository.save(dish);
	}

	@Override
	public Dish updateDish(Dish Dish) {
		Optional<Dish> dishDb = this.dishRepository.findById(Dish.getId());

		if (dishDb.isPresent()) {
			Dish dishUpdate = dishDb.get();
			dishUpdate.setId(Dish.getId());
			dishUpdate.setDish(Dish.getDish());
			dishUpdate.setPrice(Dish.getPrice());
			dishRepository.save(dishUpdate);
			return dishUpdate;
		} else {
			throw new ResourceNotFoundException("Dish not found with id: " + Dish.getId());
		}
	}

	@Override
	public List<Dish> getAllDish() {
		return this.dishRepository.findAll();
	}

	@Override
	public Dish getDishById(Integer id) {
		Optional<Dish> dishDb = this.dishRepository.findById(id);

		if (dishDb.isPresent()) {
			return dishDb.get();
		} else {
			throw new ResourceNotFoundException("Dish not found with id: " + id);
		}

	}

	@Override
	public void deleteDish(Integer id) {
		Optional<Dish> DishDb = this.dishRepository.findById(id);

		if (DishDb.isPresent()) {
			this.dishRepository.delete(DishDb.get());
		} else {
			throw new ResourceNotFoundException("Dish nao encontrado com esse id: " + id);
		}

	}

}
