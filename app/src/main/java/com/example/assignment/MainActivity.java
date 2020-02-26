package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.assignment.Models.Docs;
import com.example.assignment.Models.Model;
import com.example.assignment.Reterofit.NetworkClient;
import com.example.assignment.Reterofit.RequestService;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    ArrayList<Docs> docs = new ArrayList<>();
    ArrayList<String> text = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar progressBar=findViewById(R.id.progress_bar);

        final RecyclerView recyclerView=findViewById(R.id.recyclerview);
        final RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(getApplicationContext(),text);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = NetworkClient.getRetrofitClient();
        final RequestService requestService=retrofit.create(RequestService.class);
        Call<Model> call=requestService.requestGet();

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                progressBar.setVisibility(View.INVISIBLE);

                docs =new ArrayList<>((Arrays.asList(response.body().getResponse().getDocs())));

                for (int i = 0; i < docs.size(); i++) {
                    text.add(docs.get(i).getTitle_display());
                }
                recyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
            }
        });
    }
}
