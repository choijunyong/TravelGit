package com.example.syl.travel.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.syl.travel.R;

public class addTravelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel);

        //Click nextButton
        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTravel2Intent = new Intent(addTravelActivity.this, addTravel2Activity.class);
                addTravelActivity.this.startActivity(addTravel2Intent);
            }
        });

        Button previousButton = (Button) findViewById(R.id.previousButton);
        //Click previousButton
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(addTravelActivity.this, MainActivity.class);
                addTravelActivity.this.startActivity(mainIntent);
            }
        });

        ImageButton closeButton = (ImageButton) findViewById(R.id.closeButton);
        //Click closeButton
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(addTravelActivity.this, MainActivity.class);
                addTravelActivity.this.startActivity(mainIntent);
            }
        });


    }
}
