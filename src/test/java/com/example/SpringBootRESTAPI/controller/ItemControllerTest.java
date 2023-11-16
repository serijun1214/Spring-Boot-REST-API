package com.example.SpringBootRESTAPI.controller;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.SpringBootRESTAPI.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {
	
	@Autowired
	private MockMvc mvc;

	// 検索結果が想定通りであるかを確認するテスト
	@Test
	void testGetItem() throws Exception {
		int itemId = 1;
		String responseJsonString = mvc.perform(get("/items/{itemId}", itemId)
				.contentType(MediaType.APPLICATION_JSON)
				 // 非推奨であるが現時点では入れる必要あり
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.characterEncoding("UTF-8"))
				// ステータスコードチェック
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		
		// 取得したJsonオブジェクトをJavaオブジェクトにマッピング
		ObjectMapper objectMapper = new ObjectMapper();
		Item responseItem = objectMapper.readValue(responseJsonString, Item.class);
		
		// 各値を比較する
		assertThat(responseItem.getItemId()).isEqualTo(1L);
		assertThat(responseItem.getItemName()).isEqualTo("ネックレス");
		assertThat(responseItem.getItemCategory()).isEqualTo("ジュエリ");
	}

}
