package com.example.SpringBootRESTAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootRESTAPI.model.Item;
import com.example.SpringBootRESTAPI.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/items")
	public List<Item> getAllItems() {
		
		return itemService.getAllItems();
	}
	
	@GetMapping("/items/{itemId}")
	public Item getItem(@PathVariable("itemId") String itemId) {
		return itemService.getItem(itemId);
	}
}
