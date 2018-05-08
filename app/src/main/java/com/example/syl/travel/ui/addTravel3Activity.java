package com.example.syl.travel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.syl.travel.R;

public class addTravel3Activity extends AppCompatActivity {

    static int []count= new int[]{0, 0, 0, 0, 0, 0, 0};
    private View.OnClickListener btnListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel3);

        /*********************Click nextButton***********************/
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTravel4Intent = new Intent(addTravel3Activity.this, addTravel4Activity.class);
                addTravel3Activity.this.startActivity(addTravel4Intent);

            }

        });

        /*********************Click previousButton***********************/
        Button previousButton = (Button) findViewById(R.id.previousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTravel2Intent = new Intent(addTravel3Activity.this, addTravel2Activity.class);
                addTravel3Activity.this.startActivity(addTravel2Intent);
            }
        });


        /*********************Click closeButton***********************/
        ImageButton closeButton = (ImageButton) findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(addTravel3Activity.this, MainActivity.class);
                addTravel3Activity.this.startActivity(mainIntent);
            }
        });



        /*********************Click personButton   &&    Change the textfield***********************/
        final ImageButton []personButton= new ImageButton[7];
        int []personId= {R.id.person1,R.id.person2,R.id.person3,R.id.person4,R.id.person5,R.id.person6,R.id.person7};
        final TextView totalNum = (TextView) findViewById(R.id.totalNumText);

        //Input the button Id to personButton[]
        for(int i = 0; i < 7; i++)
        {
                personButton[i] = (ImageButton)findViewById(personId[i]);
        }

        //Click Event
         btnListener = new View.OnClickListener()
         {
                @Override
                public void onClick(View v)
                {
                    System.out.println("확인용: 온클릭 들어옴");
                    for(int i = 0; i < 7; i++){
                        if(v.getId() == personButton[i].getId())
                        {
                            if(count[i]==0)
                            {
                                for(int j=0; j<=i; j++) {
                                    personButton[j].setImageResource(R.drawable.ic_man);
                                }
                                for(int k=i+1; k<7; k++ ) {
                                    personButton[k].setImageResource(R.drawable.ic_empty);
                                    count[k]=0;
                                }
                                for(int l=0; l<7; l++) {
                                    count[l]=0;
                                }
                                count[i] = 1; //누른 버튼만 count 1로 셋팅
                                totalNum.setText("총 "+ (i+1) +" 명");
                            }
                            else {
                                for(int j=0; j<=i; j++)
                                {
                                    personButton[j].setImageResource(R.drawable.ic_empty);
                                }
                                totalNum.setText("총 0 명");
                                count[i]=0;
                            }
                        }
                    }
                }
         };

        //Register ClickListener
         for(int k = 0; k < 7; k++)
         {
            personButton[k].setOnClickListener(btnListener);
         }
    }
}
