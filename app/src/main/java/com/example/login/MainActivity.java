package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {
    EditText gmail1, password1;
    Button login;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gmail1 = findViewById(R.id.gmail);
        password1 = findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            logindata log = new logindata();
            log.setGmail1(gmail1.getText().toString());
            log.setPassword1(password1.getText().toString());
            Db dbHandler = new Db(MainActivity.this);
            dbHandler.added(log, "10");

        }
    });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,insert.class);
                startActivity(i);
            }
        });
            }

        }
