package com.example.urbanres.Reservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbanres.DB_Handler;
import com.example.urbanres.MainActivity;
import com.example.urbanres.R;

//import com.example.blueskycinema.Hasith.add_movies;


public class Summery extends AppCompatActivity {

    //private ArrayList<add_movies> arrayList;

    TextView print_date1, print_time1, print_tot1;
    ImageView bl_moviePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summery);

        DB_Handler db_handler = new DB_Handler(this);

        Intent newIntent = getIntent();
        String selected_date = newIntent.getStringExtra("SELECTED_DATE");
        String selected_time = newIntent.getStringExtra("SELECTED_TIME");
        String total_amount = newIntent.getStringExtra("TOTAL_AMOUNT");

        print_date1 = findViewById(R.id.bl_date);
        print_time1 = findViewById(R.id.bl_time);
        print_tot1 = findViewById(R.id.bl_amount);
        bl_moviePoster = findViewById(R.id.bl_moviePoster);

        print_date1.setText(selected_date);
        print_time1.setText(selected_time);
        print_tot1.setText(total_amount);
        bl_moviePoster.setImageBitmap(db_handler.getImg(1));

    }

    public void confirmButton(View view){
        Intent newIntent = getIntent();
        //booked tickets
        String fullTicket = newIntent.getStringExtra("TOTAL_FULL_TICKETS");
        String boxTickets = newIntent.getStringExtra("TOTAL_BOX_TICKETS");

        //avilable tickets
//        String available_full_seats = newIntent.getStringExtra("AVAILABLE_FULL_SEATS");
//        String available_box_seats = newIntent.getStringExtra("AVAILABLE_BOX_SEATS");

        DB_Handler db_handler = new DB_Handler(this);

        long val = db_handler.addBooking(fullTicket, boxTickets, print_date1.getText().toString(), print_time1.getText().toString(), print_tot1.getText().toString(), "m1");

        if(val > 0){
            setContentView(R.layout.activity_main);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            Toast.makeText(this, "Booking created!!!", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Data not inserted!!!", Toast.LENGTH_SHORT).show();
        }
    }
}