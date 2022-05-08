package com.example.urbanres.Reservation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbanres.DB_Handler;
import com.example.urbanres.R;

public class displayBooking extends AppCompatActivity {

    RecyclerView recyclerView1;
    DB_Handler databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_booking);

        recyclerView1 = findViewById(R.id.recyclerView_new);
        databaseHelper = new DB_Handler(this);
        showRecord();
    }

    private void showRecord() {
        com.example.urbanres.Reservation.reservationListAdapter myAdapter = new com.example.urbanres.Reservation.reservationListAdapter(displayBooking.this, databaseHelper.getBookingList());
        recyclerView1.setAdapter(myAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showRecord();
    }
}