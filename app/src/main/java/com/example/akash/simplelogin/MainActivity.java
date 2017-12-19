package com.example.akash.simplelogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etFname, etLname, etUsername, etPassword;
    Button btnAdd;
    SharedPreferences spn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        etFname = findViewById(R.id.etFname);
        etLname = findViewById(R.id.etLname);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        spn1 = getSharedPreferences("UserData",MODE_PRIVATE);

        if(spn1.getBoolean("ne",false) == false) {
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String Fname = etFname.getText().toString();
                    String Lname = etLname.getText().toString();
                    String Username = etUsername.getText().toString();
                    String Password = etPassword.getText().toString();

                    if(Fname.length() == 0)
                    {
                        etFname.setError("Please enter Name");
                        etFname.requestFocus();
                        return;
                    }

                    if(Lname.length() == 0)
                    {
                        etLname.setError("Please enter Name");
                        etLname.requestFocus();
                        return;
                    }
                    if(Username.length() == 0)
                    {
                        etUsername.setError("Please enter Name");
                        etUsername.requestFocus();
                        return;
                    }
                    if(Password.length() == 0)
                    {
                        etPassword.setError("Please enter Name");
                        etPassword.requestFocus();
                        return;
                    }

                    SharedPreferences.Editor editor = spn1.edit();
                    editor.putString("Fname", Fname);
                    editor.putString("Lname", Lname);
                    editor.putString("Username", Username);
                    editor.putString("Password", Password);
                    editor.putBoolean("ne",true);
                    editor.commit();
                    Intent i = new Intent(getApplicationContext(),Login.class);
                    startActivity(i);
                    finish();
                }
            });
        }
        else {
            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();
        }

    }
}
