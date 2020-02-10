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

import br.com.fiord.entity.Restaurant;
import br.com.fiord.service.RestaurantService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Restaurant>> getAllRestaurant() {
		return ResponseEntity.ok().body(restaurantService.getAllRestaurant());
	}

	@RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(restaurantService.getRestaurantById(id));
	}

	@RequestMapping(value = "/restaurants", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
		return ResponseEntity.ok().body(this.restaurantService.saveRestaurante(restaurant));
	}

	@RequestMapping(value = "/restaurants/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Integer id, @RequestBody Restaurant restaurant) {
		restaurant.setId(id);
		return ResponseEntity.ok().body(this.restaurantService.updateRestaurant(restaurant));
	}

	@RequestMapping(value = "/restaurants/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public HttpStatus deleteRestaurant(@PathVariable Integer id) {
		this.restaurantService.deleteRestaurant(id);
		return HttpStatus.OK;
	}

}
