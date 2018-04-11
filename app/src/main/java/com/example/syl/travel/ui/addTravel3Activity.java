package com.example.syl.travel.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.example.syl.travel.R;

public class addTravel3Activity extends AppCompatActivity {

    static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel3);

        Button nextButton = findViewById(R.id.nextButton);

        //Click nextButton
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTravel4Intent = new Intent(addTravel3Activity.this, addTravel4Activity.class);
                addTravel3Activity.this.startActivity(addTravel4Intent);

            }

        });


        Button previousButton = (Button) findViewById(R.id.previousButton);

        //Click previousButton
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTravel2Intent = new Intent(addTravel3Activity.this, addTravel2Activity.class);
                addTravel3Activity.this.startActivity(addTravel2Intent);
            }
        });

        ImageButton closeButton = (ImageButton) findViewById(R.id.closeButton);
        //Click closeButton
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(addTravel3Activity.this, MainActivity.class);
                addTravel3Activity.this.startActivity(mainIntent);
            }
        });

        final ImageButton person1 = (ImageButton) findViewById(R.id.person1);


        person1.setOnClickListener(new View.OnClickListener() {

            @Override
             public void onClick(View view) {
                        count++;
                        if(count%2 == 1)
                            person1.setImageResource(R.drawable.ic_man);
                        else
                            person1.setImageResource(R.drawable.ic_empty);

                }
         });




    }
}
