package com.example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class insert extends AppCompatActivity {
    EditText gmail, password, reenter, phone, city, BG, address;
    Button regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        gmail = findViewById(R.id.gmail);
        password = findViewById(R.id.password);
        reenter = findViewById(R.id.reenter);
        phone = findViewById(R.id.phone);
        city = findViewById(R.id.city);
        BG = findViewById(R.id.BG);
        address = findViewById(R.id.address);
        regbtn = (Button)findViewById(R.id.regbtn);



    regbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            logindata log = new logindata();
            log.setAddress(address.getText().toString());
            log.setBg(BG.getText().toString());
            log.setCity(city.getText().toString());
            log.setGmail(gmail.getText().toString());
            log.setPassword(password.getText().toString());
            log.setReenter(reenter.getText().toString());
            MyDb dbHandler = new MyDb(insert.this);
            dbHandler.added(log, "10");
        }
        });

}

        }