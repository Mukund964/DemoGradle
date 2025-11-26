package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Main {

    // Proper main method
    public static void main (String[] args) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        String url = "https://jsonplaceholder.typicode.com/todos/1";
//
//        try {
//            String result = run(client, url);
//            System.out.println(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
         Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoService todoService = retrofit.create(TodoService.class);
        Todo t = todoService.getTodoById("5").execute().body();

        System.out.println("Todo object downloaded is" + t.toString());
    }

    // run() method MUST be outside main()
//    public static String run(OkHttpClient client, String url) throws IOException {
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();
//        }
//    }
}
