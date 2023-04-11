package com.example.rmp_lr5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText nameBox;
    private EditText famBox;
    private Button button;
    static final String NAME = "NAME";
    static final String FAM = "FAM";
    static final String ACCESS_MESSAGE = "ACCESS";
    private static final int REQUEST_ACCESS_TYPE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textOutput);
        nameBox = findViewById(R.id.editTextName);
        famBox = findViewById(R.id.editTextFam);
        button = findViewById(R.id.buttonSend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameBox.getText().toString();
                String fam = famBox.getText().toString();
                Intent intent = new Intent
                        (MainActivity.this, SecondActivity.class);
                intent.putExtra(NAME, name);
                intent.putExtra(FAM, fam);
                startActivityForResult(intent, REQUEST_ACCESS_TYPE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ACCESS_TYPE)
            if (resultCode == RESULT_OK) {
                String accessMessage = data.getStringExtra(ACCESS_MESSAGE);
                textView.setText(accessMessage);
            } else
                textView.setText("Ошибка доступа");
    }
}