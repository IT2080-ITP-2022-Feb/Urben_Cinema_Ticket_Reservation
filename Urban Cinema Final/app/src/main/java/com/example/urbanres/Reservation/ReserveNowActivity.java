package com.example.urbanres.Reservation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbanres.R;

import java.util.Calendar;

public class ReserveNowActivity extends AppCompatActivity {

    TextView tv_showDate;
    RadioGroup radioGroup2;
    RadioButton time1, time2, time3;
    private String selectedType="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_now);


        //calendar implementation
        ImageView ivCalender = findViewById(R.id.ivCalender);
        tv_showDate = findViewById(R.id.tv_showDate);


        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        ivCalender.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ReserveNowActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv_showDate.setText(year + " - " + (month + 1) + " - " + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });

        //Select movie time
        radioGroup2 = findViewById(R.id.radioGroup2);
        time1 = findViewById(R.id.time1);
        time2 = findViewById(R.id.time2);
        time3 = findViewById(R.id.time3);


        time1.setSelected(true);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.time1){
                    selectedType = time1.getText().toString();
                }else if(i==R.id.time2){
                    selectedType = time2.getText().toString();
                }else{
                    selectedType = time3.getText().toString();
                }
            }
        });
    }


    //continue button
    public void loadActivityTickets(View v){
        setContentView(R.layout.activity_tickets);
        //GET MOVIE ID
        Intent newIntent = getIntent();
        String movieId = newIntent.getStringExtra("MOVIE_ID");

        Intent intent = new Intent(this, Tickets.class);

        String date = tv_showDate.getText().toString();
        intent.putExtra("SELECTED_DATE", date);
        intent.putExtra("SELECTED_TIME", selectedType);
        intent.putExtra("MOVIE_ID", movieId);

        startActivity(intent);
    }
}