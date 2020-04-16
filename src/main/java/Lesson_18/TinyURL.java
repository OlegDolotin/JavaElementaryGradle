package Lesson_18;

import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TinyURL {

    @POST("random")
    @FormUrlEncoded
    Call<TinyURLResponse> shortenURL(@Field("format") String format,@Field("url") String url);


    class TinyURLResponse{
        public String state;

        @SerializedName("longurl")
        public String longURL;

        @SerializedName("shorturl")
        public String shortURL;
    }

}
