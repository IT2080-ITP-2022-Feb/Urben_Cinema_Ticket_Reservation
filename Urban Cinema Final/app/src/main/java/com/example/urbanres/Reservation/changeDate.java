package com.example.urbanres.Reservation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbanres.DB_Handler;
import com.example.urbanres.R;

public class changeDate extends AppCompatActivity {

    public static final int TICKET_PRICE = 500;
    public static final int BOX_TICKET_PRICE = 900;

    DB_Handler db_handler;
    Context context;

    TextView avSeats2, avBox2, totalTckts2, amount2;
    EditText editFullTckts2, editBoxTckts2;
    Button updateBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_date);

        context = this;
        db_handler = new DB_Handler(context);

        avSeats2 = findViewById(R.id.avSeats2);
        avBox2 = findViewById(R.id.avBox2);
        totalTckts2 = findViewById(R.id.totalTckts2);
        amount2 = findViewById(R.id.amount2);
        editFullTckts2 = findViewById(R.id.editFullTckts2);
        editBoxTckts2 = findViewById(R.id.editBoxTckts2);
        updateBtn2 = findViewById(R.id.updateBtn2);

        final String id = getIntent().getStringExtra("ID");

        bookingModel bModel = db_handler.getSingleBooking(Integer.parseInt(id));

        //display previous booked no. of tickets
        editFullTckts2.setText(bModel.getN_tickets());
        editBoxTckts2.setText(bModel.getBox_tickets());

        String date = bModel.getDate();
        String time = bModel.getTime();
        String movieName = bModel.getMovieName();

        //update button
        updateBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String totalAmount = amount2.getText().toString();
                String fullTickets = editFullTckts2.getText().toString();
                String boxTickets = editBoxTckts2.getText().toString();

                bookingModel bModel = new bookingModel(Integer.parseInt(id), fullTickets, boxTickets, date, time, totalAmount, movieName);
                int status = db_handler.updateBooking(bModel);
                if (status == 1){
                    startActivity(new Intent(context, displayBooking.class));
                    Toast.makeText(changeDate.this, "Booking Updated Successfully!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(changeDate.this, "Booking Not Updated!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void calculateEditTickets(View view){
        int FullTickets = 0;
        int BoxTickets = 0;
        int total = 0;

        FullTickets = Integer.parseInt(editFullTckts2.getText().toString());
        BoxTickets = Integer.parseInt(editBoxTckts2.getText().toString());
        total = FullTickets + BoxTickets;

        avSeats2.setText(String.valueOf(200 - FullTickets));
        avBox2.setText(String.valueOf(15 - BoxTickets));
        totalTckts2.setText(String.valueOf(total));

        int ticketAmount = FullTickets * TICKET_PRICE;
        int boxTicketAmount = BoxTickets * BOX_TICKET_PRICE;
        int totalAmount = ticketAmount + boxTicketAmount;

        amount2.setText(String.valueOf("Rs. "+totalAmount));
    }
}