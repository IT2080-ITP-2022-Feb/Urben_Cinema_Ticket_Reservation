package com.example.urbanres.Food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbanres.DB_Handler;
import com.example.urbanres.R;


public class FoodList extends AppCompatActivity {
    TextView count;
    Context context;
    RecyclerView mRecyclerView;
    DB_Handler databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        mRecyclerView = findViewById(R.id.recyclerView);
        databaseHelper = new DB_Handler(this);

        showRecord();

        count=findViewById(R.id.foodCount);
        context= this;

        //Get food count from the table
        int countFoodList = databaseHelper.countFoodList();
        count.setText("There are "+countFoodList+" food items");
    }
        private void showRecord() {
            com.example.urbanres.Food.FoodAdapter adapter = new com.example.urbanres.Food.FoodAdapter(FoodList.this, databaseHelper.getAllFoodData(DB_Handler.FOOD_COLUMN_NAME+ " DESC"));
                mRecyclerView.setAdapter(adapter);
        }
        @Override
         protected void onResume() {
            super.onResume();
            showRecord();
        }

        public void loadAddFood (View view){
            setContentView(R.layout.activity_add_food);
            Intent intent = new Intent(this, AddFood.class);
            startActivity(intent);
        }


}

