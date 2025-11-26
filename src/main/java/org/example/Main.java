package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {

    // Proper main method
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        String url = "https://jsonplaceholder.typicode.com/todos/1";

        try {
            String result = run(client, url);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // run() method MUST be outside main()
    public static String run(OkHttpClient client, String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
