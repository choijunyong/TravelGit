package com.example.syl.travel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.syl.travel.R;

public class addTravel4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel4);

        Button nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(addTravel4Activity.this, MainActivity.class);
                addTravel4Activity.this.startActivity(mainIntent);

            }

        });

        Button previousButton = (Button) findViewById(R.id.previousButton);

        //Click previousButton
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTravel3Intent = new Intent(addTravel4Activity.this, addTravel3Activity.class);
                addTravel4Activity.this.startActivity(addTravel3Intent);
            }
        });


        ImageButton closeButton = (ImageButton) findViewById(R.id.closeButton);
        //Click closeButton
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(addTravel4Activity.this, MainActivity.class);
                addTravel4Activity.this.startActivity(mainIntent);
            }
        });
    }

}
