package com.example.syl.travel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.syl.travel.R;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Logout= (Button) findViewById(R.id.LogoutButton);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
                    @Override
                    public void onCompleteLogout() {
                        Intent LogoutIntent = new Intent(MainActivity.this, LoginActivity.class);
                        MainActivity.this.startActivity(LogoutIntent);
                    }
                });
            }
        });

        ImageButton addTravelButton = (ImageButton) findViewById(R.id.addTravelButton);
        addTravelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTravelIntent = new Intent(MainActivity.this, addTravelActivity.class);
                MainActivity.this.startActivity(addTravelIntent);
            }
        });
    }
}
