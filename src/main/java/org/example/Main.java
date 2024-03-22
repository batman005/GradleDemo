package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String url = "https://example.com";
        dealingwithOkHttp(url);

        dealingWithRetrofit("https://jsonplaceholder.typicode.com/");
    }

    public static void dealingwithOkHttp(String url){
        //helps to do http Calls easily raw java is complicated
        OkHttpClient client = new OkHttpClient();

//        String url = "https://jsonplaceholder.typicode.com/todos/1";


        //builder pattern
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()){
          if(response.isSuccessful() && response.body() != null){
              System.out.println("------ OKHTTP-------");
              System.out.println(response.body().string());
              System.out.println("-----------------------");
          } else {
              System.out.println("Something went wrong");
          }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }


    public static void dealingWithRetrofit(String url) {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            TodoService todoService = retrofit.create(TodoService.class);

            Todo t = todoService.getTodoById("5").execute().body();
            System.out.println("------------------------Retrofit Response-------------------------");
            System.out.println("Todo Object downloaded is " + t.toString());
            System.out.println("----------------------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
