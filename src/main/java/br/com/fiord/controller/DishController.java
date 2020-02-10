package br.com.fiord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiord.entity.Dish;
import br.com.fiord.service.DishService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/dish")
public class DishController {

	@Autowired
	private DishService dishService;

	@RequestMapping(value = "/dishs", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Dish>> getAllDish() {
		return ResponseEntity.ok().body(dishService.getAllDish());
	}

	@RequestMapping(value = "/dishs/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Dish> getDishById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(dishService.getDishById(id));
	}

	@RequestMapping(value = "/dishs", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Dish> saveDish(@RequestBody Dish dish) {
		return ResponseEntity.ok().body(this.dishService.saveDish(dish));
	}

	@RequestMapping(value = "/dishs/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Dish> updateDish(@PathVariable Integer id, @RequestBody Dish dish) {
		dish.setId(id);
		return ResponseEntity.ok().body(this.dishService.updateDish(dish));
	}

	@RequestMapping(value = "/dishs/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public HttpStatus deleteDish(@PathVariable Integer id) {
		this.dishService.deleteDish(id);
		return HttpStatus.OK;
	}

}
