package com.example.lr01_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    static String EXTRA_LITERS = "EXTRA_LITERS";
    static String EXTRA_GALLONS = "EXTRA_GALLONS";
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        textView = findViewById(R.id.textView5);
        textView2 = findViewById(R.id.textView6);

        Intent intent = getIntent();
        double liters = intent.getDoubleExtra(EXTRA_LITERS, 1000);
        double gallons = intent.getDoubleExtra(EXTRA_GALLONS, 264.17);

        textView.setText(String.valueOf(liters));
        textView2.setText(String.valueOf(gallons));
    }
}
