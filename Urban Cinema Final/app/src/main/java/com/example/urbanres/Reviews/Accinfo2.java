package com.example.urbanres.Reviews;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbanres.R;

public class Accinfo2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_information);

        Button savebtn;

        savebtn = findViewById(R.id.backBtn);

    }

    public void nav_back (View view){
        setContentView(R.layout.profle);
    }

}
