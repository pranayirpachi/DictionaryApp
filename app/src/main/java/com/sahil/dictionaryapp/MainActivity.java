package com.sahil.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.sahil.dictionaryapp.Adapter.MeaningAdapter;
import com.sahil.dictionaryapp.Adapter.PhoneticAdapter;
import com.sahil.dictionaryapp.Models.APIResponse;
import com.sahil.dictionaryapp.Models.RequestManager;


public class MainActivity extends AppCompatActivity {
    SearchView search_view;
    TextView textView_word;
    RecyclerView recyclerView_phoetic;
    RecyclerView recyclerView_meaning;
    ProgressDialog progressDialog;
    PhoneticAdapter phoneticAdapter;
    MeaningAdapter meaningAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search_view = findViewById(R.id.search_view);
        textView_word = findViewById(R.id.textView_word);
        recyclerView_phoetic = findViewById(R.id.recycler_phonetics);
        recyclerView_meaning = findViewById(R.id.recycler_meanings);
        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Loading...");
        //progressDialog.show();
        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getWordDMeaning(listener,"hello");

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching response for " + query);
                progressDialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getWordDMeaning(listener,query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });








    }

    private final OnFetchDataListner listener = new OnFetchDataListner() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            progressDialog.dismiss();
            if(apiResponse==null){
                Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiResponse);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onErrorData(String message) {

        }
    };

    private void showData(APIResponse apiResponse) {
        textView_word.setText("word:" + apiResponse.getWord());
        recyclerView_phoetic.setHasFixedSize(true);
        recyclerView_phoetic.setLayoutManager(new GridLayoutManager(this,1));

        phoneticAdapter = new PhoneticAdapter(this,apiResponse.getPhonetics());
        recyclerView_phoetic.setAdapter(phoneticAdapter);

        recyclerView_meaning.setHasFixedSize(true);
        recyclerView_meaning.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter = new MeaningAdapter(this,apiResponse.getMeanings());
        recyclerView_meaning.setAdapter(meaningAdapter);


    }
}