package com.example.urbanres.Movies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbanres.DB_Handler;
import com.example.urbanres.R;


public class startup extends AppCompatActivity {

    public void home (View view){
        setContentView(R.layout.main_view);
        Intent intent = new Intent(this, displayMovies.class);
        startActivity(intent);
    }

}
