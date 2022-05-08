package com.example.urbanres.Reviews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbanres.R;


public class Accinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profle);

        TextView profile,theater;

        profile = findViewById(R.id.accinfobtn);
        theater = findViewById(R.id.tratBtn);
    }

    public void nav_prof (View view){

        setContentView(R.layout.account_information);
        Intent intent = new Intent(this, PostReview.class);
        startActivity(intent);
    }
    public void nav_ther (View view){
        setContentView(R.layout.theater_rating);
    }
    public void backto (View view){
        setContentView(R.layout.writereview);
    }
}
