package com.example.syl.travel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.example.syl.travel.R;


public class addTravel2Activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel2);

        Button nextButton = findViewById(R.id.nextButton);

        //Click nextButton
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTravel3Intent = new Intent(addTravel2Activity.this, addTravel3Activity.class);
                addTravel2Activity.this.startActivity(addTravel3Intent);

            }

        });

        Button previousButton = (Button) findViewById(R.id.previousButton);

        //Click previousButton
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTravelIntent = new Intent(addTravel2Activity.this, addTravelActivity.class);
                addTravel2Activity.this.startActivity(addTravelIntent);
            }
        });

        ImageButton closeButton = (ImageButton) findViewById(R.id.closeButton);
        //Click closeButton
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(addTravel2Activity.this, MainActivity.class);
                addTravel2Activity.this.startActivity(mainIntent);
            }
        });
    }
}
