package br.com.fiord.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Dish")
@Table(name = "dish")
public class Dish implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String dish;

	private Float price;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "restaurant_id", nullable = false)
	private Restaurant restaurant;

	public Dish() {

	}

	public Dish(String dish, Float price) {
		super();
		this.dish = dish;
		this.price = price;
	}

	public Dish(String dish, Float price, Restaurant restaurant) {
		super();
		this.dish = dish;
		this.price = price;
		this.restaurant = restaurant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
