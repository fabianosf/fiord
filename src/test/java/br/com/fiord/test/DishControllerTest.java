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
public class DishControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void testGetAllDish() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/dishs", HttpMethod.GET, entity,
				String.class);
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetDishById() {
		Dish dish = restTemplate.getForObject(getRootUrl() + "/api/v1/dishs/1", Dish.class);
		System.out.println(dish.getDish());
		System.out.println(dish.getPrice());
		assertNotNull(dish);
	}

	@Test
	public void testSaveDish() {
		Dish dishTest = new Dish();
		dishTest.setDish("Lasanha");
		dishTest.setPrice(26.50F);
		Restaurant rest1 = new Restaurant("Restaurante Massa");
		Set<Restaurant> itemSet = new HashSet<Restaurant>();
		itemSet.add(rest1);
		ResponseEntity<Dish> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/dishs", dishTest,
				Dish.class);
	}

	@Test
	public void testUpdateDish() {
		Integer id = 1;
		Dish dishTest = restTemplate.getForObject(getRootUrl() + "/api/v1/dishs/" + id, Dish.class);
		dishTest.setDish("Macarrao da Vovó");
		dishTest.setPrice(15.50F);
		Restaurant rest1 = new Restaurant("Restaurante Super Massa");
		Set<Restaurant> itemSet = new HashSet<Restaurant>();
		itemSet.add(rest1);

		restTemplate.put(getRootUrl(), "/api/v1/dishs/" + id, dishTest);
		Restaurant updateDish = restTemplate.getForObject(getRootUrl() + "/api/v1/dishs/" + id, Restaurant.class);
		assertNotNull(updateDish);
	}

	@Test
	public void testeDeleteDish() {
		int id = 2;
		Dish dishTest = restTemplate.getForObject(getRootUrl() + "/api/v1/dishs/" + id, Dish.class);
		assertNotNull(dishTest);
		restTemplate.delete(getRootUrl() + "/api/v1/dishs/" + id, Dish.class);
		try {
			dishTest = restTemplate.getForObject(getRootUrl() + "/api/v1/dishs/" + id, Dish.class);
		} catch (final HttpClientErrorException ex) {
			assertEquals(ex.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
