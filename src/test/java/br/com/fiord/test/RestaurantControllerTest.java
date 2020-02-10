package br.com.fiord.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import br.com.fiord.SistemaFiordApplication;
import br.com.fiord.entity.Dish;
import br.com.fiord.entity.Restaurant;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SistemaFiordApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RestaurantControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void testGetAllRestaurant() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/restaurants", HttpMethod.GET,
				entity, String.class);
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetRestaurantById() {
		Restaurant restaurant = restTemplate.getForObject(getRootUrl() + "/api/v1/restaurants/1", Restaurant.class);
		System.out.println(restaurant.getName());
		assertNotNull(restaurant);
	}

	@Test
	public void testSaveRestaurant() {
		Restaurant restTest = new Restaurant();
		restTest.setName("Restaurante Teste");
		Dish dish1 = new Dish("Macarrao", 20.50F, restTest);
		Set<Dish> itemSet = new HashSet<Dish>();
		itemSet.add(dish1);
		ResponseEntity<Restaurant> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/restaurants",
				restTest, Restaurant.class);
	}

	@Test
	public void testUpdateRestaurant() {
		Integer id = 1;
		Restaurant restTest = restTemplate.getForObject(getRootUrl() + "/api/v1/restaurants/" + id, Restaurant.class);
		restTest.setName("Restaurante Teste Update");
		Dish dish2 = new Dish("Lasanha Teste", 30.50F, restTest);
		Set<Dish> itemSet = new HashSet<Dish>();
		itemSet.add(dish2);
		restTemplate.put(getRootUrl(), "/api/v1/restaurants/" + id, restTest);
		Restaurant updateRestaurant = restTemplate.getForObject(getRootUrl() + "/api/v1/restaurants/" + id,
				Restaurant.class);
		assertNotNull(updateRestaurant);
	}

	public void testeDeleteRestaurant() {
		int id = 2;
		Restaurant restTest = restTemplate.getForObject(getRootUrl() + "/api/v1/restaurants/" + id, Restaurant.class);
		assertNotNull(restTest);
		restTemplate.delete(getRootUrl() + "/api/v1/restaurants/" + id, Restaurant.class);
		try {
			restTest = restTemplate.getForObject(getRootUrl() + "/api/v1/restaurants/" + id, Restaurant.class);
		} catch (final HttpClientErrorException ex) {
			assertEquals(ex.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
