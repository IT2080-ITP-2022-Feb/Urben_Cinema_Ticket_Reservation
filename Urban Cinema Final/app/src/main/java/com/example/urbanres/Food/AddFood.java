package com.example.urbanres.Food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbanres.DB_Handler;
import com.example.urbanres.R;


public class AddFood extends AppCompatActivity {

    EditText editTextTextPersonName3,editTextTextPersonName5;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName7);
        editTextTextPersonName5 = findViewById(R.id.editTextTextPersonName8);
        context=this;
    }

    public void submitFood (View view) {
        DB_Handler db = new DB_Handler(this);
        long val = db.addFood(editTextTextPersonName3.getText().toString(),editTextTextPersonName5.getText().toString());
        if(val > 0){
            Toast.makeText(this, "Data inserted successfully!!!", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Data not inserted!!!", Toast.LENGTH_SHORT).show();
        }

        startActivity(new Intent(context, FoodList.class));
    }
}





