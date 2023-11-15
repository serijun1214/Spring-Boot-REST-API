package com.example.SpringBootRESTAPI.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootRESTAPI.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	
}
