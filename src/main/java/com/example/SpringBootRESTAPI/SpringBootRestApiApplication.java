package com.example.SpringBootRESTAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.SpringBootRESTAPI.model.Item;
import com.example.SpringBootRESTAPI.repo.ItemRepository;

@SpringBootApplication
@EnableCaching
public class SpringBootRestApiApplication implements CommandLineRunner {
	
	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		itemRepository.save(new Item("ネックレス", "ジュエリ")); 
		itemRepository.save(new Item("パーカー", "ファッション")); 
		itemRepository.save(new Item("フェイスクリーム", "ビューティー")); 
		itemRepository.save(new Item("サプリメント", "ヘルス")); 
		itemRepository.save(new Item("ブルーベリー", "フード")); 
	}

}
