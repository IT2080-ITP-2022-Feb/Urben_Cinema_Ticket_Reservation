package com.example.urbanres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.urbanres.Movies.Login;
import com.example.urbanres.Movies.add_movies;
import com.example.urbanres.Reservation.ReserveNowActivity;
import com.example.urbanres.Reservation.displayBooking;
import com.example.urbanres.Reviews.PostReview;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startup (View view){
        setContentView(R.layout.login);
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void loadAddMovies (View view){
        setContentView(R.layout.add_movies);
        Intent intent = new Intent(this, add_movies.class);

        setContentView(R.layout.activity_main);


    }

    public void loadReserveActivity(View view){
        setContentView(R.layout.activity_reserve_now);


        Intent intent = new Intent(this, ReserveNowActivity.class);
        startActivity(intent);
    }
    public void loadReview (View view){
        setContentView(R.layout.writereview);
        Intent intent = new Intent(this, PostReview.class);
        startActivity(intent);
    }

    public void loadReasevations(View view){
        setContentView(R.layout.activity_display_booking);

        Intent intent = new Intent(this, displayBooking.class);

        startActivity(intent);
    }
}