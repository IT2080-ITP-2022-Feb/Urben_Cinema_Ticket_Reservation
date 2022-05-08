package com.example.urbanres.Reservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbanres.R;

public class Tickets extends AppCompatActivity {

    //No of seats in the theater
    public static final int NO_OF_SEATS = 200;
    public static final int NO_OF_BOX_SEATS = 15;

    public static final int TICKET_PRICE = 500;
    public static final int BOX_TICKET_PRICE = 900;

    EditText editFullTckts, editBoxTckts;
    TextView totalTckts, amount1, avSeats1, avBox1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        editFullTckts = findViewById(R.id.editFullTckts);
        editBoxTckts = findViewById(R.id.editBoxTckts);
        totalTckts = findViewById(R.id.totalTckts);
        amount1 = findViewById(R.id.amount2);
        avSeats1 = findViewById(R.id.avSeats2);
        avBox1 = findViewById(R.id.avBox2);

    }

    public void calculateTickets(View view){
        int FullTickets = 0;
        int BoxTickets = 0;
        int total = 0;

        FullTickets = Integer.parseInt(editFullTckts.getText().toString());
        BoxTickets = Integer.parseInt(editBoxTckts.getText().toString());
        total = FullTickets + BoxTickets;

        avSeats1.setText(String.valueOf(NO_OF_SEATS - FullTickets));
        avBox1.setText(String.valueOf(NO_OF_BOX_SEATS - BoxTickets));
        totalTckts.setText(String.valueOf(total));

        int ticketAmount = FullTickets * TICKET_PRICE;
        int boxTicketAmount = BoxTickets * BOX_TICKET_PRICE;
        int totalAmount = ticketAmount + boxTicketAmount;

        amount1.setText(String.valueOf("Rs. "+totalAmount));
    }

    //continue button
    public void loadActivitySummery(View v){
        //validations
        if (editFullTckts.length() == 0) {
            editFullTckts.setError("Enter a number");
        }
        else if(editBoxTckts.length() == 0) {
            editBoxTckts.setError("Enter a number");
        }
        else {
            //get data from previous activity
            Intent newIntent = getIntent();
            String selected_date = newIntent.getStringExtra("SELECTED_DATE");
            String selected_time = newIntent.getStringExtra("SELECTED_TIME");

            //Create intent for next activity
            setContentView(R.layout.activity_summery);
            Intent intent = new Intent(this, Summery.class);
            String totalAmount = amount1.getText().toString();
            String fullTickets = editFullTckts.getText().toString();
            String boxTickets = editBoxTckts.getText().toString();
//       String avFullSeats = avSeats1.getText().toString();
//    String avBoxSeats = avBox1.getText().toString();

            intent.putExtra("SELECTED_DATE", selected_date);
            intent.putExtra("SELECTED_TIME", selected_time);
            intent.putExtra("TOTAL_AMOUNT", totalAmount);
            intent.putExtra("TOTAL_FULL_TICKETS", fullTickets);
            intent.putExtra("TOTAL_BOX_TICKETS", boxTickets);
//      intent.putExtra("AVAILABLE_FULL_SEATS", avFullSeats);
//      intent.putExtra("AVAILABLE_BOX_SEATS", avBoxSeats);

            startActivity(intent);
        }
    }

}