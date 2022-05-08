package com.example.urbanres.Reviews;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbanres.DB_Handler;
import com.example.urbanres.R;


public class GetReviews extends AppCompatActivity {

    TextView countRev,avgRating;
    RatingBar main_rating_bar;
    ImageView msgIcon;
    RecyclerView rcView;
    DB_Handler databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews);
        DB_Handler DB = new DB_Handler(this);
        GetReviews context = this;

        countRev = findViewById(R.id.totRatingtxt);
        avgRating = findViewById(R.id.avg_ratingtxt);
        main_rating_bar = findViewById(R.id.main_rating_bar);
        msgIcon = findViewById(R.id.writereview_btn);
        //set reviews count
        int count = DB.countReviews();
        countRev.setText(count + " Reviews");

        //set rating count
        float rateCount = DB.countRating();
        float avg = rateCount / 5;
        avgRating.setText(avg + "/5");
        main_rating_bar.setRating(avg / 2);

        //get all Reviews
        rcView = findViewById(R.id.recyView);
        databaseHelper = new DB_Handler(this);

        showRecord();

    }
    private void showRecord() {
        RevAddapter adapter = new RevAddapter(GetReviews.this, databaseHelper.getAllReviews(DB_Handler.REVIEWS_COLUMN_DATE+ " DESC"));
        rcView.setAdapter(adapter);
        rcView.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    protected void onResume() {
        super.onResume();
        showRecord();
    }

    public void addRevBtn (View view){
        setContentView(R.layout.writereview);
    }



}
