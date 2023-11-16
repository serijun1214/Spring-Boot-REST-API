package com.example.SpringBootRESTAPI;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringBootRESTAPI.controller.ItemController;
import com.example.SpringBootRESTAPI.repo.ItemRepository;
import com.example.SpringBootRESTAPI.service.ItemService;

@SpringBootTest
class SpringBootRestApiApplicationTests {

	@Autowired
	private ItemController itemController;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired 
	private ItemRepository itemRepository;
	
	//アプリケーションがSpringコンテキストを正常にロードできたかどうかを検証する
	@Test
	void contextLoads() {
		// AssertJを利用した検証を実装する
		// assertThatの引数に検証の値を入れる
		// 続けてメソッドにて期待値を指定。この場合はNullでないこと。
		assertThat(itemController).isNotNull();
		assertThat(itemService).isNotNull();
		assertThat(itemRepository).isNotNull();
	}

}
