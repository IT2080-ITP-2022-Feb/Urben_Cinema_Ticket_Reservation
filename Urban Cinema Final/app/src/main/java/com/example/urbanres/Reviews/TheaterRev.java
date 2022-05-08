package com.example.urbanres.Reviews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbanres.DB_Handler;
import com.example.urbanres.R;


import java.text.DateFormat;
import java.util.Calendar;


public class TheaterRev extends AppCompatActivity {
    EditText theaterRev;
    Button feedback_btn;
    RatingBar rtT;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theater_rating);

        theaterRev = findViewById(R.id.theaterRev);
        feedback_btn = findViewById(R.id.feedback_btn);
        rtT = findViewById(R.id.theater_ratingBar);
    }

    public void submitTheaterRev(View view) {
        DB_Handler DB = new DB_Handler(this);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        long info = DB.addTheterRev(theaterRev.getText().toString(),String.valueOf(rtT.getRating()),currentDate);
        if (info > 0) {
            Toast.makeText(this, "Thank you!", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.profle);
            Intent intent = new Intent(this, Accinfo.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "UnSuccessful", Toast.LENGTH_SHORT).show();
        }
    }
}
