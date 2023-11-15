package com.example.SpringBootRESTAPI.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringBootRESTAPI.model.Item;

@Service
public class ItemService {
	
	private List<Item> allItems = Arrays.asList(
			new Item("10001", "ネックレス", "ジュエリ"),
			new Item("10002", "パーカー", "ファッション"),
			new Item("10003", "フェイスクリーム", "ビューティー"),
			new Item("10004", "サプリメント", "ヘルス"),
			new Item("10005", "ブルーベリー", "フード")
			);
	
	public List<Item> getAllItems() {
		return allItems;
	}
	
	public Item getItem(String itemId) {
		for(int i=0; i<allItems.size(); i++) {
			if(allItems.get(i).getItemId().equals(itemId)) {
				return (Item)allItems.get(i);
			}
		}
		return null;
	}
}
