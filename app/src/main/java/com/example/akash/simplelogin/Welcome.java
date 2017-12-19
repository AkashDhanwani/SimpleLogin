package com.example.akash.simplelogin;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView tv;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tv = findViewById(R.id.tv);

        sp = getSharedPreferences("UserData",MODE_PRIVATE);

        String name = sp.getString("Fname", "");

        tv.setText("Welcome "+name+" you are succesfully Logged in");
    }
}
