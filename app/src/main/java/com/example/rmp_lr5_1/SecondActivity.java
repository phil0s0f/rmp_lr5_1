package com.example.rmp_lr5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        String name = "";
        String fam = "";
        if (extras != null) {
            name = extras.getString(MainActivity.NAME);
            fam = extras.getString(MainActivity.FAM);
            TextView textOut = findViewById(R.id.textOut);
            textOut.setText(name + " " + fam);
        }
        Button buttonHello = findViewById(R.id.buttonHello);

        buttonHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = getIntent().getExtras();
                String message = "";
                if (extras != null) {
                    String name = extras.getString(MainActivity.NAME);
                    String fam = extras.getString(MainActivity.FAM);
                    TextView textOut = findViewById(R.id.textOut);
                    message = "Привет, " + name + " " + fam + "!";
                }
                Intent data = new Intent();
                data.putExtra(MainActivity.ACCESS_MESSAGE, message);
                setResult(RESULT_OK, data);
                finish();
            }
        });
        Button buttonNameFam = findViewById(R.id.buttonNameFam);
        buttonNameFam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = getIntent().getExtras();
                String message = "";
                if (extras != null) {
                    String name = extras.getString(MainActivity.NAME);
                    String fam = extras.getString(MainActivity.FAM);
                    TextView textOut = findViewById(R.id.textOut);
                    message = name + "! Ваша фамилия " + fam + "!";
                }
                Intent data = new Intent();
                data.putExtra(MainActivity.ACCESS_MESSAGE, message);
                setResult(RESULT_OK, data);
                finish();
            }
        });
        Button buttonFamName = findViewById(R.id.buttonFamName);
        buttonFamName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = getIntent().getExtras();
                String message = "";
                if (extras != null) {
                    String name = extras.getString(MainActivity.NAME);
                    String fam = extras.getString(MainActivity.FAM);
                    TextView textOut = findViewById(R.id.textOut);
                    message = fam + " " + name;
                }
                Intent data = new Intent();
                data.putExtra(MainActivity.ACCESS_MESSAGE, message);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}