package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //helps to do http Calls easily raw java is complicated
        OkHttpClient client = new OkHttpClient();

//        String url = "https://jsonplaceholder.typicode.com/todos/1";
          String url = "https://example.com";

        //builder pattern
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()){
                System.out.println("Something went wrong !!!");
            }
            System.out.println(response.body().string());
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}