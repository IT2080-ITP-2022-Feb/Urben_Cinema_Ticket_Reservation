package com.example.urbanres.Movies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbanres.DB_Handler;
import com.example.urbanres.R;


public class displayMovies extends AppCompatActivity {


    RecyclerView mRecyclerView;
    DB_Handler databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_view);


        mRecyclerView = findViewById(R.id.recyclerView);
        databaseHelper = new DB_Handler(this);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        showRecord();


    }
    private void showRecord() {
        Adapter adapter = new Adapter(displayMovies.this, databaseHelper.getAllData(DB_Handler.MOVIE_COLUMN_START_DATE+ " DESC"));

        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showRecord();
    }
}
