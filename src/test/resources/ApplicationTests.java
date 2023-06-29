package com.Ratings.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

@SpringBootTest
class ApplicationTests {

	@Test
	public void exampleTest() throws Exception{
		ArrayList<ResponseResult> array = new ArrayList<ResponseResult>();
		ArrayList<ResponseResultList> rrlist = new ArrayList<ResponseResultList>();

		ResponseResult responseresult = new ResponseResult();
		ResponseResultList responseresultlist = new ResponseResultList();
		Application app = new Application();

		responseresultlist.setId(1);
		responseresultlist.setTitle("shakugan");
		responseresultlist.setRelease_date("02-06-2020");
		responseresultlist.setOriginal_language("ja");
		responseresultlist.setOverview("Yuji is returning from school when suddenly time stops and monsters appear to devour people. He is not frozen, however. When one of the monsters spots him, he is saved by Shana, the great equalizer, who tells him he's a fading spirit.");
		rrlist.add(responseresultlist);


		responseresult.page = 1;
		responseresult.results = rrlist;

		array.add(responseresult);
		JsonArray jsonArray =  app.arrayToJson(array);

		for (JsonElement jsonElement : jsonArray) {
			String elements = jsonElement.toString();
			assertTrue(elements.contains("id"));
			assertTrue(elements.contains("titulo"));
			assertTrue(elements.contains("data_lancamento"));
			assertFalse(elements.contains("overview"));
		}

	}
}
