package Lesson_18;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TinyURL tinyURL = new Retrofit.Builder()
                .baseUrl("http://tiny-url.info/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TinyURL.class);

        try {
            Response<TinyURL.TinyURLResponse> response = tinyURL.shortenURL("json", "https://img4.goodfon.ru/wallpaper/big/2/26/prioda-liod-laguna-pliazh-islandiia-vyderzhka.jpg").execute();
            if (response.isSuccessful()){
                System.out.println("state: "+response.body().state);
                System.out.println("longurl: "+response.body().longURL);
                System.out.println("shorturl: "+response.body().shortURL);
            }else {
                System.out.println(response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
