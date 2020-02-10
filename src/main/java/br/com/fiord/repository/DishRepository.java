package br.com.fiord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiord.entity.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

}
