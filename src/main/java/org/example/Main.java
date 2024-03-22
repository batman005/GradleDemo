package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String url = "https://example.com";
        dealingwithOkHttp(url);
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



    public static void dealingWithRetrofit(String url){

    }
}