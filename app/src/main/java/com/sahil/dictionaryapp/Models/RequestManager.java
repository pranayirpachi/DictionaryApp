package com.sahil.dictionaryapp.Models;

import android.content.Context;
import android.widget.Toast;

import com.sahil.dictionaryapp.OnFetchDataListner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RequestManager
{
    Context context;

   Retrofit retrofit = new Retrofit.Builder()
           .baseUrl("https://api.dictionaryapi.dev/api/v2/")
           .addConverterFactory(GsonConverterFactory.create())
           .build();


    public RequestManager(Context context) {
        this.context = context;
    }

    public void getWordDMeaning(OnFetchDataListner listner,String word){
        CallBuilder callBuilder = retrofit.create(CallBuilder.class);
        Call<List<APIResponse>> call = callBuilder.callmeanings(word);

        try {
            call.enqueue(new Callback<List<APIResponse>>() {
                @Override
                public void onResponse(Call<List<APIResponse>> call, Response<List<APIResponse>> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    listner.onFetchData(response.body().get(0),response.message());
                }

                @Override
                public void onFailure(Call<List<APIResponse>> call, Throwable t) {
                    listner.onErrorData("Request Failed");

                }
            });
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(context, "An Error occurence", Toast.LENGTH_SHORT).show();

        }
    }
    public interface CallBuilder{
        @GET("entries/en/{word}")
        Call<List<APIResponse>> callmeanings(
            @Path("word") String word

        );
    }
}
