package com.example.akash.simplelogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText etUsername1, etPassword1;
    Button btnLogin;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername1 = findViewById(R.id.etUsername1);
        etPassword1 = findViewById(R.id.etPassword1);
        btnLogin = findViewById(R.id.btnLogin);

        sp = getSharedPreferences("UserData",MODE_PRIVATE);

        final String name = sp.getString("Username", "");
        final String password = sp.getString("Password", "");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etName = etUsername1.getText().toString();
                String etpassword = etPassword1.getText().toString();

                if(name.compareTo(etName) == 0 && password.compareTo(etpassword) == 0)
                {
                    Intent i = new Intent(getApplicationContext(), Welcome.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(Login.this, "Unsuccesful Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
