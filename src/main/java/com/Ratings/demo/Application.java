package com.Ratings.demo;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
    }
    @GetMapping("/search")
	@ResponseBody
    public JsonArray returnMovie(@RequestParam String item){

    ArrayList<ResponseResult> movies = getMovie(item);

    JsonArray array = arrayToJson(movies);

    return array;
	}


  public ArrayList<ResponseResult> getMovie(String pesquisa){
    ArrayList<ResponseResult> movies = new ArrayList<ResponseResult>();
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
    .url("https://api.themoviedb.org/3/search/movie?query="+ pesquisa + "&include_adult=false&language=pt-BR&page=1")
    .get()
    .addHeader("accept", "application/json")
    .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkZDk3ZWEyNmVjMGM2ZDE3ZTdiNzAxMjk1YWM4MjBkZSIsInN1YiI6IjY0OWMyODZiNzdjMDFmMDE0ZTBhZjU5OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.NPU42ssXBnnwPBivQO3RRQQFumkNTT65uQXaaKqnBrI")
    .build();

    try {
      Response response = client.newCall(request).execute();
      Gson gson = new Gson();
      ResponseResult responseResult = gson.fromJson(response.body().string(), ResponseResult.class);
      movies.add(responseResult);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return movies;
  }

  public JsonArray arrayToJson(ArrayList<ResponseResult> movies){
    JsonArray array = new JsonArray();

    for(int i=0;i<movies.get(0).results.size();i++){
      String jsonString = "{\"id\": \""+movies.get(0).results.get(i).getId()+"\" , " + "\"titulo\": \""+movies.get(0).results.get(i).getTitle()+"\" , "+ "\"data_lancamento\": \""+movies.get(0).results.get(i).getRelease_date()+"\"}";
      JsonObject jsonObjectString = (JsonObject) JsonParser.parseString(jsonString);
      System.out.println(jsonObjectString);
      array.add(jsonObjectString);
    }

    return array;
  } 

}